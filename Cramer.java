package Linear;

import java.util.*;

public class Cramer {
	public static void main(String[] args) {
		double[][] a = { { 0, 0, 0, 0, 0 }, { 0, 1, 2, 1, 1 }, { 0, 2, 2, 3, 1 }, { 0, -1, -2, 2, 0 },
				{ 0, 1, 0, 2, 1 } };
		double[][] b = new double[4][4];
		double[][] c = { { 0, 0, 0, 0, 0 }, { 0, 1, 2, 1, 1 }, { 0, 2, 2, 3, 1 }, { 0, -1, -2, 2, 0 },
				{ 0, 1, 0, 2, 1 } };
		double[] d = { 0, 17, 35, 16, 24 };

		double A = Detr(c, b);
		System.out.println("Determinant = " + A);
		Fineans(a, c, d, b, 1);
		double x1 = Detr(c, b) / A;
		System.out.println("x1 = " + x1);
		resetc(a, c);
		resetb(b);
		Fineans(a, c, d, b, 2);
		double x2 = Detr(c, b) / A;
		System.out.println("x2 = " + x2);
		resetc(a, c);
		resetb(b);
		Fineans(a, c, d, b, 3);
		double x3 = Detr(c, b) / A;
		System.out.println("x3 = " + x3);
		resetc(a, c);
		resetb(b);
		Fineans(a, c, d, b, 4);
		double x4 = Detr(c, b) / A;
		System.out.println("x4 = " + x4);
		resetc(a, c);
		resetb(b);
// System.out.println("ANS x1 = "+Fineans(a,c,d,b,1));
// System.out.println("ANS x2 = "+Fineans(a,c,d,b,2));
// System.out.println("ANS x3 = "+Fineans(a,c,d,b,3));
// System.out.println("ANS x4 = "+Fineans(a,c,d,b,4));
	}

	public static double Detr(double a[][], double b[][]) {
		double ans = 0;
		for (int i = 1; i <= 4; i++) {
			if (i % 2 == 1) {
// System.out.println("r"+i);
				tranform(a, b, i);
				ans = ans + (a[i][1] * Det33(b));
			}
			if (i % 2 == 0) {
// System.out.println("r"+i);
				tranform(a, b, i);
				ans = ans - (a[i][1] * Det33(b));
			}
		}
		return ans;
	}

	public static double Det33(double b[][]) {
		double toteldown = 0, totelup = 0, down = 1, up = 1;
		for (int i = 0; i < 3; i++) {
			for (int j = 1; j <= 3; j++) {
				int row = (i + j);
				if (row > 3)
					row -= 3;
				down = down * b[j][row];
// System.out.println(down +" "+(i+1));
			}
			toteldown = toteldown + down;
			down = 1;
		}
		for (int i = 4; i > 1; i--) {
			for (int j = 1; j <= 3; j++) {
				int col = (i - j);
				if (col < 1)
					col += 3;
				up = up * b[col][j];
// System.out.println(up+" "+(6-i));
			}
			totelup = totelup + up;
			up = 1;
		}
		double ans = toteldown - totelup;
		return ans;
	}

	public static void tranform(double a[][], double b[][], int x) {
		if (x == 1) {
			for (int i = 4; i > 1; i--) {
				for (int j = 1; j <= 3; j++) {
					b[i - x][j] = a[i][j + 1];
				}
			}
		} else if (x == 2) {
			for (int i = 1; i <= 3; i++) {
				b[1][i] = a[1][i + 1];
				b[2][i] = a[3][i + 1];
				b[3][i] = a[4][i + 1];
			}
		} else if (x == 3) {
			for (int i = 1; i <= 3; i++) {
				b[1][i] = a[1][i + 1];
				b[2][i] = a[2][i + 1];
				b[3][i] = a[4][i + 1];
			}
		} else if (x == 4) {
			for (int i = 1; i <= 3; i++) {
				b[1][i] = a[1][i + 1];
				b[2][i] = a[2][i + 1];
				b[3][i] = a[3][i + 1];
			}
		}
	}

	public static void Fineans(double a[][], double c[][], double d[], double b[][], int x) {
		if (x == 1) {
			for (int i = 1; i <= 4; i++) {
				c[i][1] = d[i];
			}
		} else if (x == 2) {
			for (int i = 1; i <= 4; i++) {
				c[i][2] = d[i];
			}
		} else if (x == 3) {
			for (int i = 1; i <= 4; i++) {
				c[i][3] = d[i];
			}
		} else if (x == 4) {
			for (int i = 1; i <= 4; i++) {
				c[i][4] = d[i];
			}
		}
	}

	public static void resetb(double b[][]) {
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				b[i][j] = 0;
			}
		}
	}

	public static void resetc(double a[][], double c[][]) {
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				c[i][j] = a[i][j];
			}
		}
	}
}