class Solution:
    
    
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        def dfs(board, i, j, m, n, symbol_to_convert):
            if i<0 or j<0 or i>=m or j>=n or board[i][j] != 'O':
                return

            board[i][j] = symbol_to_convert
            for move in [[0,1],[1,0],[-1,0],[0,-1]]:
                dfs(board, i+move[0], j+move[1], m, n, symbol_to_convert)


        # if "O" is on the border initiate dfs() and change cell "O" -> "V" (visited)
        # initiate dfs() for remaining "O" symbols
        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                if board[i][j] == 'O' and (i==0 or i==m-1 or j==0 or j==n-1):
                    dfs(board, i, j, m, n, 'V')
        
        for i in range(m):
            for j in range(n):
                if board[i][j] == 'O':
                    dfs(board, i, j, m, n, 'X')
        
        for i in range(m):
            for j in range(n):
                if board[i][j] == 'V':
                    board[i][j] = 'O'
        