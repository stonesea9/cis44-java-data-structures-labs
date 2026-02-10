public class Main {
    public static void main(String[] args) {

        Matrix A = new Matrix(2, 3);
        Matrix B = new Matrix(3, 2);

        A.populateRandom();
        B.populateRandom();

        System.out.println("Matrix A:");
        System.out.println(A);

        System.out.println("Matrix B:");
        System.out.println(B);

        Matrix C = A.multiply(B);
        System.out.println("A x B:");
        System.out.println(C);
    }
}
