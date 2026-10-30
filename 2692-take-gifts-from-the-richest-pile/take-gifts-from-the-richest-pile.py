class Solution:
    def pickGifts(self, gifts: List[int], k: int) -> int:
        hp = [-i for i in gifts]
        heapq.heapify(hp)
        while k>0:
            c = heapq.heappop(hp)
            c = -c
            c = int(math.sqrt(c))
            heapq.heappush(hp,-c)
            k -= 1
        return -sum(hp)