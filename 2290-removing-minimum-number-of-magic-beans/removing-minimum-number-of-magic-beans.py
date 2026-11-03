class Solution:
    def minimumRemoval(self, beans: list[int]) -> int:
        beans.sort()
        n = len(beans)
        total = sum(beans)
        res = total
        for i in range(n):
            removed = total - (n-i)*beans[i]
            res = min(res,removed)
        return res