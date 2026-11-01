class Solution:
    def reorganizeString(self, s: str) -> str:
        f = [0]*26
        for c in s:
            f[ord(c)-ord('a')] += 1
        hp=[]
        for i in range(26):
            if f[i]!=0:
                heapq.heappush(hp,[-f[i],chr(ord('a')+i)])
        res = ['']*len(s)
        i=0
        while len(hp)>0:
            if len(hp)==1: 
                if -hp[0][0]>1: return ""
                else:
                    res[i] = hp[0][1]
                    return "".join(res)
                
            first = heapq.heappop(hp)
            second = heapq.heappop(hp)
            while -first[0]>0 and -second[0]>0:
                if len(hp)>0 and -hp[0][0]>-first[0]: break
                res[i] = first[1]
                res[i+1] = second[1]
                first[0]+=1
                second[0]+=1
                i += 2
                
            if -first[0]>0: heapq.heappush(hp,first)
            if -second[0]>0: heapq.heappush(hp,second)
        return "".join(res)

