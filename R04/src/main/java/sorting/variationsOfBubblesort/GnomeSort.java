package sorting.variationsOfBubblesort;

import java.util.Arrays;

import sorting.AbstractSorting;
import util.Util;

/**
 * The implementation of the algorithm must be in-place!
 */
public class GnomeSort<T extends Comparable<T>> extends AbstractSorting<T> {
	public void sort(T[] array, int leftIndex, int rightIndex) {
		int i = leftIndex;
		while (i <= rightIndex) {
			if (i == leftIndex || array[i].compareTo(array[i-1]) >= 0) {
				i++;
			}
			else {
				Util.swap(array, i, i-1);
				i--;
			}
		}
	}
	
	public static void main(String[] args) {
		GnomeSort<Integer> comb = new GnomeSort<>();
		Integer[] arr = {1, -1, 4, -5,-7, 0, -7};
		System.out.println(Arrays.toString(arr));
		comb.sort(arr, 1, 3);
		System.out.println(Arrays.toString(arr));
	}
}