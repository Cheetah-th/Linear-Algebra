//61050190
import java.util.Random;

class QuickSort {
	static Random random = new Random();
	int count = 0;
	
	public static void main(String[] args) {
		QuickSort Q = new QuickSort();
		int a[] = new int[50];
		int low = 20;
		int high = 90;
		
		anyRandomIntRange(a, random, low, high);
		
		System.out.println("Random integer from " + low + " to " + high);
		printArray(a);
		
		Q.QS(a, 0, a.length - 1);
		
		System.out.println("\nAfter Quick sort");
		printArray(a);
		
		System.out.println("\nSwitch: " + Q.count);
		
	}

	public int Partition(int[] a, int m, int p) {
		int i = m, t = a[m], temp;
		while (i <= p) {
			do {
				i = i + 1;
			} while (a[i] < t);
			do {
				p = p - 1;
			} while (a[p] > t);
			if (i < p) {
				temp = a[i];
				a[i] = a[p];
				a[p] = temp;
				count++;
			} else {
				temp = a[m];
				a[m] = a[p];
				a[p] = temp;
				count++;
			}
		}
		return p;
		
	}
	
	public void QS(int[] data, int i, int j) {
		if (i < j) {
			int p = j + 1;
			int k = Partition(data, i, p);
			QS(data, i, k - 1);
			QS(data, k + 1, j);
		}
		
	}
	
	static void printArray(int a[]) {
		int n = a.length;
		for (int i = 0; i < n; ++i) {
			System.out.print(a[i] + " ");
		}
		System.out.println();

	}

	public static void anyRandomIntRange(int a[], Random random, int low, int high) {
		for (int i = 0; i < a.length; i++) {
			int rd = random.nextInt((high - low) + 1) + low;
			a[i] = rd;
		}

	}
	
}
