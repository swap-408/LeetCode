class Solution:
    def countBinarySubstrings(self, s: str) -> int:
        count = 0
        for i in range(0,len(s)-1):
            if (int(s[i]) + int(s[i+1]))==1:
                #print(i)
                count += 1
                l,r = i-1,i+2
                while l>=0 and r<len(s) and s[i]==s[l] and s[i+1]==s[r]:
                    count += 1
                    l -= 1
                    r += 1
        return count