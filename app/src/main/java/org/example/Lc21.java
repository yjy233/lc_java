package org.example;

public class Lc21 {
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode res = new ListNode(-1);
		ListNode tmp = res;

		while (list1 != null || list2 != null) {
			if (list1 == null) {
				tmp.next = list2;
				break;
			}

			if (list2 == null) {
				tmp.next = list1;
				break;
			}

			if (list1.val < list2.val) {
				tmp.next = list1;
				list1 = list1.next;
			} else {
				tmp.next = list2;
				list2 = list2.next;
			}

			tmp = tmp.next;
			tmp.next = null;


		}


		return res.next;
	}
}
