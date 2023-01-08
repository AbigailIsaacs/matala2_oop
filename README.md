# matala2_oop
This Java class contains three methods. The first method, "createTextFiles" , creates a specified number of text files, with random numbers of lines in each file. The second method, "getNumOfLines", reads through a list of text files and returns the total number of lines in all of the files. The third method, "getNumOfLinesThreads", does the same thing as the second method but uses multiple threads to read the files. The final method, "getNumOfLinesThreadPool", also reads through a list of text files and returns the total number of lines, but it uses a thread pool to create the threads.
The method, "getNumOfLinesThreads" uses the class "FileLineThread" this Java class extends the Thread class and has one private field, sumRows, and three methods. The FileLineThread constructor takes in a String as an argument and assigns it to the fileName field. The run method reads through a specified text file and counts the number of lines in the file. The getSumRows method returns the value of sumRows. This class is used to count the number of lines in a text file concurrently with other threads.
The final method, "getNumOfLinesThreadPool" uses the class "NumLineTask" this Java class is a Callable task that counts the number of lines in a specified text file. It has one private field, fileName, and one method. The NumLineTask constructor takes in a String as an argument and assigns it to the fileName field. The call method reads through the specified text file and counts the number of lines in the file, then returns this value. This class is used to count the number of lines in a text file concurrently with other threads as part of a thread pool.









