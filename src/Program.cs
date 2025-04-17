using System;

/// <summary>
/// Entry point for the application.
/// Contains test arrays and calls the Magic Square checker.
/// </summary>
class Program
{
    static void Main(string[] args)
    {
        // Test arrays
        int[,] testArray = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
        int[,] testArray2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[,] testArray3 = { { 4, 5, 6 }, { 7, 8, 9 } };

        // Check each array
        MagicSquareUtil.MgcSqrChck(testArray);
        MagicSquareUtil.MgcSqrChck(testArray2);
        MagicSquareUtil.MgcSqrChck(testArray3);
    }
}

/// <summary>
/// Utility class that provides functionality to check if a 2D array is a magic square.
/// </summary>
class MagicSquareUtil
{
    /// <summary>
    /// Checks whether the provided 2D integer array is a magic square.
    /// A magic square has equal sums for all rows, columns, and both diagonals.
    /// </summary>
    /// <param name="theArray">2D integer array to check</param>
    public static void MgcSqrChck(int[,] theArray)
    {
        int benchmark = 0;        // Target sum for rows/columns/diagonals
        int diagonalsum = 0;      // Sum of the main diagonal
        int diagonalsum2 = 0;     // Sum of the anti-diagonal
        bool isMagicSquare = true;

        // First, ensure it's a perfect square (same number of rows and columns)
        if (isPerfectSqr(theArray))
        {
            // Set benchmark sum using the first row
            for (int elem = 0; elem < theArray.GetLength(0); elem++)
            {
                benchmark += theArray[0, elem];
            }

            // Check each row and column
            for (int row = 0; row < theArray.GetLength(0); row++)
            {
                int rowsum = 0;
                int colsum = 0;

                for (int col = 0; col < theArray.GetLength(1); col++)
                {
                    rowsum += theArray[row, col];     // Row sum
                    colsum += theArray[col, row];     // Column sum (note the flipped indices)
                }

                // If either row or column doesn't match the benchmark, it's not a magic square
                if (rowsum != benchmark || colsum != benchmark)
                {
                    Console.WriteLine("This is not a Magic Square");
                    isMagicSquare = false;
                    break;
                }

                // Sum diagonals while looping rows
                diagonalsum += theArray[row, row];                                       // Main diagonal
                diagonalsum2 += theArray[row, theArray.GetLength(0) - row - 1];          // Anti-diagonal
            }

            // Final check: diagonals must match the benchmark
            if (isMagicSquare && (diagonalsum != benchmark || diagonalsum2 != benchmark))
            {
                Console.WriteLine("This is not a Magic Square");
                isMagicSquare = false;
            }

            // If all checks passed
            if (isMagicSquare)
            {
                Console.WriteLine("That is a Magic Square!!!");
            }
        }
        else
        {
            Console.WriteLine("Not Even a Square.");
        }
    }

    /// <summary>
    /// Checks if a 2D array is a square (equal number of rows and columns).
    /// </summary>
    /// <param name="theArray">2D array to check</param>
    /// <returns>True if it's a square, false otherwise</returns>
    public static bool isPerfectSqr(int[,] theArray)
    {
        return theArray.GetLength(0) == theArray.GetLength(1);
    }
}
