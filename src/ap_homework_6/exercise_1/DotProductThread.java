package ap_homework_6.exercise_1;

/**
 * DotProductThread computes the dot product of two vectors.
 * It extends Thread to allow parallel computation.
 */
public class DotProductThread extends Thread {
    // Input vectors
    private int[] v1;
    private int[] v2;
    // Result of dot product
    private int dot;
    // Row and column indices for matrix multiplication
    private int row;
    private int col;

    /**
     * Constructor for the thread
     * @param v1 First vector
     * @param v2 Second vector
     */
    public DotProductThread(int[] v1, int[] v2) {
        this.v1 = v1;
        this.v2 = v2;
        this.dot = 0;
    }

    /**
     * Constructor that also keeps track of matrix position
     * @param v1 Row vector from first matrix
     * @param v2 Column vector from second matrix
     * @param row Row index in result matrix
     * @param col Column index in result matrix
     */
    public DotProductThread(int[] v1, int[] v2, int row, int col) {
        this(v1, v2);
        this.row = row;
        this.col = col;
    }

    /**
     * Compute the dot product when thread is started
     */
    @Override
    public void run() {
        // Ensure vectors are of same length
        if (v1.length != v2.length) {
            throw new IllegalArgumentException("Vectors must be of same length");
        }

        // Compute dot product
        for (int i = 0; i < v1.length; i++) {
            dot += v1[i] * v2[i];
        }
    }

    /**
     * Get the computed dot product
     * @return The dot product result
     */
    public int getDot() {
        return dot;
    }

    /**
     * Get the row index in result matrix
     * @return Row index
     */
    public int getRow() {
        return row;
    }

    /**
     * Get the column index in result matrix
     * @return Column index
     */
    public int getCol() {
        return col;
    }
}
