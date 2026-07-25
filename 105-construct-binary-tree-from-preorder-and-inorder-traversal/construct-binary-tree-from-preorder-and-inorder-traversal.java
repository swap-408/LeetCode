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
    int idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){inMap.put(inorder[i],i);}
        return build(preorder, inMap,0, preorder.length-1);
    }
    public TreeNode build(int[] preorder, Map<Integer, Integer> inMap, int pL, int pR){
        if(pL>pR) return null;
        TreeNode root = new TreeNode(preorder[idx++]);
        int mid = inMap.get(root.val);
        root.left = build(preorder,inMap,pL,mid-1);
        root.right = build(preorder,inMap,mid+1,pR);
        return root;
    }
}