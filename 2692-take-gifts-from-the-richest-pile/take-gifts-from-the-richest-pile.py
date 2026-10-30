class Solution:
    def pickGifts(self, gifts: List[int], k: int) -> int:
        hp = [-i for i in gifts]
        total = sum(gifts)
        heapq.heapify(hp)
        while k>0:
            c = heapq.heappop(hp)
            c = -c
            total -= c
            c = int(math.sqrt(c))
            total += c
            heapq.heappush(hp,-c)
            k -= 1
        return total