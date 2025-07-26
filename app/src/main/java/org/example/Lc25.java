package org.example;

import java.util.List;

public class Lc25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) return head;
        ListNode res = new ListNode();
        ListNode now = res;

        int cnt = 0;
        ListNode termHead = head;
        ListNode termTail = head;
        while(head != null){
            cnt++;
            if (cnt == k) {
                termTail = head;
                head = head.next;
                termTail.next = null;

                ListNode tmp = termHead.next;
                ListNode nextTmp = tmp;
                termHead.next = null;

                while(tmp != termTail){
                    nextTmp = tmp.next;
                    tmp.next = termHead;

                    termHead = tmp;
                    tmp = nextTmp;
                }
                termTail.next = termHead;
                System.out.println();
                now = res;
                while(now.next != null) {
                    now = now.next;
                }
                now.next = termTail;

                termHead = head;
                cnt = 0;
                continue;
            }

            head = head.next;
        }
        now = res;
        while(now.next != null) {
            now = now.next;
        }
        now.next = termHead;

        return res.next;
    }
}
