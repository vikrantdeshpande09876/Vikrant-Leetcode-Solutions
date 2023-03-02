class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        res = []
        
        def is_on_row_col(r1, c1, visited_pos):
            for r2, c2 in enumerate(visited_pos):
                if r1 == r2 or c1 == c2:
                    return True
            return False

        def is_on_diagonal(r1, c1, visited_pos):
            for r2, c2 in enumerate(visited_pos):
                if abs(r1-r2) == abs(c1-c2):
                    return True
            return False

        def print_board(board):
            print('')
            for i in range(len(board)):
                for j in range(len(board[0])):
                    print(board[i][j], end=' ')
                print('')
            
        
        def dfs(visited_pos, board, r):
            # print_board(board)
            if r==len(board):
                res.append([''.join(row) for row in board])
                return
            
            for j in range(len(board[0])):
                if is_on_row_col(r, j, visited_pos) or is_on_diagonal(r, j, visited_pos):
                    continue
                visited_pos.append(j)
                board[r][j] = 'Q'
                dfs(visited_pos, board, r+1)
                board[r][j] = '.'
                _ = visited_pos.pop()
                

        dfs(
            visited_pos=list(), 
            board=[['.' for _ in range(n)] for _ in range(n)],
            r=0
        )
        return res