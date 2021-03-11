package Linear;

import java.util.*;

class LUMethod {
	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter n : ");
		n = sc.nextInt();
		double[][] L = new double[n][n];
		double[][] U = new double[n][n];
		double A[][] = new double[n][n];
		double B[] = new double[n];
		double X[][] = new double[n][1];
		double D[][] = new double[n][1];
		System.out.println("Enter A " + n + " * " + n + " ");
		MetrixA.setMet(A);
		System.out.println("Enter B " + n + " * 1 ");
		MetrixA.setMet(B);
// put default val of L , U into metrices
		for (int i = 0; i < L.length; i++) {
			L[i][i] = 1;
		}
		MetrixA.findLU(L, U, A);
		MetrixA.findD(L, D, B);
		MetrixA.findX(U, X, D);
		System.out.println("Metrix L");
		MetrixA.printMet(L);
		System.out.println("Metrix U");
		MetrixA.printMet(U);
		System.out.println("Metrix D");
		MetrixA.printMet(D);
		System.out.println("Metrix X");
		MetrixA.printMet(X);
	}
}

class MetrixA {
	static Scanner sc = new Scanner(System.in);

	public static void devide(double[][] A, double D) {
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				A[i][j] /= D;
			}
		}
	}

	public static void Multiple(double[][] a, double[][] b, double[][] ans) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				ans[i][j] = multiSum(a, b, i, j);
			}
		}
	}

	public static double multiSum(double[][] a, double[][] b, int row, int col) {
		double sum = 0;
		for (int i = 0; i < a[0].length; i++) {
			sum += a[row][i] * b[i][col];
		}
		return sum;
	}

	public static void findLU(double[][] L, double[][] U, double[][] A) {
		double temp;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				if (i == 0) {
					U[i][j] = A[i][j];
				} else if (j == 0) {
					L[i][j] = A[i][j] / U[0][0];
				} else {
					temp = multiSum(L, U, i, j);
					if (j >= i) {
						U[i][j] = (A[i][j] - temp);
					} else {
						L[i][j] = (A[i][j] - temp) / U[j][j];
					}
				}
			}
		}
	}

	public static void findD(double[][] L, double[][] D, double[] B) {
		double temp;
		D[0][0] = B[0];
		for (int i = 1; i < D.length; i++) {
			temp = multiSum(L, D, i, 0);
			D[i][0] = (B[i] - temp);
		}
	}

	public static void findX(double[][] U, double[][] X, double[][] D) {
		double temp;
		X[X.length - 1][0] = D[D.length - 1][0] / U[U.length - 1][U.length - 1];
		for (int i = X.length - 2; i >= 0; i--) {
			temp = multiSum(U, X, i, 0);
			X[i][0] = (D[i][0] - temp) / U[i][i];
		}
	}

	public static void printMet(double[][] ans) {
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[0].length; j++) {
				System.out.printf("%8.3f", ans[i][j]);
			}
			System.out.println();
		}
	}

	public static void setMet(double met[][]) {
		for (int i = 0; i < met.length; i++) {
			for (int j = 0; j < met[0].length; j++) {
				met[i][j] = sc.nextInt();
			}
		}
	}

	public static void setMet(double met[]) {
		for (int i = 0; i < met.length; i++) {
			met[i] = sc.nextInt();
		}
	}

	public static double det(double[][] A) {
		double result = 0;
		if (A.length == 1) {
			return A[0][0];
		} else {
			for (int i = 0; i < A.length; i++) {
				result += A[0][i] * cofactor(0, i, A);
			}
		}
		return result;
	}

	public static double cofactor(int row, int col, double A[][]) {
		int c = (row + col) % 2 == 0 ? 1 : -1;
		return c * minor(row, col, A);
	}

	public static double minor(int row, int col, double A[][]) {
		double B[][] = new double[A.length - 1][A.length - 1];
		int r = 0, c = 0;
		for (int i = 0; i < A.length; i++) {
			if (i != row) {
				for (int j = 0; j < A.length; j++) {
					if (j != col) {
						B[r][c] = A[i][j];
						c++;
					}
				}
				c = 0;
				r++;
			}
		}
		return det(B);
	}

	public static double[][] adj(double[][] data) {
		double C[][] = new double[data.length][data[0].length];
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				C[i][j] = MetrixA.cofactor(i, j, data);
			}
		}
		return MetrixA.transpost(C);
	}

	public static double[][] transpost(double met[][]) {
		double[][] T = new double[met[0].length][met.length];
		for (int i = 0; i < met.length; i++) {
			for (int j = 0; j < met[0].length; j++) {
				T[j][i] = met[i][j];
			}
		}
		return T;
	}
}
