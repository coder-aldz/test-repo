public class Main2 {

    public static void isMagicSquare(int[][] theArray) {
        int size = theArray.length;
        int magicSum = 0; // Use to store the reference sum of the first row
        boolean notMagic = false;

        // Calculate the sum of the first row to set the "magicSum"
        for (int col = 0; col < size; col++) {
            magicSum += theArray[0][col];
        }

        int dia1 = 0, dia2 = 0;

        // Single loop to calculate row sums, column sums, and diagonal sums
        for (int i = 0; i < size; i++) {
            int rowSum = 0, colSum = 0;

            for (int j = 0; j < size; j++) {
                rowSum += theArray[i][j];
                colSum += theArray[j][i];
            }

            dia1 += theArray[i][i];
            dia2 += theArray[i][size - 1 - i];

            // Check if row sums and column sums match the "magicSum"
            if (rowSum != magicSum || colSum != magicSum) {
                System.out.println("Sorry, not a Magic Square");
                notMagic = true;
                break;
            }
        }

        // Check diagonal sums at the end
        if (!notMagic && (dia1 != magicSum || dia2 != magicSum)) {
            System.out.println("Sorry, not a Magic Square");
            notMagic = true;
        }

        if (!notMagic) {
            System.out.println("Great! It is a Magic Square");
        }
    }
}
