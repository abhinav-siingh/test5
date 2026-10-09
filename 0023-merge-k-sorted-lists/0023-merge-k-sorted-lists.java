import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Min-Heap: nodes ko value ke hisab se chote se bada sort karega
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        // Step 1: Har list ka pehla (head) node heap mein add karo
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.add(head);
            }
        }

        // Ek dummy node banate hain nayi list shuru karne ke liye
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Step 2: Sabse chhota node nikaalo aur agla node daalo
        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();
            current.next = smallest;
            current = current.next;

            // Agar is node ke aage aur nodes hain, to agla node heap mein daalo
            if (smallest.next != null) {
                minHeap.add(smallest.next);
            }
        }

        return dummy.next;
    }
}