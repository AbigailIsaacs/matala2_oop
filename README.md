# matala2_oop 
## part1-
This Java class contains four methods.
The first method, "createTextFiles" , creates a specified number of text files, with random numbers of lines in each file.
The second method, "getNumOfLines", reads through a list of text files and returns the total number of lines in all of the files.
The third method, "getNumOfLinesThreads", does the same thing as the second method but uses n (number of files) threads to read the files.
The fourth method, "getNumOfLinesThreadPool", also reads through a list of text files and returns the total number of lines, but it uses a thread pool to create the threads.

The third method, "getNumOfLinesThreads" uses the class "FileLineThread" this Java class extends the Thread class and has one private field, sumRows, and three methods.

The FileLineThread constructor takes in a String as an argument and assigns it to the fileName field. The run method reads through a specified text file and counts the number of lines in the file. The getSumRows method returns the value of sumRows. This class is used to count the number of lines in a text file concurrently with other threads.

The fourth method, "getNumOfLinesThreadPool" uses the class "NumLineTask" this Java class is a Callable task that counts the number of lines in a specified text file. It has one private field, fileName, and one method. The NumLineTask constructor takes in a String as an argument and assigns it to the fileName field. The call method reads through the specified text file and counts the number of lines in the file, then returns this value. This class is used to count the number of lines in a text file concurrently with other threads as part of a thread pool.

The running time of the three methods in Ex2_1 is different because they use different approaches to counting the number of lines in a list of text files.

Worst preformer - The getNumOfLines method reads through the files one by one, sequentially. This means that it will take longer to count the lines in the files as the number of files increases. The running time of this method is directly proportional to the number of files.

Better preformer - The getNumOfLinesThreads method reads through the files concurrently using multiple threads. This means that it will be able to count the lines in the files faster than the getNumOfLines method, especially as the number of files increases. The running time of this method is not necessarily directly proportional to the number of files, because it depends on the number of threads being used and the speed at which the threads can process the files.

Best preformer - The getNumOfLinesThreadPool method also reads through the files concurrently, but it uses a thread pool to manage the threads. This means that it can potentially count the lines in the files faster than the getNumOfLinesThreads method, especially as the number of files increases. The running time of this method is not necessarily directly proportional to the number of files, because it depends on the size of the thread pool and the speed at which the threads can process the files.

## part2-
class "Task"- 
Implements the "Callable" and "Comparable" interfaces, and it holds a variable of type "TaskType" and "Callable". The class contains a constructor that takes in a "Callable" and a "TaskType" and assigns them to the class variables. There is also a "createTask" static factory method that takes in a "Callable" and an optional "TaskType" and returns a new instance of the "Task" class. The class also overrides the "call()" method, "equals()", "hashCode()", "toString()" and "compareTo()" methods to provide additional functionality.

class "CustomFutureTask" -
Extends the FutureTask class and implements the Comparable interface. It holds a variable of type "Task" and takes a callable object during initialization. The class contains a constructor that takes in a "Callable" and creates a FutureTask of the same and assigns the same callable object to the task class variable. The class also provides an implementation for the compareTo() method, which is used to compare the priority of two tasks. It also provide overrides for "equals()", "hashCode()", "toString()" methods.

class "CustomExecutor"-
Extends the ThreadPoolExecutor class. it initialize a thread pool with core pool size and maximum pool size, it uses a PriorityBlockingQueue as the queue to hold the runnable tasks. It also keeps track of the max priority seen so far. The class provides a "submit()" function, it takes in a task object and adds it to the queue, it also updates the maxPriority variable with the new priority value if it is smaller than the current max priority. It also provides Chaining methods to directly submit callable objects, it creates a task object and calls the previous submit function. it also provides gracefullyTerminate() method to shutdown the executor. It overrides "beforeExecute" method to update maxPriority variable and newTaskFor to create a CustomFutureTask for the callable submitted. it also provides equals and hashCode methods for its objects.









