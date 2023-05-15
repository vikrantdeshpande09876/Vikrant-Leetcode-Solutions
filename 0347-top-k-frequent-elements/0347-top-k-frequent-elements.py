class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        d = dict()
        for n in nums:
            d[n] = d.get(n, 0)+1
        
        sorted_d = sorted(d.items(), key=lambda x:-x[1])
        return [key[0] for key in sorted_d[:k]]