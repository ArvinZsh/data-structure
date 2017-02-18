package com.zsh.arr;

/**
 * 无序数组
 * */
public class MyArr {
	/** 数组 */
	private Object[] objArr;
	/** 数组拥有元素 */
	private int nElems;
	/** 默认新建大小 */
	private int defaultSize = 10;
	
	public MyArr() {
		objArr = new Object[defaultSize];
	}
	
	public MyArr(int max) {
		defaultSize = max;
		objArr = new Object[max];
	}
	
	/** 插入某个元素 - O(1) */
	private boolean insert(Object o) {
		
		if(nElems == this.defaultSize) { // 已经到数组最大容量
			return false;
		}
		
		objArr[nElems] = o;
		nElems++;
		
		return true;
	}
	
	/** 查找某个元素 - O(n) */
	private Object find(Object tar) {
		
		int i;
		for(i=0; i<nElems; i++) {
			if(tar.equals(objArr[i])) break;
		}
		if(i == nElems) {
			return null;
		} else {
			return objArr[i];
		}
	}
	
	/** 删除某个元素 - O(n) */
	public boolean delete(Object tar) {
		
		int i;
		for(i=0; i < nElems; i++) { // 找到该元素
			if(tar.equals(objArr[i])) break; 
		}
		if(i == nElems) { // 没找到
			return false;
		}
		for(int j=i; j<nElems; j++) { // 
			objArr[j] = objArr[j+1];
		}
		nElems--;
		return true;
	}
	
	/** 显示所有元素 - O(n) */
	public void display() {
		for(int i=0; i < nElems; i++) { // 找到该元素
			System.out.println(objArr[i]);
		}
	}
}
