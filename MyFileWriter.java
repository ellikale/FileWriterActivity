import java.io.*;
import java.nio.file.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

        // 1. Using FileWriter
        try (FileWriter writer = new FileWriter(fileName1)) {
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. Using BufferedWriter
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 3. Using FileOutputStream
        try (FileOutputStream outputStream = new FileOutputStream(fileName3)) {
            outputStream.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 4. Using BufferedOutputStream
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileName4))) {
            bufferedOutputStream.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 5. Using Files (java.nio.file)
        try {
            Files.write(Paths.get(fileName5), data.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }

        printFileSize("example.txt", "example2.txt", "example3.txt");

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
    private static void printFileSize(String... fileNames) {
    long totalSize = 0;
    for (String fileName : fileNames) {
        File file = new File(fileName);
        if (file.exists()) {
            totalSize += file.length();
        }
    }
    System.out.println("Total size of all files: " + totalSize + " bytes");
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

    public static String hashFile(String filePath){    
        
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath))){
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] buffer = new byte[8192];
            int bytesRead;
            while((bytesRead = bufferedInputStream.read(buffer)) != -1){
                digest.update(buffer, 0, bytesRead);
            }
            byte[] hashBytes = digest.digest();
            return makeItHex(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            System.err.println("SHA-256 is unavailable right now.");
        }catch (FileNotFoundException e) {
            System.err.println("That file does not exist");
        }catch (IOException e) {
            System.err.println("Cannot read the file!");
        }
        return null;
    }

    public static String makeItHex(byte[] hashers){
        //used stackoverflow for help
        char[] hexArrayFormat = "0123456789ABCDEF".toCharArray();
        char[] hexskis = new char[hashers.length *2];
        for(int j = 0; j < hashers.length; j++){
            int i = hashers[j] & 0xFF;
            hexskis[j * 2] = hexArrayFormat[i >>> 4];
            hexskis[j * 2 + 1] = hexArrayFormat[i & 0x0F];
        }
        return new String(hexskis);
    }

}