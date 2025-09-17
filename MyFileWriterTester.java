import java.io.IOException;

public class MyFileWriterTester {
    public static void main(String[] args) {
        //MyFileWriter.generateHiddenFile("hi", ".myFileFun");
        //MyFileWriter.generateRegularFile();
        try {
            String answer = MyFileWriter.stringify("regularFile");
            System.out.println(answer);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
