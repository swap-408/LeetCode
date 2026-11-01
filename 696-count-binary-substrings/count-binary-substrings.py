class Solution:
    def countBinarySubstrings(self, s: str) -> int:
        group = [1]
        for i in range(1,len(s)):
            if s[i]==s[i-1]:
                group[-1] +=1
            else:
                group.append(1)
        res = 0
        for i in range(1,len(group)):
            res += min(group[i],group[i-1])
        return res