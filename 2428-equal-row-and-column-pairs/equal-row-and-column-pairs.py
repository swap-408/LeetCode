class Solution:
    def equalPairs(self, grid: list[list[int]]) -> int:
        mp = {}
        count = 0
        for r in range(0, len(grid)):
            temp = tuple(grid[r])
            if temp in mp:
                mp[temp].append(r)
            else:
                mp[temp] = [r]
        for i in range(0, len(grid)):
            for j in range(i, len(grid)):
                grid[i][j], grid[j][i] = grid[j][i], grid[i][j]

        for c in range(0, len(grid)):
            temp = tuple(grid[c])
            if temp in mp:
                count += len(mp[temp])
        return count
