import java.util.Random;

public class Matrix {

    // Internal 2D array to store matrix data
    private int[][] data;

    public Matrix(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Rows and columns must be positive.");
        }
        data = new int[rows][cols];
    }


    public Matrix(int[][] data) {
        if (data == null || data.length == 0 || data[0].length == 0) {
            throw new IllegalArgumentException("Invalid matrix data.");
        }

        // Deep copy to protect internal data
        int rows = data.length;
        int cols = data[0].length;
        this.data = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            if (data[i].length != cols) {
                throw new IllegalArgumentException("All rows must have the same length.");
            }
            for (int j = 0; j < cols; j++) {
                this.data[i][j] = data[i][j];
            }
        }
    }


    public void populateRandom() {
        Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] = random.nextInt(10) + 1; // 1 to 10
            }
        }
    }

    public Matrix add(Matrix other) {
        if (other == null) {
            throw new IllegalArgumentException("Other matrix cannot be null.");
        }

        if (data.length != other.data.length ||
                data[0].length != other.data[0].length) {
            throw new IllegalArgumentException("Matrices must have the same dimensions for addition.");
        }

        int rows = data.length;
        int cols = data[0].length;
        Matrix result = new Matrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = data[i][j] + other.data[i][j];
            }
        }

        return result;
    }

    public Matrix multiply(Matrix other) {
        if (other == null) {
            throw new IllegalArgumentException("Other matrix cannot be null.");
        }

        int thisRows = data.length;
        int thisCols = data[0].length;
        int otherRows = other.data.length;
        int otherCols = other.data[0].length;

        if (thisCols != otherRows) {
            throw new IllegalArgumentException(
                    "Number of columns in first matrix must equal number of rows in second matrix."
            );
        }

        Matrix result = new Matrix(thisRows, otherCols);

        for (int i = 0; i < thisRows; i++) {
            for (int j = 0; j < otherCols; j++) {
                int sum = 0;
                for (int k = 0; k < thisCols; k++) {
                    sum += data[i][k] * other.data[k][j];
                }
                result.data[i][j] = sum;
            }
        }

        return result;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < data.length; i++) {
            sb.append("[ ");
            for (int j = 0; j < data[0].length; j++) {
                sb.append(String.format("%4d", data[i][j]));
            }
            sb.append(" ]\n");
        }

        return sb.toString();
    }
}
