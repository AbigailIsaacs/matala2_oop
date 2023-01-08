# matala2_oop
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









