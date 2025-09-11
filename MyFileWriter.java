import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

public class MyFileWriter {
    public static void main(String[] args) {
        printFileSize("regularFile");

        String data = "Hello, World!";
        String fileName1 = "example.txt";
        String fileName2 = "example2.txt";
        String fileName3 = "example3.txt";
        String fileName4 = "example4.txt";
        String fileName5 = "example5.txt";

        // // 1. Using FileWriter
        // try (FileWriter writer = new FileWriter(fileName1)) {
        //     writer.write(data);
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        // // 2. Using BufferedWriter
        // try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2))) {
        //     bufferedWriter.write(data);
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        // // 3. Using FileOutputStream
        // try (FileOutputStream outputStream = new FileOutputStream(fileName3)) {
        //     outputStream.write(data.getBytes());
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        // // 4. Using BufferedOutputStream
        // try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileName4))) {
        //     bufferedOutputStream.write(data.getBytes());
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        // // 5. Using Files (java.nio.file)
        // try {
        //     Files.write(Paths.get(fileName5), data.getBytes(StandardCharsets.UTF_8));
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
    }

    public static void generateRegularFile(){
        try {
            Files.write(Paths.get(".hiddenFolderActivity/bob"), "confidentialInfo".getBytes(StandardCharsets.UTF_8));
            // Files.write(Paths.get("regularFile"), "thisIsConfidential".getBytes(StandardCharsets.UTF_8));
            // Path ogPath = Paths.get("").toAbsolutePath();
            // Path fPath = Paths.get(".youcantfindme");
            // String originalPath = ogPath.toString() + "/regularFile";
            // String 
            // Files.move(ogPath, fPath, StandardCopyOption.REPLACE_EXISTING);
            // Files.move("/FileWriterActivity/", null, StandardCopyOption.REPLACE_EXISTING);
            // Files.write(Paths.get("/Desktop/FileWriterActivity/.youcantfindme/bob"), "confidentialInfo".getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateHiddenFile(String password, String fileName){
        try {
            Files.write(Paths.get(fileName), password.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //hi!
    }

    // Calculate and print the file size using the File class
    private static void printFileSize(String fileName) {
        File file = new File(fileName);
        System.out.println(file.length());
    }

    /**
    * Reads a text file and returns its contents as a string.
    * 
    * @param filePath the path to the file
    * @return the contents of the file as a string
    * @throws IOException if an I/O error occurs
    */
    public static String stringify(String filePath) throws IOException {
        // TODO: Implement this method
        // Read the file at filePath and return its contents as a String
        Path fileP = Paths.get(filePath);
        return Files.readString(fileP);
    }

}