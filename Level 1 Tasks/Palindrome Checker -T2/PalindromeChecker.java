import java.util.*;
public class PalindromeChecker {

   public static boolean isPalindrome(String str) {
    String cleanedStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        String reversedStr = new StringBuilder(cleanedStr).reverse().toString();
        return cleanedStr.equals(reversedStr);
    }

    public static void main(String[] args) {
        PalindromeChecker chkr = new PalindromeChecker();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        
        boolean result = chkr.isPalindrome(input);
        if (result) 
            System.out.println("Given string is a palindrome.");
        else
            System.out.println("Given String is not a palindrome.");
        }

    }
         