class Solution:
    def numOfSubsequences(self, s: str) -> int:
        lbefore = [0]
        for c in s:
            if c=='L':
                lbefore.append(lbefore[-1]+1)
            else:
                lbefore.append(lbefore[-1])
        lbefore.append(lbefore[-1])
        tafter = [0]
        for c in s[::-1]:
            if c=='T':tafter.append(tafter[-1]+1)
            else:tafter.append(tafter[-1])
        tafter.append(tafter[-1])
        tafter.reverse()

        total = 0
        maxc = 0
        maxl = 0
        maxt = 0
        for i in range(len(s)):
            if s[i]!='C': 
                maxc = max(maxc,lbefore[i+1]*tafter[i+1])
                continue
            total += lbefore[i+1]*tafter[i+1]
            maxl += tafter[i+1]
            maxt += lbefore[i+1]
        
        return total + max(maxl,maxc,maxt)

