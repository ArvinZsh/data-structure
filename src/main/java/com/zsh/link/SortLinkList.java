/**
 * 
 */
package com.zsh.link;

/**
 * @author Administrator 有序链表
 */
public class SortLinkList {
	SimpleLink first;

	public boolean isEmpty() {
		if (first == null) {
			return true;
		}
		return false;
	}

	public boolean insert(int data) {
		SimpleLink tar = new SimpleLink(data);

		if (isEmpty()) {
			first = tar;
		} else {
			SimpleLink current = first;
			SimpleLink previous = first;
			while (current.data < tar.data && current.next != null) {
				previous = current;
				current = current.next;
			}
			
			if(current == previous) { //只有一个节点
				if(first.data >= data) { 
					// first节点数据比tar要大,tar排在前面
					tar.next = current;
					current = tar;
				} else { // tar排在后面
					current.next = tar;
				}
			} else{
				if(current.next == null) { // 最后一个节点
					if(current.data >= data) {
						// 最后一个节点的数据比tar大,tar排在前面
						tar.next = current;
						previous.next = tar;
					} else { // tar排在后面
						current.next = tar;
					}
				} else {
					tar.next = current;
					previous.next = tar;
				}
			}
		}

		return true;
	}

	public SimpleLink removeFirst() {

		if (isEmpty()) {
			return null;
		}
		
		SimpleLink delObj = first;
		first = first.next;

		return delObj;
	}
	
	public void display() {
		SimpleLink current = first;
		StringBuffer sb = new StringBuffer();
		while(current != null) {
			sb.append(current.data+",");
			current = current.next;
		}
		if(sb.toString().equals("")) {
			System.out.println("链表为空");
		} else {
			System.out.println(sb);
		}
	}
	
	public static void main(String[] args) {
		SortLinkList list = new SortLinkList();
		list.insert(8);
		list.insert(7);
		list.insert(5);
		list.insert(6);
		list.insert(9);
		list.insert(9);
		list.insert(1);
		list.display();
		// 1,5,6,7,8,9,9,
		
		// 可模拟优先级队列
		while(!list.isEmpty()) {
			System.out.println(list.removeFirst());
		}
	}
}
