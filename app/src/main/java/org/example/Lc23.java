package org.example;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Lc23 {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>((v1, v2) -> {
            return v1.val - v2.val;
        });
        for (ListNode node : lists) {
            if (node == null) {
                continue;
            }

            pq.add(node);
        }

        ListNode res = new ListNode(0);
        ListNode tmp = res;
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            tmp.next = minNode;
            minNode = minNode.next;
            tmp = tmp.next;
            tmp.next = null;

            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }

        return res.next;
    }
}