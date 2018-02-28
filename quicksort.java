
/*
 * An attempt at quicksort
 * Course exercise from autumn 2016 for the 
 * course "data structures and algorithms"
 * Basic quicksort with insertion sort
 * for small lists.
 */
public class genPikalajittelu<T extends Comparable<T>> {

	private T array[];
	private int length;
	private int k;

	public void sort(T[] inputArr) {

		k = 9;

		if (inputArr == null || inputArr.length == 0) {
			return;
		}
		this.array = inputArr;
		length = inputArr.length;
		CallquickSort(0, length - 1);
	}

	private T Cent(T x, T y, T z) {
		if (((x.compareTo(y) <= 0) && (y.compareTo(z) <= 0)) || ((z.compareTo(y) <= 0) && (y.compareTo(x) <= 0)))
			return y;

		return Cent(y, z, x);
	}

	private T calcPivot(T t[], int a, int b) {
		int c = a + (b - a) / 2;
		T aValue = t[a];
		T bValue = t[b];
		T cValue = t[c];

		return Cent(aValue, cValue, bValue);
	}

	private void swap(T t[], int i, int j) {
		T temp = t[i];
		t[i] = t[j];
		t[j] = temp;
	}

	private int Partition(T A[], int p, int r) {

		T a = calcPivot(A, p, r);

		int i = p - 1;
		int j = r + 1;
		while (i < j) {
			do {
				i++;
			} while (A[i].compareTo(a) < 0);
			do {
				j--;
			} while (A[j].compareTo(a) > 0);
			if (i < j) {
				swap(A, i, j);
			}
		}
		return j;
	}

	public void doInsertionSort(T t[], int a, int b) {

		for (int i = a + 1; i <= b; i++) {
			for (int j = i; j > a; j--) {
				if (t[j].compareTo(t[j - 1]) < 0) {
					swap(t, j, j - 1);
				}
			}
		}
	}

	public void IterquickSort(T A[], int p, int r) {
		if ((r - p + 1) <= k) {

			doInsertionSort(array, p, r);
			return;
		}

		while (p < r) {
			int q = Partition(A, p, r);

			if (q - p + 1 < r - q) {
				IterquickSort(A, p, q);
				p = q + 1;
			} else {
				IterquickSort(A, q + 1, r);
				r = q;
			}
		}
	}

	private void RecurquickSort(T A[], int p, int r) {

		if ((r - p + 1) <= k) {
			doInsertionSort(array, p, r);
			return;
		}

		if (p < r) {
			int q = Partition(array, p, r);

			if ((q - p) > (r - (q + 1))) {
				IterquickSort(A, p, q); 
				RecurquickSort(A, q + 1, r);
			} else {
				RecurquickSort(A, p, q);
				IterquickSort(A, q + 1, r); 
			}

			// RecurquickSort(A, p, q);
			// RecurquickSort(A, q + 1, r);
		}
	}

	private void CallquickSort(int p, int r) {

		RecurquickSort(array, p, r);
		
	}

	private static void Sort2() {
		genPikalajittelu<String> sorter = new genPikalajittelu<String>();
		String[] input = { "mwefa", "asdf", "sdfg", "drg", "Mgfed", "0", "kisdfaw", "kosfe", "7345", "131", "äöl" };

		sorter.sort(input);

		for (String i : input) {
			System.out.print(i);
			System.out.print(" ");
		}
	}

	private static void Sort1() {
		genPikalajittelu<Integer> sorter = new genPikalajittelu<Integer>();

		Integer[] input = { 24, 2, 45, 20, 56, 75, -1, 5, 0, 999, 1, 2, 3, 100, 58, -15, 2, 56, 99, 53, 12, 16, 56, 43,
				67, 99, 55, 33, 235, 56, 953, 345, 4, 4, 3 };

		sorter.sort(input);

		for (int i : input) {
			System.out.print(i);
			System.out.print(" ");
		}
	}

	private static void Sort3() {
		genPikalajittelu<Integer> sorter = new genPikalajittelu<Integer>();

		int c = 1000000;
		int a;
		Integer[] input = new Integer[c];
		for (a = 0; a < input.length; a++) {
			input[a] = (Integer) (int) (Math.random() * 1000);

		}
		
		sorter.sort(input);
		System.out.println();
		for (int i : input) {
			System.out.print(i);
			System.out.print(" ");
		}
	}

	public static void main(String a[]) {

		Sort1();
		System.out.println();
		Sort2();
		System.out.println();
		
	}

}