/**
 * 
 */
package com.zsh.order;

/**
 * @author Administrator
 * 希尔排序
 */
public class ShellOrder {
	public static void shellOrder(int[] tar) {
		int h = 1;
		while(h < tar.length/3+1) {
			h = h*3+1;
		}
		
		int outer, inner;
		while(h>0) {
			
			for(outer=h;outer<tar.length;outer++) {
				int temp = tar[outer];
				inner = outer;
				while(inner > h-1 && tar[inner-h] > temp) {
					tar[inner] = tar[inner-h];
					inner -= h;
				}
				tar[inner] = temp;
			}
			
			h = (h-1)/3;
		}
	}
	
	public static void main(String[] args) {
		int[] a = {10,9,8,7,7,6,5,4,3,3,2,1};
		for(int temp : a) {
			System.out.println(temp);
		}
		
		System.out.println("=================");
		shellOrder(a);
		for(int temp : a) {
			System.out.println(temp);
		}
	}
}
