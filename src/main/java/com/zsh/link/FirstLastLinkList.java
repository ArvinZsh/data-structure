/**
 * 
 */
package com.zsh.link;

/**
 * @author Administrator
 * 双端链
 */
public class FirstLastLinkList {
	private SimpleLink first;
	private SimpleLink last;
	
	public FirstLastLinkList() {
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public boolean insertFirst(int data) {
		SimpleLink tar = new SimpleLink(data);
		
		if(first != null) {
			tar.next = first;
		}
		if(last == null) {
			last = tar;
		}
		first = tar;
		
		return true;
	}
	
	public SimpleLink removeFirst() {
		
		if(isEmpty()) {
			return null;
		}
		SimpleLink del = first;
		first = first.next;
		if(last == del) { // 只有一个节点
			last = null;
		}
		
		return del;
	}
	
	/**
	 * 末尾插入
	 * */
	public boolean insertLast(int data) {
		SimpleLink tar = new SimpleLink(data);

		if(isEmpty()) {
			first = tar;
		} else {
			last.next = tar;
		}
		last = tar;
		
		return true;
	}
	
	/**
	 * 找到某个元素
	 * */
	public SimpleLink find(int data) {
		if(isEmpty()) {
			return null;
		}
		SimpleLink current = first;
		while(current.data != data) {
			if(current.next == null) { // 最后一个节点
				return null;
			}
			current = current.next;
		}
		return current;
	}
	
	/**
	 * 删除某个元素
	 * */
	public SimpleLink removeObj(int data) {
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
		if(first == current) { // 要删除第一个节点
			first = current.next;
		} 
		
		if(last == current) { // 要删除最后一个节点
			last = previous;
		}
		previous.next = current.next;
		
		return current;
	}
	
	public void display() {
		SimpleLink current = first;
		StringBuffer sb = new StringBuffer();
		while(current != null) {
			sb.append(current.data);
			current = current.next;
		}
		if(sb.toString().equals("")) {
			System.out.println("链表为空");
		} else {
			System.out.println(sb);
		}
	}
	
	public static void main(String[] args) {
		FirstLastLinkList list = new FirstLastLinkList();
		list.insertFirst(1);
		list.insertFirst(2);
		// 2,1
		list.display();
		
		list.insertLast(4);
		list.insertLast(3);
		list.display();
		// 2,1,4,3
		
		list.removeFirst();
		list.display();
		// 1,4,3
		
		int data = 3;
		System.out.println("-----find[" + data + "] " + list.find(data) + "-----");
		
		System.out.println("-----removeObj-----");
		list.removeObj(1);
		list.display();
		list.removeObj(4);
		list.display();
		list.removeObj(3);
		list.display();
		// 1,4,3
	}
}
