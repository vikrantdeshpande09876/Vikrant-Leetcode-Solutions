class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        
        def dfs(board, word, visited, i, j, k):
            m, n = len(board), len(board[0])
            if i >= m or i < 0 or j >= n or j < 0 or visited[i][j] or word[k]!=board[i][j]:
                return False
            
            if k == len(word)-1:
                return True            

            visited[i][j] = True
            for move in [[0,1], [1,0], [-1,0], [0,-1]]:
                if dfs(board, word, visited, i+move[0], j+move[1], k+1):
                    return True
            visited[i][j] = False
            
            return False
            
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == word[0]:
                    visited = [[False for _ in board[0]] for _ in board]
                    if dfs(board, word, visited, i, j, 0):
                        return True
        return False