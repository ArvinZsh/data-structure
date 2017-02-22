/**
 * 
 */
package com.zsh.link;

/**
 * @author Administrator
 * 迭代器
 */
public class SimpleIterator {
	SortLinkList mylist;
	SimpleLink current;
	SimpleLink previous;
	
	public SimpleIterator(SortLinkList list) {
		mylist = list;
	}
	
	public boolean hasNext() {
		if(current == null) {
			current = mylist.first;
			return current != null;
		} else {
			return current.next != null;
		}
	}
	
	public SimpleLink next() {
		if(current == mylist.first) {
			return current;
		} else {
			previous = current;
			current = current.next;
			return current;
		}
	}
	
	public boolean reset() {
		current = mylist.first;
		return true;
	}
}
