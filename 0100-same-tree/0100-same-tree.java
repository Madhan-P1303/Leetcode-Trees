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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        
        
        queue.add(p);
        queue.add(q);

        while(!queue.isEmpty()){

            TreeNode p1 = queue.poll();
            TreeNode q1 = queue.poll();
          

            if(p1==null && q1==null){
                continue;
            }
          if(p1==null || q1==null){
            return false;
          }
          if(p1.val!=q1.val){
            return false;
          }

          queue.add(p1.left);
          queue.add(q1.left);
          queue.add(p1.right);
          queue.add(q1.right);

        }
        return true;
    }
}