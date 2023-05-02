class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
            maintain 3 counters
            if you see new 0, then change nums[zero++] = 0
            if you see new 1, then change nums[zero+ones++] = 1
            if you see new 2, then change nums[zero+ones+two++] = 2
        """
        zeros, ones, twos = 0, 0, 0
        for i, n in enumerate(nums):
            if n == 0:
                nums[zeros] = 0
                zeros += 1
            elif n == 1:
                nums[zeros+ones] = 1
                ones += 1
            else:
                nums[zeros+ones+twos] = 2
                twos += 1
        k = 0
        while zeros > 0:
            nums[k] = 0
            k += 1
            zeros -= 1
            
        while ones > 0:
            nums[k] = 1
            k += 1
            ones -= 1
            
        while twos > 0:
            nums[k] = 2
            k += 1
            twos -= 1