package org.example;

import java.util.List;

public class Lc25 {

    public ListNode getLast(ListNode head) {
        ListNode tmp = head;

        while(tmp.next != null){
            tmp = tmp.next;
        }
        return tmp;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode res = new ListNode();
        ListNode termHead = head;
        head = head.next;
        int cnt = 1;

        while(head != null) {
            cnt++;
            if (cnt%k==0){
                ListNode termTail = head;
                head = head.next;
                termTail.next = null;

                ListNode p0 = termHead;
                ListNode p1 = termHead.next;
                p0.next = null;

                while (p1!=termTail) {
                    ListNode p2 = p1.next;
                    p1.next = p0;
                    p0 = p1;
                    p1 = p2;
                }
                p1.next = p0;

                getLast(res).next = p1;

                termHead = head;
                if (head == null) {
                    break;
                }
                head = head.next;
                cnt = 1;
                continue;
            }
            head = head.next;
        }

        getLast(res).next = termHead;
        return res.next;
    }
}
