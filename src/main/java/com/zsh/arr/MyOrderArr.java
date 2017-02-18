/**
 *	@author  zsh  
 * 	@date    2017年2月16日 下午6:22:24 
 *	@version 1.0 
 * 	有序数组, 采用二分查找
*/
package com.zsh.arr;

import java.util.ArrayList;

/**
 * @author zhengshenghui
 *
 */
public class MyOrderArr<T> {
	private int[] objArr;
	private int nElems;
	private int defaultSize;
	
	public MyOrderArr() {
		objArr = new int[defaultSize];
	}
	
	public MyOrderArr(int maxSize) {
		objArr = new int[maxSize];
		defaultSize = maxSize;
	}
	
	/**
	 * 查找某一元素下标,采用二分法查找 - O(log(n))
	 * */
	public int findTarIndex(int tar) {
		
		int cur;
		int lowerI = 0;
		int upperI = nElems - 1;
		
		while(true) {
			cur = (lowerI + upperI)/2;
			if(tar == objArr[cur]) { // 找到目标
				break;
			} else if(lowerI > upperI) {
				return nElems;
			} else {
				if(tar >= objArr[cur]) { // 落在右边
					lowerI = cur + 1;
				} else { // 落在左边
					upperI = cur - 1;
				}
			}
		}
		
		return cur;
	}
	
	/**
	 * 查找某一元素,采用二分法查找 - O(log(n))
	 * */
	public int find(int tar) {
		int idx = findTarIndex(tar);
		if(idx == nElems) {
			return nElems;
		} else {
			return objArr[idx];
		}
	}
	
	/**
	 * 插入某一元素,先找(可遍历可二分)再移 - O(n)
	 * */
	public boolean insert(int tar) {
		if(nElems == defaultSize) {
			return false;
		}
		int i;
		for(i=0; i<nElems; i++) {
			if(tar < objArr[i]) {
				break;
			}
		}
		for(int j=nElems; j>i ; j--) {
			objArr[j] = objArr[j-1];
		}
		objArr[i] = tar;
		nElems++;
		return true;
	}
	
	/**
	 * 删除某一元素 - log(n)
	 * */
	public boolean delete(int tar) {
		int idx = findTarIndex(tar);
		if(idx == nElems) {
			return false;
		} else {
			for(int i=idx; i<nElems; i++) {
				objArr[i] = objArr[i+1];
			}
			nElems--;
			return true;
		}
	}
	
	/** 显示所有元素 - O(n) */
	public void display() {
		for(int i=0; i < nElems; i++) { // 找到该元素
			System.out.println(objArr[i]);
		}
	}
}
