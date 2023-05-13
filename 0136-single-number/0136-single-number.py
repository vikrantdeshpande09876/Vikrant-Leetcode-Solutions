class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        # sort and then check wherever prev != curr
        # create a hmap {num : count}
        # 4 xor 1 = 100 ^ 001 = 101
        # 5 xor 2 = 101 ^ 010 = 111
        # 7 xor 1 = 111 ^ 001 = 110
        # 6 xor 2 = 110 ^ 010 = 100
        res = nums[0]
        n = len(nums)
        if n == 1:
            return res
        
        for i in range(1, n):
            res = res ^ nums[i]
        return res