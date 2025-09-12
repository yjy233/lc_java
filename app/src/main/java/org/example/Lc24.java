package org.example;

import java.util.List;

public class Lc24 {
	public ListNode swapPairs(ListNode head) {
		ListNode res = new ListNode();
		res.next = head;
		ListNode resTail = res;


		while(head != null) {

			ListNode p0 = head;
			if (p0 == null) break;
			ListNode p1 = head.next;
			if (p1 == null) {
				resTail.next = p0;
				break;
			}
			ListNode p2 = head.next.next;

			resTail.next = null;

			p0.next = null;
			p1.next = p0;
			resTail.next = p1;
			resTail = p0;

			head = p2;
		}

		return res.next;
	}
}
