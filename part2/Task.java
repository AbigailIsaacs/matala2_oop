package part2;

import java.util.concurrent.Callable;

public class Task<T>   implements  Callable<T> ,Comparable<Task<T>>{
    private final TaskType taskType;
    private final Callable<T> task;

    private Task(Callable<T> task, TaskType priority) {
        this.task = task;
        this.taskType = priority;
    }

    /**
     * A createTask function that initialize the priority to the default priority-"OTHER".
     * @param task
     * @return
     * @param <T>
     */
    public static <T> Task<T> createTask(Callable<T> task) {
        return createTask(task, TaskType.OTHER);
    }

    /**
     * Factory Method
     * The return type Task<T> indicates that the createTask() method returns a Task instance
     * that is parameterized with the same type T as the Callable operation.
     * @param task
     * @param taskType the priority of the task
     * @return Task<T>
     * @param <T>
     */

    public static <T> Task<T> createTask(Callable<T> task, TaskType taskType) {
        return new Task<>(task, taskType);
    }

    /**
     * Sends the task to his corresponding function call.
     * and returns the value from call.
     * @return
     * @throws Exception
     */
    @Override
    public T call() throws Exception {
        return task.call();
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public boolean equals(Task<T> other) {
        if (other == this) return true;
        return other.taskType == this.taskType && other.task.equals(this.task);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + taskType.hashCode();
        result = 31 * result + task.hashCode();
        return result;
    }

    public String toString(){
        return "part2.Task.TaskType: "+ taskType+ "task: "+task.toString();
    }


    @Override
    public int compareTo(Task<T> other) {
        return Integer.compare(this.getTaskType().getPriorityValue(),other.getTaskType().getPriorityValue());
    }
}
