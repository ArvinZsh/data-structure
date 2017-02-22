/**
 * 
 */
package com.zsh.link;

/**
 * @author Administrator
 * 双向链表
 */
public class DoublyLinkList {
	DoublyLink first;
	DoublyLink last;
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public boolean insertFirst(int data) {
		
		DoublyLink tar = new DoublyLink(data);
		
		if(isEmpty()) {
			first = tar;
			last = tar;
		} else {
			tar.next = first;
			first.previous = tar;
			first = tar;
		}
		
		return true;
	}
	
	public boolean insertLast(int data) {
		DoublyLink tar = new DoublyLink(data);
		
		if(isEmpty()) {
			first = tar;
			last = tar;
		} else {
			last.next = tar;
			tar.previous = last;
			last = tar;
		}
		
		return true;
	}
	
	public boolean insertAfter(int afterData, int tarData) {
		
		DoublyLink tar = new DoublyLink(tarData);
		if(isEmpty()) {
			return false;
		} else {
			DoublyLink current = first;
			while(current.data != afterData) {
				if(current.next == null) {
					return false;
				}
				current = current.next;
			}
			if(last == current) {
				current.next = tar;
				tar.previous = current;
				last = tar;
			} else {
				tar.next = current.next;
				current.next.previous = tar;
				
				tar.previous = current;
				current.next = tar;
			}
		}
		
		return true;
	}
	
	public void displayForward() {
		DoublyLink current = first;
		StringBuffer sb = new StringBuffer();
		while(current != null) {
			sb.append(current.data+",");
			current = current.next;
		}
		if(sb.toString().equals("")) {
			System.out.println("链表为空");
		} else {
			System.out.println("displayForward " + sb);
		}
	}
	
	public void displayBackward() {
		DoublyLink current = last;
		StringBuffer sb = new StringBuffer();
		while(current != null) {
			sb.append(current.data+",");
			current = current.previous;
		}
		if(sb.toString().equals("")) {
			System.out.println("链表为空");
		} else {
			System.out.println("displayBackward " + sb);
		}
	}
	
	public DoublyLink removeFirst() {
		if(isEmpty()) {
			return null;
		} else {
			DoublyLink delObj = first;
			if(first == last) { // 只有一个节点
				first = null;
				last = null;
			} else {
				first = first.next;
				first.previous = null;
			}
			return delObj;
		}
	}
	
	public DoublyLink removeLast() {
		if(isEmpty()) {
			return null;
		} else {
			DoublyLink delObj = first;
			if(first == last) { // 只有一个节点
				first = null;
				last = null;
			} else {
				last = last.previous;
				last.next = null;
			}
			return delObj;
		}
	}
	
	public DoublyLink removeObj(int data) {
		if(isEmpty()) {
			return null;
		} else {
			DoublyLink current = first;
			while(current.data != data) {
				if(current.next == null) {
					return null;
				}
				current = current.next;
			}
			if(first == last) { // 只有一个节点
				first = null;
				last = null;
			} else {
				if(last == current) {
					last = current.previous;
					last.next = null;
				} else if(first == current) {
					first = current.next;
					first.previous  = null;
				} else {
					current.next.previous = current.previous;
					current.previous.next = current.next;
				}
			}
			return current;
		}
	}
	
	public static void main(String[] args) {
		DoublyLinkList list = new DoublyLinkList();
		list.insertFirst(2);
		list.insertFirst(1);
		list.insertFirst(3);
		list.insertFirst(9);
		list.insertFirst(10);
		list.displayForward();
		list.displayBackward();
		
		System.out.println("=================");
		list.removeFirst();
		list.displayForward();
		list.displayBackward();
		
		System.out.println("=================");
		list.removeLast();
		list.displayForward();
		list.displayBackward();
		
		System.out.println("=================");
		list.removeObj(3);
		list.displayForward();
		list.displayBackward();
		
		System.out.println("=================");
		list.insertAfter(9, 2);
		list.displayForward();
		list.displayBackward();
	}
}
