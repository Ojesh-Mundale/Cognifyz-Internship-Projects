import java.util.*;

public class RPG {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of the password: ");
        int length = scanner.nextInt();
        scanner.nextLine(); 

        String[] prompts = {
            "Include lowercase letters? (y/n): ",
            "Include uppercase letters? (y/n): ",
            "Include numbers? (y/n): ",
            "Include special characters? (y/n): "
        };
        boolean[] options = new boolean[4];
        
        for (int i = 0; i < prompts.length; i++) {
            System.out.print(prompts[i]);
            options[i] = scanner.nextLine().equalsIgnoreCase("y");
        }
        
        boolean includeLower = options[0];
        boolean includeUpper = options[1];
        boolean includeNumbers = options[2];
        boolean includeSpecial = options[3];
        

        if (!includeLower && !includeUpper && !includeNumbers && !includeSpecial) {
            System.out.println("You must select at least one character type.");
            return;
        }

        String password = generateRandomPassword(length, includeLower, includeUpper, includeNumbers, includeSpecial);
        System.out.println("Generated Password: " + password);
    }

    public static String generateRandomPassword(int length, boolean lower, boolean upper, boolean numbers, boolean special) {
        String lowerChar = "abcdefghijklmnopqrstuvwxyz";
        String upperChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numChar = "0123456789";
        String specialChar= "!@#$%^&*()_+[]{}|;:,.<>?";

        StringBuilder givenTypes = new StringBuilder();
        if (lower) givenTypes.append(lowerChar);
        if (upper) givenTypes.append(upperChar);
        if (numbers) givenTypes.append(numChar);
        if (special)givenTypes.append(specialChar);

        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(givenTypes.length());
            password.append(givenTypes.charAt(index));
        }

        return password.toString();
    }
}
