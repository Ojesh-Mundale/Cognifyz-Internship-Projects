import java.io.*;
import java.util.Scanner;

public class FileEncryptDecrypt {

    public static String encryptText(String text) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : text.toCharArray()) {
            encrypted.append((char)(c + 5)); 
        }
        return encrypted.toString();
    }

    public static String decryptText(String text) {
        StringBuilder decrypted = new StringBuilder();
        for (char c : text.toCharArray()) {
            decrypted.append((char)(c - 5)); 
        }
        return decrypted.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an option:");
        System.out.println("1. Encrypt a file");
        System.out.println("2. Decrypt a file");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the path of the input file: ");
        String inputFile = scanner.nextLine();

        System.out.print("Enter the path of the output file: ");
        String outputFile = scanner.nextLine();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            String line;
            while ((line = reader.readLine()) != null) {
                if (choice == 1) {
                    writer.write(encryptText(line));
                } else if (choice == 2) {
                    writer.write(decryptText(line));
                }
                writer.newLine();
            }

            reader.close();
            writer.close();

            if (choice == 1) {
                System.out.println("File encrypted successfully!");
            } else {
                System.out.println("File decrypted successfully!");
            }

        } catch (IOException e) {
            System.out.println("An error occurred while processing the file.");
            e.printStackTrace();
        }

        scanner.close();
    }
}
