package Tree;

import java.util.Arrays;

public class MinHeap {

	int capacity = 10;;
	int size = 0;
	int[] items = new int[capacity];

	private void checkCapacity() {
		if (items.length == capacity) {
			this.capacity = 2 * capacity;
			Arrays.copyOf(items, capacity);
		}

	}

	private int getParentIndex(int index) {
		return (index - 1) / 2;
	}

	private int getLeftChildIndex(int index) {
		return index * 2 + 1;
	}

	private int getRightChildIndex(int index) {
		return index * 2 + 2;
	}

	private boolean hasLeftChild(int index) {
		return (getLeftChildIndex(index) < size);
	}

	private boolean hasRightChild(int index) {
		return (getRightChildIndex(index) < size);
	}

	private boolean hasParent(int index) {
		return (getParentIndex(index) >= 0);
	}

	public void add(int value) {

		checkCapacity();
		items[size] = value;
		heapifyUp();
		size++;

		System.out.println(this.toString());

	}

	public int poll() {
		int value = items[0];
		items[0] = items[size - 1];
		size=size-1; // shift size to -2 to remove last element
		heapifyDown();
		items[size]=0;

		return value;
	}

	private void swap(int i, int j) {
		int temp = items[i];
		items[i] = items[j];
		items[j] = temp;
	}

	private void heapifyUp() {

		int index = size;
		int parent = getParentIndex(index);

		while (hasParent(index) && items[parent] > items[index]) {
			swap(parent, index);
			index = parent;
			parent = getParentIndex(index);
		}

	}

	private void heapifyDown() {

		int index = 0;
		int min = 0;

		while ((hasLeftChild(index) || hasRightChild(index))) {

			int left = getLeftChildIndex(index);
			int right = getRightChildIndex(index);
			min = items[left]<items[right]?left:right;

			if (items[index] > items[min])
				swap(index, min);
			else
				break;
			
			index = min;
		}
	}

	@Override
	public String toString() {

		StringBuilder s = new StringBuilder();

		for (int a : items)
			s.append(a).append(" , ");

		return s.toString();
	}

}