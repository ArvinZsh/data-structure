/**
 * 
 */
package com.zsh.order;

import java.util.Random;

import com.zsh.arr.MyArr;

/**
 * @author Administrator
 * 快速排序
 * O(n*log(N))
 */
public class QuickOrder {
	
	int[] tar;
	
	public QuickOrder(int[] tar) {
		this.tar = tar;
	}
	
	public void quickOrder(int leftPtr, int rightPtr) {
		int size = rightPtr - leftPtr + 1;
		if(size <= 3) {
			// 插入排序 
			insertOrder(leftPtr, rightPtr);
		} else { 
			// 找到枢纽值(三项取中)
			int median = medianOf3(leftPtr, rightPtr);
			// 划分算法:循环把位于序列里内容按: 左边<枢纽值,枢纽值,右边大于枢纽值排好并取得枢纽值的索引位置
			int partition = partitionIt(leftPtr, rightPtr, median);
			// 左边子数组再次递归调用
			quickOrder(leftPtr, partition-1);
			// 右边子数组再次递归调用
			quickOrder(partition+1, rightPtr);
		}
	}
	
	// 划分算法:
	// 1. 循环把位于序列里内容按: 左边<枢纽值,枢纽值,右边大于枢纽值排好
	// 2. 取得枢纽值的索引位置
	private int partitionIt(int left, int right, int pivot) {
		
		int leftPtr = left;
		// 取枢纽值
		int rightPtr = right-1;
		
		while(true) {
			// 找到左边子数组比枢纽值要大的
			while(tar[++leftPtr] < pivot) {
				
			}
			
			// 找到右边子数组比枢纽值要小的
			while(tar[--rightPtr] > pivot) {
				
			}
			if(leftPtr >= rightPtr) {
				break;
			} else {
				swap(leftPtr, rightPtr);
			}
		}
		// 枢纽值所在位置下次就不用再匹配了,所以放在右边子数组的最左边
		// 则现在 leftPtr,rightPtr,指向的都是枢纽位置
		swap(leftPtr, right - 1);
		
		// 枢纽值所在的索引位置
		return leftPtr;
	}

	// 找到枢纽值(三项取中), 并把枢纽值放到rightPtr-1位上
	public int medianOf3(int leftPtr, int rightPtr) {
		// 通过排最左,最右,及中值的数知道最左边的tar[leftPtr]不需要排,因为它正确的落在了枢纽值的左边
		// 同理tar[rightPtr]不需要排,因为它落在了枢纽值的右边,两个值分别对应在了正确的数组之内
		
		int center = (rightPtr+leftPtr)/2;
		if(tar[leftPtr] > tar[center]) {
			swap(leftPtr, center);
		}
		
		if(tar[center] > tar[rightPtr]) {
			swap(center, rightPtr);
		}
		
		if(tar[leftPtr] > tar[center]) {
			swap(leftPtr, center);
		}
		
		// 划分算法取最右边的值作为枢纽值,所以这里要交换下
		swap(center, rightPtr-1);
		
		return tar[rightPtr-1];
	}
	
	// 交换两个下标的数据
	public void swap(int idx1, int idx2) {
		int temp = tar[idx1];
		tar[idx1] = tar[idx2];
		tar[idx2] = temp;
	}
	
	// 插入排序
	public void insertOrder(int minIdx, int maxIdx) {
		// 初始化outer指向minIdx+1位,inner指向outer
		// 核心思想
		// 1. outer右边maxIdx之前(包括maxIdx)都是要进行排序的
		// 2. outer左边的inner在minIdx之前(包括minIdx),不断地往左移和tar[outer]进行比较
		// 	  inner左移过程中,outer左边inner右边的都往右移一位
		//    最后tar[inner]的值改为temp(tar[outer])
		
		int outer = minIdx + 1;
		while(outer <= maxIdx) {
			
			int inner = outer;
			int temp = tar[inner];
			while(inner-1 >= minIdx && tar[inner-1] > temp) {
				swap(inner, inner-1);
				inner -= 1;
			}
			tar[inner] = temp;
			
			outer++;
		}
	}
	
	public void display() {
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<tar.length; i++) {
			sb.append(tar[i]+",");
		}
		if(sb.toString().length() > 0) {
			System.out.println(sb);
		} else {
			System.out.println("数组为空");
		}
	}
	
	public static void main(String[] args) {
		int[] tar = new int[100];
		for(int i=0; i<100; i++) {
			tar[i] = new Random().nextInt(100);
		}
		QuickOrder o = new QuickOrder(tar);
//		o.insertOrder(0, tar.length-1);

		
		o.display();
		o.quickOrder(0, tar.length-1);
//		o.insertOrder(0, tar.length-1);
		o.display();
		
	}
	
}
