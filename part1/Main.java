import java.util.Arrays;

public class Main {
   public static void main(String[] args) throws Exception {
        String [] ans = Ex2_1.createTextFiles(100,1,1000);

        System.out.println(Arrays.toString(ans));
        Ex2_1 ex2_1 = new Ex2_1();

        long start1 = System.nanoTime();
        System.out.println(Ex2_1.getNumOfLines(ans));
        long end1 = System.nanoTime();
        System.out.println("Elapsed Time in nano seconds function 1: "+ (end1-start1));


        long start2 = System.nanoTime();
        System.out.println(ex2_1.getNumOfLinesThreads(ans));
        long end2 = System.nanoTime();
        System.out.println("Elapsed Time in nano seconds function 2: "+ (end2-start2));


        long start3 = System.nanoTime();
        System.out.println(ex2_1.getNumOfLinesThreadPool(ans));
        long end3 = System.nanoTime();
        System.out.println("Elapsed Time in nano seconds function 3: "+ (end3-start3));
    }
}