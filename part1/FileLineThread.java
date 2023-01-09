import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileLineThread extends Thread{
    private String fileName;
    private int sumRows = 0;
    public FileLineThread(String fileName){
        this.fileName = fileName;
    }
    public void run(){
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
        sumRows = sum;
    }

    public String getFileName() {
        return fileName;
    }
    public int getSumRows() {

        return sumRows;
    }

    public boolean equals(FileLineThread other) {

        return (other.fileName.equals(this.fileName)) && (this.sumRows==other.sumRows);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + fileName.hashCode();
        result = 31 * result + sumRows;
        return result;
    }

    public String toString(){
        return "fileName: "+fileName.toString() +"Total number of rows: "+ sumRows;
    }
}
