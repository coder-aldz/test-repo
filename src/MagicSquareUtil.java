/**
 * This class provides utility methods for determining whether a given 2D array
 * represents a magic square. A magic square is a square matrix where the sums
 * of each row, column, and both diagonals are equal.
 *
 * @author Paul
 * @version 1.0
 * @since 2025-04-11
 */
public class MagicSquareUtil {

    /**
     * Checks if the given 2D array is a magic square.
     * A magic square is a square matrix where the sums of each row, column, and both
     * diagonals are equal. Outputs the result to the console.
     *
     * @param theArray A 2D array of integers to be checked.
     */
    public static void isMgcSqr(int[][] theArray) {
        // Verify that the array is square before proceeding
        if (isPrfctSqr(theArray)) {
            // Variables to track sums of diagonals
            int diagonal_1, diagonal_2;
            diagonal_1 = diagonal_2 = 0;

            // Calculate the sum of the first row as the reference sum for comparison
            int initialSum = 0;
            for (int i = 0; i < theArray.length; i++) {
                initialSum += theArray[0][i];
            }

            // Flag to indicate if the matrix fails the magic square condition
            boolean notMagic = false;

            // Iterate through each row and column to check their sums
            for (int row = 0; row < theArray.length; row++) {
                int rowTotal, colTotal;
                rowTotal = colTotal = 0;

                // Calculate the sum for the current row and column
                for (int col = 0; col < theArray.length; col++) {
                    rowTotal += theArray[row][col];
                    colTotal += theArray[col][row];
                }

                // Track the sums of both diagonals
                diagonal_1 += theArray[row][row];
                diagonal_2 += theArray[row][theArray.length - 1 - row];

                // Check if the current row or column sum differs from the reference sum
                if (rowTotal != initialSum || colTotal != initialSum) {
                    System.out.println("Sorry, not a Magic Square");
                    notMagic = true;
                    break; // Exit early if the magic square condition is violated
                }
            }

            // Check if the diagonal sums match the reference sum
            if (!notMagic && (diagonal_1 != initialSum || diagonal_2 != initialSum)) {
                System.out.println("Sorry, not a Magic Square");
                notMagic = true;
            }

            // Output result based on the flag
            if (!notMagic) {
                System.out.println("Great! It is a Magic Square");
            }
        } else {
            // Inform the user if the array is not square
            System.out.println("Sorry, but the array you provided is not a square.");
        }
    }

    /**
     * Checks if the given 2D array is a perfect square (i.e., has equal number of rows and columns).
     *
     * @param theArray A 2D array of integers to be checked.
     * @return True if the array is a perfect square; false otherwise.
     */
    public static boolean isPrfctSqr(int[][] theArray) {
        // Retrieve the number of rows and columns
        int size2D = theArray.length;
        int size1D = theArray[0].length;

        // Compare dimensions to determine if the array is square
        return size1D == size2D;
    }
}
