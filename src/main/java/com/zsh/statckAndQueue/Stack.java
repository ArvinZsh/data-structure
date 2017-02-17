/**
 * 
 */
package com.zsh.statckAndQueue;

/**
 * @author Administrator
 * 栈(数组)
 * 插入 - O(1)
 * 删除 - O(1)
 */
public class Stack {
	private int[] arr;
	private int size;
	
	public Stack(int maxSize) {
		arr = new int[maxSize];
		size = -1;
	}
	
	public boolean push(int tar) {
		if(isFull()) {
			return false;
		} else {
			arr[++size] = tar;
			return true;
		}
	}
	
	public int pop() {
		if(isEmpty()) {
			return -1;
		}
		return arr[size--];
	}
	
	public boolean isFull() {
		return size == arr.length-1;
	}
	
	public boolean isEmpty() {
		return size == -1;
	}
	
	public int peek() {
		return arr[size];
	}
	
	public static void main(String[] args) {
		Stack s = new Stack(5);
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);
		
		while(!s.isEmpty()) {
			System.out.println(s.pop());
		}
	}
}

