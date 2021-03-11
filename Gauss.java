package Linear;

import java.util.*;

public class Gauss {

	public static void main(String[] args) {
		double[][] A = { { 1, 2, 1, 1 }, { 2, 2, 3, 1 }, { -1, -2, 2, 0 }, { 1, 0, 2, 1 } };
		double[] B = { 17, 35, 16, 24 };
		calculator(A, B);
	}

	public static void calculator(double[][] A, double[] B) {
		double x1n = 0, x2n = 0, x3n = 0, x4n = 0;
		double x1 = 0, x2 = 0, x3 = 0, x4 = 0;
		double er1 = 1, er2 = 1, er3 = 1, er4 = 1;
		int i = 0;
// while (i != 10) {
		while (er1 > 0.01 || er2 > 0.01 || er3 > 0.01 || er4 > 0.01) {
			x1n = (B[0] - (A[0][1] * x2) - (A[0][2] * x3) - (A[0][3] * x4)) / A[0][0];
			er1 = (x1n - x1) / x1n * 100;
			double abser1 = Math.abs(er1);
			er1 = abser1;
			x1 = x1n;
			x2n = (B[1] - (A[1][0] * x1) - (A[1][2] * x3) - (A[1][3] * x4)) / A[1][1];
			er2 = (x2n - x2) / x2n * 100;
			double abser2 = Math.abs(er2);
			er2 = abser2;
			x2 = x2n;
			x3n = (B[2] - (A[2][0] * x1) - (A[2][1] * x2) - (A[2][3] * x4)) / A[2][2];
			er3 = (x3n - x3) / x3n * 100;
			double abser3 = Math.abs(er3);
			er3 = abser3;
			x3 = x3n;
			x4n = (B[3] - (A[3][0] * x1) - (A[3][1] * x2) - (A[3][2] * x3)) / A[3][3];
			er4 = (x4n - x4) / x4n * 100;
			double abser4 = Math.abs(er4);
			er4 = abser4;
			x4 = x4n;
			System.out.println("Round " + (i + 1));
			System.out.println("x1 = " + x1n);
			System.out.println("x2 = " + x2n);
			System.out.println("x3 = " + x3n);
			System.out.println("x4 = " + x4n);
			System.out.println("Error x1 = " + er1 + " x2 = " + er2 + " x3 = " + er3 + "x4 = " + er4);
			System.out.println("--------------------------------------------");
			System.out.println();
			i++;
		}
	}
}