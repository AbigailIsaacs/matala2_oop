package part2;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CustomFutureTask<T> extends FutureTask<T> implements Comparable<CustomFutureTask<T>>{
     final Task<T> task;

    public CustomFutureTask(Callable<T> callable) {
        super(callable);
        this.task = (Task<T>) callable;
    }
    /**
     * We compare the Task Priority of two tasks.
     * @param other the object to be compared.
     * @return
     */

    @Override
    public int compareTo(CustomFutureTask<T> other) {
        return Integer.compare(this.task.getTaskType().getPriorityValue(),other.task.getTaskType().getPriorityValue());
    }

    public boolean equals(CustomFutureTask<T> other) {
        return other.task.equals(this.task);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + task.hashCode();
        return result;
    }

    public String toString(){
        return "task: "+task.toString();
    }
}
