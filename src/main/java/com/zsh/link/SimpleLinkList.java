/**
 * 
 */
package com.zsh.link;

/**
 * @author Administrator 简单链表
 */
public class SimpleLinkList {
	
	SimpleLink first;

	public SimpleLinkList() {
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	/**
	 * 在链头插入- O(1)
	 * */
	public boolean insertFirst(int data) {
		
		SimpleLink tar = new SimpleLink(data);
		tar.next = first;
		first = tar;
		
		return true;
	}
	
	/**
	 * 删除链头 - O(1)
	 * */
	public SimpleLink removeFirst() {
		if(first == null) {
			return null;
		}
		SimpleLink del = first;
		first = del.next;
		return del;
	}
	
	/**
	 * 找到某一个节点 - O(n)
	 * */
	public SimpleLink findLink(int data) {
		
		if(isEmpty()) {
			return null;
		}
		SimpleLink current = first;
		while(current.data != data) {
			if(current.next == null) {
				return null;
			}
			current = current.next;
		}
		return current;
	}
	
	public void display() {
		SimpleLink current = first;
		StringBuffer sb = new StringBuffer();
		while(current != null) {
			sb.append(current.data);
			current = current.next;
		}
		System.out.println(sb);
	}
	
	public SimpleLink removeLink(int data) {
		if(isEmpty()) {
			return null;
		}
		SimpleLink current = first;
		SimpleLink previous = first;
		while(current.data != data) {
			if(current.next == null) { // 最后一个节点
				return null;
			}
			previous = current;
			current = current.next;
		}
		
		if(first == current) { // 删除的是第一个节点
			first = current.next;
		} else {
			previous.next = current.next;
		}
		return current;
	}
	
	public static void main(String[] args) {
		SimpleLinkList list = new SimpleLinkList();
		
		list.insertFirst(1);
		list.insertFirst(5);
		list.insertFirst(3);
		list.display();
		
		list.removeFirst();
		list.display();
		
		System.out.println("查找0 -> " + list.findLink(0));
		
		// 51
		System.out.println("删除1 -> " + list.removeLink(1));
		// 5
		list.display();
	}
}
