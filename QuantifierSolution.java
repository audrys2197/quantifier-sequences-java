import java.util.Scanner;

public class QuantifierSolution {

    public static void main(String[] args) {
        int[] A = new int[100];

        // Populate the sequence A using the formula an = 2*n - 5
        for (int i = 0; i < 100; i++) {
            A[i] = 2 * (i + 1) - 5;
        }

        // Display the first 100 elements of Sequence A
        System.out.println("First 100 elements in Sequence A:");
        for (int i = 0; i < 100; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();

        // Input a number for the quantifier evaluation
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter an integer (input_num): ");
        int input_num = scanner.nextInt();

        // Evaluate universal quantifier (ꓯx P(x))
        boolean forallP = universalQuantifier(A, input_num);

        // Evaluate existential quantifier (Ǝx P(x))
        boolean existsP = existentialQuantifier(A, input_num);

        // Display the results of quantifiers
        System.out.println("\nThe universal quantifier statement is " + forallP +
                " when inputting number is " + input_num + ".");
        System.out.println("The existential quantifier statement is " + existsP +
                " when inputting number is " + input_num + ".");

        // Input a number for the sum calculation
        System.out.print("\nEnter the number of elements (n) to sum: ");
        int n = scanner.nextInt();

        // Validate input
        if (n < 1 || n > 100) {
            System.out.println("Invalid input! Please enter a number between 1 and 100.");
            return;
        }

        // Calculate sum of the first n elements in Sequence A
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i];
        }

        // Convert the sum to binary format without using built-in functions
        String binarySum = manualBinaryConversion(sum);

        // Display the sum and its binary equivalent
        System.out.println("\nThe sum of the first " + n + " elements in Sequence A is " + sum +
                " and its equivalent binary number is " + binarySum + ".");
    }

    // Universal Quantifier Logic: ꓯx P(x) ≡ P(1) ∧ P(2) ∧ ... ∧ P(n)
    public static boolean universalQuantifier(int[] A, int input_num) {
        for (int i = 0; i < A.length; i++) {
            if (!(A[i] > input_num)) { // If any P(x) is false
                return false;
            }
        }
        return true; // All P(x) are true
    }

    // Existential Quantifier Logic: Ǝx P(x) ≡ P(1) ∨ P(2) ∨ ... ∨ P(n)
    public static boolean existentialQuantifier(int[] A, int input_num) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] > input_num) { // If any P(x) is true
                return true;
            }
        }
        return false; // No P(x) is true
    }

    // Manual binary conversion function
    public static String manualBinaryConversion(int number) {
        if (number == 0) {
            return "0";
        }

        // Construct the binary number manually
        String binary = "";
        while (number > 0) {
            binary = (number % 2) + binary; // Append remainder at the front
            number = number / 2;
        }
        return binary;
    }
}
