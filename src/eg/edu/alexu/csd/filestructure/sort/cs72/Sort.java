package eg.edu.alexu.csd.filestructure.sort.cs72;

import eg.edu.alexu.csd.filestructure.sort.IHeap;
import eg.edu.alexu.csd.filestructure.sort.ISort;

import java.util.ArrayList;

public class Sort<T extends Comparable<T>> implements ISort<T> {

	@Override
	public final IHeap heapSort(final ArrayList<T> unordered) {
		Heap heap = new Heap();
		heap.build(unordered);
		if (heap.size() == 1) {
			return heap;
		}
		if (heap.size() == 0) {
			return null;
		}
		heap.sort();
		return heap;
	}

	@Override
	public final void sortSlow(final ArrayList<T> unordered) {
		long startTime = System.nanoTime();

		for (int i = 0; i < unordered.size() - 1; i++) {
			for (int j = 0; j < unordered.size() - 1 - i; j++) {
				if (unordered.get(j).compareTo(unordered.get(j + 1)) > 0) {
					// Object temp = unordered.get(j);
					unordered.add(j, unordered.remove(j + 1));
					// unordered.add(j , (T) temp);
				}
			}
		}
		long endTime   = System.nanoTime();
		long totalTime = (endTime - startTime);
		System.out.println(totalTime);
	}


	@Override
	public final void sortFast(final ArrayList<T> unordered)
	{
		long startTime = System.nanoTime();

		mergeSort(unordered, 0, unordered.size() - 1);
		long endTime   = System.nanoTime();
		long totalTime = (endTime - startTime);
		System.out.println(totalTime);
	}


	private ArrayList<T> mergeSort(ArrayList<T> list, final int left, final int right) {
		int mid = ((right - left) / 2) + left;
		if (right - (mid) > 1) {
			list = mergeSort(list, mid + 1, right);
		}
		if (mid - left >= 1) {
			list = mergeSort(list, left, mid);
		}
		list = sortingTwoOrderedLists(list, left, right, mid);
		return list;

	}

	private ArrayList<T> sortingTwoOrderedLists(final ArrayList<T> list
	, final int left, final int right, final int mid) {
		ArrayList<T> temp = new ArrayList<>();
		int i = left, j = mid + 1;
		while (i <= mid && j <= right) {
			if (list.get(i).compareTo(list.get(j)) < 1) {
				temp.add(list.get(i));
				i++;
			} else {
				temp.add(list.get(j));
				j++;
			}
		}

		if (i <= mid) {
			while (i <= mid) {
				temp.add(list.get(i));
				i++;
			}
		} else if (j <= right) {
			while (j <= right) {
				temp.add(list.get(j));
				j++;
			}
		}

		for (int k = 0; k < temp.size(); k++) {
			list.set(left + k, temp.get(k));
		}
		return list;
	}

}
