/**
 * 
 */
package com.zsh.statckAndQueue;

/**
 * @author Administrator
 * 队列
 * 插入 - O(1)
 * 删除 - O(1)
 */
public class QueueT {
	private int[] arr;
	private int front;
	private int rear;
	private int maxSize;
	private int nItems;
	
	public QueueT(int maxSize) {
		arr = new int[maxSize];
		front = 0;
		rear = -1;
		this.maxSize = maxSize;
		nItems = 0;
	}
	
	public boolean insert(int tar) {
		if(isFull()) {
			return false;
		}
		if(rear == maxSize-1) {
			rear = -1;
		}
		arr[++rear] = tar; 
		nItems++;
		return true;
	} 
	
	public int remove() {
		if(isEmpty()) {
			return -1;
		}
		if(front == maxSize) {
			front = 0;
		}
		nItems--;
		return arr[front++];
	}
	
	public boolean isEmpty() {
		return nItems == 0;
	}
	
	public boolean isFull() {
		return nItems == maxSize;
	}
	
	public int peek() {
		return arr[front];
	}
	
	public static void main(String[] args) {
		QueueT q = new QueueT(5);
		q.insert(1);
		q.insert(2);
		q.insert(3);
		q.insert(4);
		q.insert(5);
		
		q.remove();
		q.remove();
		q.remove();
		
		q.insert(6);
		q.insert(7);
		q.insert(8);
		
		while(!q.isEmpty()) {
			System.out.println(q.remove());
		}
		
	}
}
