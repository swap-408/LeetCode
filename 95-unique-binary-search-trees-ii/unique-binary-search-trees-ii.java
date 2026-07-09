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
    public List<TreeNode> generateTrees(int n) {
        return solve(1,n);
    }
    public List<TreeNode> solve(int l, int r){
        List<TreeNode> res = new ArrayList<>();
        if(l==r) {
            res.add(new TreeNode(l));
            return res;
        }
        if(l>r) return res;
        for(int i=l;i<=r;i++){
            List<TreeNode> left = solve(l,i-1);
            List<TreeNode> right = solve(i+1,r);
            if(left.size()==0 && right.size()==0){
                res.add(new TreeNode(i));
                continue;
            }
            if(left.size()==0){
                for(TreeNode rnode: right){
                    TreeNode curr = new TreeNode(i);
                    curr.right = rnode;
                    res.add(curr); 
                }
                continue;
            }
            if(right.size()==0){
                for(TreeNode lnode: left){
                    TreeNode curr = new TreeNode(i);
                    curr.left = lnode;
                    res.add(curr); 
                }
                continue;
            }
            for(TreeNode lnode: left){
                for(TreeNode rnode: right){
                    TreeNode curr = new TreeNode(i);
                    curr.left = lnode;
                    curr.right = rnode;
                    res.add(curr); 
                }
            }
        }
        return res;
    }

}