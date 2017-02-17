/**
 * 
 */
package com.zsh.order;

/**
 * @author Administrator
 *
 */
public class Order {
//	class Node {
//		int value;
//		Node next;
//		static Node merge(Node h1, Node h2);
//		}
//		h1、h2为有序链表的头结点，实现有序链表的合并函数
//		1、时间：O(N)
//		2、空间：常数
//		3、非递归
	
	public static void main(String[] args) {
		int[] tar = {99,98,97,65,43,21,10,543,41,41,75,89,1,89};
//		bubbleSort(tar);
//		selectSort(tar);
		insertSort(tar);
		for(int i : tar) {
			System.out.print(i+" ");
		}
	}
	
	/**
	 * 冒泡排序 - O(n2平方)
	 * */
	public static void bubbleSort(int[] arr) {
		int out,in;
		for(out=arr.length-1; out>0; out--) {
			for(in=0; in<out; in++) {
				if(arr[in] > arr[in+1]) {
					int temp = arr[in+1];
					arr[in+1] = arr[in];
					arr[in] = temp;
				}
			}
		}
	}
	
	/**
	 * 选择排序
	 * 比较(O(n2))
	 * 交换(O(n))
	 * */
	public static void selectSort(int[] arr) {
		int out,in;
		for(out=0; out<arr.length; out++) {
			int min = out;
			for(in=out+1; in<arr.length; in++) {
				if(arr[in] < arr[min]) {
					min = in;
				}
			}
			int temp = arr[out];
			arr[out] = arr[min];
			arr[min] = temp;
		}
	}
	
	/**
	 * 插入排序
	 * 随机:(O(n2))
	 * 有一定顺序的:(O(n))
	 * */
	public static void insertSort(int[] arr) {
		int out,in;
		for(out=1; out<arr.length; out++) {
			int temp = arr[out];
			in = out;
			while(in >0 && arr[in-1]>temp) {
				arr[in] = arr[in-1];
				in--;
			}
			arr[in] = temp;
		}
	}
}
