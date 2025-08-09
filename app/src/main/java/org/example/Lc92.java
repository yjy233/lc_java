package org.example;

import java.util.List;

public class Lc92 {
	public ListNode reverseBetween(ListNode head, int left, int right) {
		if (right == left) {
			return head;
		}


		ListNode vitrualNode = new ListNode();

		vitrualNode.next = head;
		ListNode rightPtr = vitrualNode;
		ListNode leftPtr = vitrualNode;
		for (int i = 0;i<right;i++){
			rightPtr = rightPtr.next;
		}


		for (int i = 0;i<left;i++){
			leftPtr = leftPtr.next;
		}

		ListNode rest = null;
		if (rightPtr != null) rest = rightPtr.next;
		rightPtr.next = null;

		ListNode tmp = vitrualNode;
		while(tmp != null && tmp.next != leftPtr){
			tmp = tmp.next;
		}

		if (tmp != null){
			tmp.next = reverse(leftPtr);
			while(tmp.next != null){
				tmp = tmp.next;
			}
			tmp.next = rest;
		}

		return vitrualNode.next;
	}

	public ListNode reverse(ListNode head){

		ListNode tmp = head.next;
		head.next = null;
		while(tmp != null){
			ListNode nextN = tmp.next;
			tmp.next = head;

			head = tmp;
			tmp = nextN;
		}

		return head;
	}
}
