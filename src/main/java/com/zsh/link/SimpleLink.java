/**
 * 
 */
package com.zsh.link;

/**
 * @author Administrator 简单链表节点
 */
public class SimpleLink {
	int data;
	SimpleLink next;

	public SimpleLink(int data) {
		this.data = data;
		this.next = null;
	}

	@Override
	public String toString() {
		return "SimpleLink [data=" + data + ", next=" + next + "]";
	}

}
