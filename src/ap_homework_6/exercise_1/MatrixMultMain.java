package ap_homework_6.exercise_1;


/**
 * Main class for matrix multiplication using threads
 */
public class MatrixMultMain {

    /**
     * Main method to demonstrate matrix multiplication
     */
    public static void main(String[] args) {
        // Define two sample matrices
        int[][] matrixA = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int[][] matrixB = {
                {7, 8},
                {9, 10},
                {11, 12}
        };

        System.out.println("Matrix A:");
        printMatrix(matrixA);

        System.out.println("Matrix B:");
        printMatrix(matrixB);

        // Calculate product with threads using start()
        System.out.println("\nMultiplying matrices using threads (with start()):");
        long startTime = System.currentTimeMillis();
        int[][] resultWithThreads = multiplyMatricesWithThreads(matrixA, matrixB);
        long endTime = System.currentTimeMillis();
        System.out.println("Result matrix:");
        printMatrix(resultWithThreads);
        System.out.println("Time taken with threads: " + (endTime - startTime) + " ms");

        // Calculate product with run() method directly (no threads)
        System.out.println("\nMultiplying matrices without threads (with run()):");
        startTime = System.currentTimeMillis();
        int[][] resultWithoutThreads = multiplyMatricesWithoutThreads(matrixA, matrixB);
        endTime = System.currentTimeMillis();
        System.out.println("Result matrix:");
        printMatrix(resultWithoutThreads);
        System.out.println("Time taken without threads: " + (endTime - startTime) + " ms");

        // Calculate product traditionally for verification
        System.out.println("\nMultiplying matrices traditionally:");
        int[][] resultTraditional = multiplyMatricesTraditionally(matrixA, matrixB);
        System.out.println("Result matrix:");
        printMatrix(resultTraditional);
    }

    /**
     * Multiply two matrices using threads with start() method
     * @param matrixA First matrix
     * @param matrixB Second matrix
     * @return Result matrix
     */
    public static int[][] multiplyMatricesWithThreads(int[][] matrixA, int[][] matrixB) {
        // Check if matrices can be multiplied
        if (matrixA[0].length != matrixB.length) {
            throw new IllegalArgumentException("Incompatible matrix dimensions");
        }

        int rowsA = matrixA.length;
        int colsB = matrixB[0].length;
        int[][] result = new int[rowsA][colsB];

        // Create and start threads for each cell in result matrix
        DotProductThread[][] threads = new DotProductThread[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                // Extract row from matrix A
                int[] row = matrixA[i];

                // Extract column from matrix B
                int[] col = new int[matrixB.length];
                for (int k = 0; k < matrixB.length; k++) {
                    col[k] = matrixB[k][j];
                }

                // Create and start thread for this cell
                threads[i][j] = new DotProductThread(row, col, i, j);
                threads[i][j].start();
            }
        }

        // Wait for all threads to complete and collect results
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                try {
                    threads[i][j].join(); // Wait for thread to finish
                    result[i][j] = threads[i][j].getDot();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }

    /**
     * Multiply two matrices using DotProductThread but calling run() directly (no threads)
     * @param matrixA First matrix
     * @param matrixB Second matrix
     * @return Result matrix
     */
    public static int[][] multiplyMatricesWithoutThreads(int[][] matrixA, int[][] matrixB) {
        // Check if matrices can be multiplied
        if (matrixA[0].length != matrixB.length) {
            throw new IllegalArgumentException("Incompatible matrix dimensions");
        }

        int rowsA = matrixA.length;
        int colsB = matrixB[0].length;
        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                // Extract row from matrix A
                int[] row = matrixA[i];

                // Extract column from matrix B
                int[] col = new int[matrixB.length];
                for (int k = 0; k < matrixB.length; k++) {
                    col[k] = matrixB[k][j];
                }

                // Create thread object but call run() directly (no parallelism)
                DotProductThread thread = new DotProductThread(row, col);
                thread.run(); // This runs in the current thread, not a new one
                result[i][j] = thread.getDot();
            }
        }

        return result;
    }

    /**
     * Traditional matrix multiplication (for verification)
     * @param matrixA First matrix
     * @param matrixB Second matrix
     * @return Result matrix
     */
    public static int[][] multiplyMatricesTraditionally(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;

        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        return result;
    }

    /**
     * Helper method to print a matrix
     * @param matrix Matrix to print
     */
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}