




import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input dimensions for the first matrix
        System.out.print("Enter the number of rows for Matrix A: ");
        int rowsA = sc.nextInt();
        System.out.print("Enter the number of columns for Matrix A: ");
        int colsA = sc.nextInt();

        // Input dimensions for the second matrix
        System.out.print("Enter the number of rows for Matrix B: ");
        int rowsB = sc.nextInt();
        System.out.print("Enter the number of columns for Matrix B: ");
        int colsB = sc.nextInt();

        // Check if multiplication is possible
        if (colsA != rowsB) {
            System.out.println("Matrix multiplication is not possible. The number of columns in Matrix A must equal the number of rows in Matrix B.");
            return;
        }

        // Initialize matrices
        int[][] matrixA = new int[rowsA][colsA];
        int[][] matrixB = new int[rowsB][colsB];

        // Input values for Matrix A
        System.out.println("Enter the values for Matrix A:");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                matrixA[i][j] = sc.nextInt();
            }
        }

        // Input values for Matrix B
        System.out.println("Enter the values for Matrix B:");
        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                matrixB[i][j] = sc.nextInt();
            }
        }

        // Perform multiplication
        int[][] result = multiplyMatrices(matrixA, matrixB);

        // Print the result
        System.out.println("Resultant Matrix:");
        printMatrix(result);
    }

    public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int rowsB = matrixB.length;
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

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}