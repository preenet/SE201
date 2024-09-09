
/**
 * Pree Thiengburanathum
 * SE201 Algorithm Design and Analysis
 * BreakingEq.java
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LinearEquationSolver {

    static int c1;
    static int c2;
    static int[] A;

    public static void main(String[] args) {
        try {
            // Read values from input.txt
            readInputFile("input_workshop1.txt");

            // Try to solve the equations
            solveEquations();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    public static void solveEquations() {
        // Initialize x array to store x1 to x12
        int[] x = new int[13]; // x[0] is unused

        // Step 1: Find x1 and x2 such that c1 = x1 + x2
        for (int x1 : A) {
            for (int x2 : A) {
                if (x1 + x2 == c1) {
                    x[1] = x1;
                    x[2] = x2;

                    // Step 2: Find x3 and x4 such that x4 = x3 + x1
                    for (int x3 : A) {
                        for (int x4 : A) {
                            if (x4 == x3 + x1) {
                                x[3] = x3;
                                x[4] = x4;

                                // Step 3: Find x6 and x7 such that x5 = x6 + x7
                                for (int x6 : A) {
                                    for (int x7 : A) {
                                        int x5 = x6 + x7;
                                        if (contains(A, x5)) {
                                            x[5] = x5;
                                            x[6] = x6;
                                            x[7] = x7;

                                            // Step 4: Find x8, x9, x11 such that x11 = x8 + x9
                                            for (int x8 : A) {
                                                for (int x9 : A) {
                                                    int x11 = x8 + x9;
                                                    if (contains(A, x11)) {
                                                        x[8] = x8;
                                                        x[9] = x9;
                                                        x[11] = x11;

                                                        // Step 5: Find x10 such that x6 = x2 + x10
                                                        for (int x10 : A) {
                                                            if (x6 == x2 + x10) {
                                                                x[10] = x10;

                                                                // Step 6: Find x12 such that x12 = x9 + c2
                                                                int x12 = x9 + c2;
                                                                if (contains(A, x12)) {
                                                                    x[12] = x12;

                                                                    // Solution found, print it
                                                                    printSolution(x);
                                                                    return;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // Helper method to check if a value is in set A
    public static boolean contains(int[] arr, int value) {
        for (int i : arr) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }

    // Print the solution
    public static void printSolution(int[] x) {
        System.out.println("Solution found:");
        for (int i = 1; i <= 12; i++) {
            System.out.println("x" + i + " = " + x[i]);
        }
    }

    // Method to read integers from input.txt and populate set A
    public static void readInputFile(String filename) throws FileNotFoundException {
        // Read the size of A
        try (Scanner scanner = new Scanner(new File(filename))) {
            // Read the size of A
            int size = scanner.nextInt();
            
            // Read c1 and c2
            c1 = scanner.nextInt();
            c2 = scanner.nextInt();
            
            // Read the elements of array A
            A = new int[size];
            for (int i = 0; i < size; i++) {
                if (scanner.hasNextInt()) {
                    A[i] = scanner.nextInt();
                }
            }
        }
    }
}
