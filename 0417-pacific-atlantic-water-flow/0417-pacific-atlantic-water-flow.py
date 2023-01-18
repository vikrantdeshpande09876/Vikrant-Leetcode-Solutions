class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        m = len(heights)
        n = len(heights[0])
        
        def floodfill(i, j, prev_val, visited, ocean_reachable):
            # starting from edge, move-in iff nbr.seaLevel >= curr.seaLevel
            if i<0 or j<0 or i>=m or j>=n or heights[i][j] < prev_val or visited[i][j]:
                return

            ocean_reachable.append([i,j])
            visited[i][j] = True
            moves = [[-1,0], [1,0], [0,-1], [0,1]]
            flag = False
            for move in moves:
                floodfill(i+move[0], j+move[1], heights[i][j], visited, ocean_reachable)


        atlantic_reachable = []
        visited = [[False for _ in range(n)] for _ in range(m)]
        # print('Left edge top-bottom')
        for i in range(m):
            floodfill(i, 0, float('-inf'), visited, atlantic_reachable)
        # print('Top edge left-right')
        for j in range(n):
            floodfill(0, j, float('-inf'), visited, atlantic_reachable)

        
        pacific_reachable = []
        visited = [[False for _ in range(n)] for _ in range(m)]
        # print('Right edge top-bottom')
        for i in range(m):
            floodfill(i, n-1, float('-inf'), visited, pacific_reachable)
        # print('Bottom edge left-right')
        for j in range(n):
            floodfill(m-1, j, float('-inf'), visited, pacific_reachable)

        res = []
        for cell in atlantic_reachable:
            if cell in pacific_reachable:
                res.append(cell)

        return res

# [[1,2]]
# 
# 