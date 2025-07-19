import java.util.Scanner;
public class PasswordChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your password: ");
        String pwd = sc.nextLine();
        int strength = 0;

        if (pwd.length() >= 8) strength++;
        if (pwd.matches(".*[a-z].*")) strength++;
        if (pwd.matches(".*[A-Z].*")) strength++;
        if (pwd.matches(".*\\d.*")) strength++;
        if (pwd.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*")) strength++;

        if (strength == 5)
            System.out.println("Strong password!");
        else if (strength >= 3)
            System.out.println("Medium strength");
        else
            System.out.println("Weak password");

        sc.close();
    }
}
 
