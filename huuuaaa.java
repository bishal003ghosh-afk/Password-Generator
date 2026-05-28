import java.util.Random;
import java.util.Scanner;

public class huuuaaa {

    public static String generatePassword(int length, boolean useUpper, boolean useLower, boolean useDigits, boolean useSymbols) {
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        while (password.length() < length) {
            int ascii = random.nextInt(94) + 33; // ASCII 33 (!) to 126 (~)

            // Apply filters based on user choice
            if (useUpper && ascii >= 65 && ascii <= 90) { // A-Z
                password.append((char) ascii);
            } else if (useLower && ascii >= 97 && ascii <= 122) { // a-z
                password.append((char) ascii);
            } else if (useDigits && ascii >= 48 && ascii <= 57) { // 0-9
                password.append((char) ascii);
            } else if (useSymbols && ((ascii >= 33 && ascii <= 47) || (ascii >= 58 && ascii <= 64)
                    || (ascii >= 91 && ascii <= 96) || (ascii >= 123 && ascii <= 126))) {
                password.append((char) ascii);
            }
        }

        return password.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== ASCII Password Generator ===");
        System.out.print("Enter desired password length: ");
        int length = scanner.nextInt();

        System.out.print("Include uppercase letters? (y/n): ");
        boolean useUpper = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include lowercase letters? (y/n): ");
        boolean useLower = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include numbers? (y/n): ");
        boolean useDigits = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include symbols? (y/n): ");
        boolean useSymbols = scanner.next().equalsIgnoreCase("y");

        if (!useUpper && !useLower && !useDigits && !useSymbols) {
            System.out.println("Error: At least one character type must be selected.");
            return;
        }

        String password = generatePassword(length, useUpper, useLower, useDigits, useSymbols);

        System.out.println("\nGenerated Password: " + password);
    }
}
