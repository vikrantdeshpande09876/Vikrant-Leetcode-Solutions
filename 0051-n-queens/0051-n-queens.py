class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        res = []
        
        def is_on_row_col(pos1, visited_pos):
            for pos2 in visited_pos:
                if (pos1[0] == pos2[0]) or (pos1[1] == pos2[1]):
                    return True
            return False

        def is_on_diagonal(pos1, visited_pos):
            for pos2 in visited_pos:
                if abs(pos2[0]-pos1[0]) == abs(pos2[1]-pos1[1]):
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
                if is_on_row_col([r, j], visited_pos) or is_on_diagonal([r, j], visited_pos):
                    continue
                visited_pos.add((r,j))
                board[r][j] = 'Q'
                dfs(visited_pos, board, r+1)
                board[r][j] = '.'
                visited_pos.remove((r,j))
                

        dfs(
            visited_pos=set(), 
            board=[['.' for _ in range(n)] for _ in range(n)],
            r=0
        )
        return res