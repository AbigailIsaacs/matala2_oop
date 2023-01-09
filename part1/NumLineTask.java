import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;
public class NumLineTask implements Callable<Integer> {

    private String fileName;
    public NumLineTask(String fileName) throws Exception {
        this.fileName=fileName;
    }

    @Override
    public Integer call() throws Exception {
        BufferedReader bufferedReader = null;
        int sum = 0;
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            String line = bufferedReader.readLine();
            while (line != null) {
                sum++;
                line = bufferedReader.readLine();
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    return sum;
    }
    public String getFileName() {
        return fileName;
    }

    public boolean equals(NumLineTask other) {

        return other.fileName.equals(this.fileName);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + fileName.hashCode();
        return result;
    }

    public String toString(){

        return "fileName: "+fileName.toString();
    }

}
