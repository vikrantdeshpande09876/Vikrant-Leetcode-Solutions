class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        def dfs(i, candidate):
            if len(candidate) > len(nums):
                return
            
            if candidate not in res:
                res.append(list(candidate))
                
            for j in range(i+1, len(nums)):
                candidate.append(nums[j])
                dfs(j, candidate)
                _ = candidate.pop()
        
        dfs(-1, [])
        return res