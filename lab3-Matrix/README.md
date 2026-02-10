Matrix Class
In this project, you will create a Matrix class that represents a mathematical matrix using a 2D array and implements common matrix operations.

Instructions:
Create a class named Matrix.java.
The class must have a private instance variable: private int[][] data;.
Implement the following public methods:
public Matrix(int rows, int cols): Constructor that initializes the matrix with the given dimensions.
public Matrix(int[][] data): Constructor that initializes the matrix with a pre-existing 2D array.
public void populateRandom(): Fills the matrix with random integer values between 1 and 10.
public Matrix add(Matrix other): Adds this matrix to another matrix. Challenge: If the matrices do not have the same dimensions, this method must throw an IllegalArgumentException. Returns a new Matrix object that is the sum of the two.
public Matrix multiply(Matrix other): Multiplies this matrix by another matrix. Challenge: If the number of columns in this matrix does not equal the number of rows in the other matrix, throw an IllegalArgumentException. Returns a new Matrix object that is the product.
@Override public String toString(): Returns a string representation of the matrix, formatted in rows and columns.
