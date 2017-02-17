/**
 * 
 */
package com.zsh.statckAndQueue;

/**
 * @author Administrator 优先队列
 * 插入 - O(n)
 * 删除 - O(1)
 */
public class PQueue {
	private int[] arr;
	private int nItems;
	private int size;

	public PQueue(int maxSize) {
		arr = new int[maxSize];
		nItems = 0;
		size = maxSize;
	}

	public boolean insert(int tar) {
		if (isFull()) {
			return false;
		}
		int i = 0;
		if (nItems == 0) {
			arr[0] = tar;
		} else {
			for (i = nItems - 1; i >= 0; i--) {
				if (arr[i] < tar) {
					arr[i + 1] = arr[i];
				} else {
					break;
				}
			}
			arr[i+1] = tar;
		}
		nItems++;
		return true;
	}

	public int remove() {
		if (isEmpty()) {
			return -1;
		}
		return arr[--nItems];
	}

	public int peek() {
		return arr[0];
	}

	public boolean isEmpty() {
		return nItems == 0;
	}

	public boolean isFull() {
		return nItems == size;
	}

	public static void main(String[] args) {
		PQueue q = new PQueue(5);
		q.insert(5);
		q.insert(9);
		q.insert(0);
		q.insert(1);
		q.insert(5);

		while (!q.isEmpty()) {
			System.out.println(q.remove());
		}
	}
}
