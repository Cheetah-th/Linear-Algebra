package Linear;

class RowReduced {
	static double data[][] = { { 1, 2, 1, 1, 17 }, { 2, 2, 3, 1, 35 }, { -1, -2, 2, 0, 16 }, { 1, 0, 2, 1, 24 } };

	public static void main(String[] args) {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j <= i; j++) {
				if (i == j) { // diagonal
					makeAsone(i, data[i][j]);
				} else { // lower triangle
					makeAsZero(i, j, data[i][j]);
				}
				printArray();
				System.out.println("-------------------------");
			}
		}
		for (int i = data.length - 2; i >= 0; i--) { // backward
			for (int j = data.length - 1; j > i; j--) { // upper triangle
				makeAsZero(i, j, data[i][j]);
				printArray();
				System.out.println("-------------------------");
			}
		}
		for (int i = 0; i < data.length; i++) { // print B
			System.out.printf("X%d is %.3f%n", (i + 1), data[i][data.length]);
		}
	}

	static void makeAsone(int row, double temp) {
		for (int i = 0; i < data[row].length; i++) {
			data[row][i] /= temp;
		}
	}

	static void makeAsZero(int row1, int row2, double value) {
		for (int i = 0; i < data[0].length; i++) {
			data[row1][i] -= data[row2][i] * value;
		}
	}

	static void printArray() {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				System.out.printf("%5.1f", data[i][j]);
			}
			System.out.println();
		}
	}
}
