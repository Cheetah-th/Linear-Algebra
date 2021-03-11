//61050190
import java.util.Random;

class MergeSort {
	static Random random = new Random();
	int count = 0;

	public static void main(String[] args) {
		MergeSort M = new MergeSort();
		int a[] = new int[50];
		int low = 20;
		int high = 90;
		
		anyRandomIntRange(a, random, low, high);
		
		System.out.println("Random integer from " + low + " to " + high);
		printArray(a);
		
		M.MS(a, 0, a.length - 1);
		
		System.out.println("\nAfter Merge sort");
		printArray(a);
		
		System.out.println("\nSwitch: " + M.count);
		
	}

	public void Merge(int[] a, int lo, int m, int hi) {
		int temp[] = new int[hi + 1];
		int l = lo, i = lo, j = m;
		while (l <= (m - 1) && j <= hi) {
			if (a[l] <= a[j]) {
				temp[i] = a[l];
				l++;
			} else {
				temp[i] = a[j];
				count++;
				j++;
			}
			i++;
		}
		if (l > (m - 1)) {
			for (int k = j; k <= hi; k++) {
				temp[i] = a[k];
				i++;
			}
		} else {
			for (int k = l; k <= (m - 1); k++) {
				temp[i] = a[k];
				i++;
			}
		}
		for (i = lo; i <= hi; i++)
			a[i] = temp[i];
		
	}
	
	public void MS(int[] a, int lo, int hi) {
		int m = 1;
		if (lo < hi) {
			if ((lo + hi) % 2 == 0) {
				m = (lo + hi) / 2;
			} else {
				m = ((lo + hi) / 2) + 1;
			}
			MS(a, lo, m - 1);
			MS(a, m, hi);
			Merge(a, lo, m, hi);
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
