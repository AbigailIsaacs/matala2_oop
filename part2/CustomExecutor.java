package part2;

import part2.Task;

import java.util.concurrent.*;
public class CustomExecutor extends ThreadPoolExecutor{

    private final int corePoolSize;
    private final int maximumPoolSize;
    private final long keepAliveTime;
    private final TimeUnit unit;

    private PriorityBlockingQueue<Runnable> workQueue = new PriorityBlockingQueue<>();
    private int maxPriority= Integer.MAX_VALUE;

    public CustomExecutor() {
        super(10,20,
                300,TimeUnit.MILLISECONDS, new PriorityBlockingQueue<>());

        int numProcessors = Runtime.getRuntime().availableProcessors();
        this.corePoolSize = numProcessors / 2;
        this.maximumPoolSize = numProcessors - 1;
        this.keepAliveTime = 300;
        this.unit = TimeUnit.MILLISECONDS;
        super.setCorePoolSize(corePoolSize);
        super.setMaximumPoolSize(maximumPoolSize);
    }

    /**
     * Submit function is an indicator to when a Task has been added to the PriorityBlockingQueue
     * In the function we update "maxPriority"
     * @param task
     * @return
     * @param <T>
     */
    public <T> Future<T> submit(Task<T> task) {
        CustomFutureTask<?> max = (CustomFutureTask<?>) this.getQueue().peek();
        if (max!= null){
         maxPriority = max.task.getTaskType().getPriorityValue();
             if(task.getTaskType().getPriorityValue()<maxPriority) {
                 maxPriority = task.getTaskType().getPriorityValue();
             }
         }
        else {
            maxPriority = task.getTaskType().getPriorityValue();
        }
        return super.submit(task);
    }

    /**
     * Chaining
     * @param operation the task to submit
     * @return
     * @param <T>
     */
    public <T> Future<T> submit(Callable<T> operation) {
        Task<T> task = Task.createTask(operation);
        return submit(task);
    }

    /**
     * Chaining
     * @param operation
     * @param taskType
     * @return
     * @param <T>
     */
    public <T> Future<T> submit(Callable<T> operation, TaskType taskType) {
        Task<T> task = Task.createTask(operation,taskType);

        return submit(task);
    }

    public void gracefullyTerminate() {
        this.shutdown();
    }

    public int getCurrentMax() {
        return maxPriority;
    }

    /**
     * Adds CustomFutureTask to the PriorityBlockingQueue
     * @param callable the callable task being wrapped
     * @return
     * @param <T>
     */
    public  <T> RunnableFuture<T> newTaskFor(Callable<T> callable){
        return new CustomFutureTask<>(callable);
    }

    /**
     * beforeExecute() function is an indicator to when a Task has been removed out of the PriorityBlockingQueue
     * In the function we update  "maxPriority"
     * @param t the thread that will run task {@code r}
     * @param r the task that will be executed
     */
    @Override
    protected void beforeExecute(Thread t, Runnable r) {

        CustomFutureTask<?> max = (CustomFutureTask<?>) this.getQueue().peek();
        if(max!= null){
            maxPriority = max.task.getTaskType().getPriorityValue();
        }
        else {
            maxPriority= Integer.MAX_VALUE;
        }
        super.beforeExecute(t, r);
    }

    public boolean equals(CustomExecutor other) {
        if (other == this) return true;
        return super.equals(other) && other.maxPriority==(this.maxPriority);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + super.hashCode();
        result = 31 * result + maxPriority;
        return result;
    }

    public String toString(){
        return "maxPriority: "+ maxPriority+ super.toString();
    }
}

