class Solution:
    def minRefuelStops(self, target: int, startFuel: int, stations: list[list[int]]) -> int:
        c = startFuel
        if target <= c: return 0
        l = 0
        stations.append([target,0])
        hp = []
        n = 0
        for s in stations:
            while s[0] > l+c and len(hp)>0:
                c -= heapq.heappop(hp)
                n += 1
            if s[0]>l+c: return -1
            heapq.heappush(hp,-s[1])
            c -= s[0]-l
            l = s[0]
            
        
        return n
        