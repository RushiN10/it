class ListNode {
    int val;
    ListNode next;
    
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListBinarySearch {
    
    public static ListNode binarySearch(ListNode head, int target) {
        int length = getLength(head);
        ListNode start = head;
        ListNode end = null;
        
        while (start != null) {
            ListNode middle = start;
            for (int i = 0; i < length / 2; i++) {
                middle = middle.next;
            }
            
            if (middle.val == target) {
                return middle;
            } else if (middle.val < target) {
                start = middle.next;
            } else {
                end = middle;
            }
            
            length /= 2;
        }
        
        return null;
    }
    
    private static int getLength(ListNode head) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }
    
    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        int target = 3;
        ListNode result = binarySearch(head, target);
        if (result != null) {
            System.out.println("Found " + target + " in the linked list.");
        } else {
            System.out.println(target + " not found in the linked list.");
        }
    }
}
