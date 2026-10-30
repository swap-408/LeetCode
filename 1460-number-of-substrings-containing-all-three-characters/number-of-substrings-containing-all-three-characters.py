class Solution:
    def numberOfSubstrings(self, s: str) -> int:
        last = {'a':0,'b':0,'c':0}
        mp = {'a':0,'b':0,'c':0}
        res =0
        j = 0
        for i in range(0,len(s)):
            mp[s[i]] += 1
            while (mp['a']-last['a']>0) and (mp['b']-last['b']>0) and (mp['c']-last['c']>0):
                last[s[j]] += 1
                j += 1
            if mp['a']>0 and mp['b']>0 and mp['c']>0 :res += j
        return res 




