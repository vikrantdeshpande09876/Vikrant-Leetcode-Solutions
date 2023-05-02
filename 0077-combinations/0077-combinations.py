class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        '''
            nCk = n! / k! . (n-k)!
        '''
        res = []
        def dfs(n, k, i, candidate):
            if len(candidate) == k:
                if candidate not in res:
                    res.append(list(candidate))
                return
            
            for j in range(i+1, n+1):
                candidate.append(j)
                dfs(n, k, j, candidate)
                _ = candidate.pop()

            
        dfs(n, k, 0, [])
        return res