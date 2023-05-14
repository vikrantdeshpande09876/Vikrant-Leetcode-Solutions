# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        stack = []
        curr = root

        while stack or curr:
            while curr:
                res.append(curr.val)
                stack.append(curr)
                curr = curr.right
            curr = stack.pop()
            curr = curr.left
            
        return res[::-1]