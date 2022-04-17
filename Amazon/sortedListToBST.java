/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        
       if (head == null) return null;
        
                
       ListNode mid = findMid (head);
       // head, mid
        
       if (head == mid ) return new TreeNode(head.val);
       
       TreeNode node = new TreeNode (mid.val);
       
        node.left = sortedListToBST (head);
        node.right = sortedListToBST (mid.next);
        
        return node;
    }
    
    public ListNode findMid (ListNode head) {
        ListNode slow = head;
        ListNode fast = head; 
        ListNode slowPrev = head;
        while (fast != null && fast.next != null) {
            slowPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if (slowPrev != null)
            slowPrev.next = null;
        
        return slow;
        
    }
}
