class Solution:
    def networkDelayTime(self, times: list[list[int]], n: int, k: int) -> int:
        dist = [float(inf)]*(n+1)
        dist[k] = 0
        hp = [(0,k)]

        graph = [[] for _ in range(n+1)]
        for u, v, w in times:
            graph[u].append((v,w))
        while hp:
            d, u = heapq.heappop(hp)
            if d>dist[u]:
                continue
            for v,w in graph[u]:
                if d+w < dist[v]:
                    dist[v] = d+w
                    heapq.heappush(hp,(dist[v],v))
        return -1 if max(dist[1:])==float('inf') else max(dist[1:])