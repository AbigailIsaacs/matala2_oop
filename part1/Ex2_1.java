import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Ex2_1 {

    public static String[] createTextFiles(int n, int seed, int bound) throws FileNotFoundException {
        String[] array = new String[n];
        Random rand = new Random(seed);
        for (int i = 0; i < n; i++) {
            String fileName = "file_"+(i+1);
            array[i]=fileName;
            PrintWriter out = new PrintWriter(fileName);
            int x = rand.nextInt(bound);
            for (int j = 0; j < x; j++) {
                out.println("your grade is 100");
            }
            out.close();
        }
        return array;
    }

    public static int getNumOfLines(String[] fileNames) throws IOException {
        int ans =0;
        for (int i = 0; i < fileNames.length; i++) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileNames[i]));
            String line = bufferedReader.readLine();
            int sum=0;
            while (line != null){
                sum++;
                line = bufferedReader.readLine();
            }
            ans+=sum;
        }
        return ans;
    }

    public int getNumOfLinesThreads(String[] fileNames) throws InterruptedException {
        FileLineThread[] arrSum = new FileLineThread [fileNames.length];
        int sum =0;
        FileLineThread current;
        for (int i = 0; i < fileNames.length; i++) {
            current = new FileLineThread(fileNames[i]);
            current.start();
            arrSum[i]=current;
        }
        for (int i = 0; i < arrSum.length; i++) {
            arrSum[i].join();
            sum+=arrSum[i].getSumRows();
        }
        return sum;
    }


    public int getNumOfLinesThreadPool(String[] fileNames) throws Exception {
        int nThreads = fileNames.length;
        int sum=0;
        ExecutorService executor = Executors.newFixedThreadPool(nThreads);
        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 0; i <nThreads ; i++) {
            NumLineTask lineTask = new NumLineTask(fileNames[i]);
            Future<Integer> future = executor.submit(lineTask);
            futures.add(future);
        }
        for (Future<Integer> future : futures) {
            sum += future.get();
        }
            executor.shutdown();
        return sum;
    }
}
