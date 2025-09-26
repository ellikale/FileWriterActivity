import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class MyFileWriterTester {
    public static void main(String[] args) {
        //MyFileWriter.generateHiddenFile("hi", ".myFileFun");
        //MyFileWriter.generateRegularFile();
        // try {
        //     String answer = MyFileWriter.stringify("regularFile");
        //     System.out.println(answer);
        // } catch (IOException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        //originalTestHash();
        //testHashFileEmptyFiles();
        //testHashFileSpecialChars();
        //testHashFileDNE();
        testHashFilesLarge();
    }

    //returned the same hash, passed for a normal file
    public static void originalTestHash(){
        try{  
            File tempFile = File.createTempFile("tempSpecial", ".txt");
            String specialString = "hi!";
            Files.write(tempFile.toPath(), specialString.getBytes(StandardCharsets.UTF_8));
            String hash = MyFileWriter.hashFile(tempFile.getAbsolutePath());
            String expectedHash = "C0DDD62C7717180E7FFB8A15BB9674D3EC92592E0B7AC7D1D5289836B4553BE2";
            System.out.println("Regular File Test");
            System.out.println("Expected: " + expectedHash);
            System.out.println("Actual: " + hash);
            if(hash.equals(expectedHash)){
                System.out.println("Passed!"); 
            }
            else{
                System.out.println("Failed!"); 
            }
            tempFile.delete();
        }
        catch (IOException e) {
            System.err.println("something happened..." + e.getMessage());
        }
    }

    //worked as expected, returned true for empty files!
    public static void testHashFileEmptyFiles(){
        try{
            File tempFile = File.createTempFile("temporary", ".txt");
            String hash = MyFileWriter.hashFile(tempFile.getAbsolutePath());
            String expectedHash = "E3B0C44298FC1C149AFBF4C8996FB92427AE41E4649B934CA495991B7852B855";
            System.out.println("Empty File Test");
            System.out.println("Expected: " + expectedHash);
            System.out.println("Actual: " + hash);
            if(hash.equals(expectedHash)){
                System.out.println("Passed!"); 
            }
            else{
                System.out.println("Failed!"); 
            }
            tempFile.delete();
        }
        catch (Exception e) {
            System.err.println("something happened..." + e.getMessage());
        }
    }

    //returned the same hash and work completely, this is for special characters
    public static void testHashFileSpecialChars(){
        try{
            File tempFile = File.createTempFile("tempSpecial", ".txt");
            String specialString = "⋆｡‧˚ʚ🍓ɞ˚‧｡⋆";
            Files.write(tempFile.toPath(), specialString.getBytes(StandardCharsets.UTF_8));
            String hash = MyFileWriter.hashFile(tempFile.getAbsolutePath());
            String expectedHash = "DDDCE16B1228DCF37574C7523D8E7121B8DDFDA8237D97F28727A13006F5FB10";
            System.out.println("Special File Test");
            System.out.println("Expected: " + expectedHash);
            System.out.println("Actual: " + hash);
            if(hash.equals(expectedHash)){
                System.out.println("Passed!"); 
            }
            else{
                System.out.println("Failed!"); 
            }
            tempFile.delete();
        }
        catch (IOException e) {
            System.err.println("something happened..." + e.getMessage());
        }
    }

    //returned the same hash and work completely, this is for large files
    public static void testHashFilesLarge(){
        try{
            File tempFile = new File("tempSpecial.txt");
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile))) {
                for (int i = 0; i < 10000; i++) {
                    bufferedWriter.write("hello my name is ellika, have fun making a big file. \n");
                }
            }
            String hash = MyFileWriter.hashFile(tempFile.getAbsolutePath());
            String expectedHash = "F45D4857A44ED2CE6D603EF79DA42AB1F7A815BEFA438DDFF74B92F2AAFEBCB6";
            System.out.println("Large File Test");
            System.out.println("Expected: " + expectedHash);
            System.out.println("Actual: " + hash);
            if(hash.equalsIgnoreCase(expectedHash)){
                System.out.println("Passed!"); 
            }
            else{
                System.out.println("Failed!"); 
            }
            tempFile.delete();
        }
        catch (Exception e) {
            System.err.println("something happened..." + e.getMessage());
        }
    }

    //this was on a file that doesnt exist and it threw the right error message
    public static void testHashFileDNE(){
        try{
            String fake = "dne.txt";
            String hash = MyFileWriter.hashFile(fake);
            String expectedHash = null;
            System.out.println("DNE File Test");
            System.out.println("Expected: " + expectedHash);
            System.out.println("Actual: " + hash);
            if(hash.equals(expectedHash)){
                System.out.println("Passed!"); 
            }
            else{
                System.out.println("Failed!"); 
            }
        }
        catch (Exception e) {
            System.err.println("something happened..." + e.getMessage());
        }
    }
}
