# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minCameraCover(self, root: TreeNode | None) -> int:
        
        def dfs(node):
            res = [float('inf'),float('inf'), float('inf')]
            if not node:
                res[1] = 0
                return res
            if not node.left and not node.right:
                res[0] = 1
                res[2] = 0
                return res
            
            
            left = dfs(node.left)
            right = dfs(node.right)

            res[0] = 1 + min(left) + min(right)
            res[1] = min(left[0]+right[0],left[0]+right[1], left[1]+right[0])
            res[2] = left[1]+right[1]

            return res

        ans = dfs(root)
        return min(ans[0],ans[1])