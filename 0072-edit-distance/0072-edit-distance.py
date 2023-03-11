class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        # dp[l1][l2] where each cell indicates minDistance(w1[:i], w2[:j])
        # at each stage can add/remove/change w1[i] to match against w2[j]
        m, n = len(word1), len(word2)
        if n == 0:
            return m
        if m == 0:
            return n
        
        dp = [[0 for _ in range(n+1)] for _ in range(m+1)]
        for i in range(1, n+1):
            dp[0][i] = i
        
        for i in range(1, m+1):
            dp[i][0] = i
        
        print(m, n)
        for i in range(1, m+1):
            for j in range(1, n+1):
                if word1[i-1] == word2[j-1]:
                    dp[i][j] = dp[i-1][j-1]
                else:
                    deletions = 1 + dp[i-1][j] # remove w1[:i] and try matching with word2
                    additions = 1 + dp[i][j-1] # add w2[j] to w1[:i] and try matching with word2
                    changes = 1 + dp[i-1][j-1] # replace w1[i] with w2[j] and try matching with word2
                    dp[i][j] = min(deletions, additions, changes)
            
        return dp[m][n]