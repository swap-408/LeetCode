class Solution:
    def robotWithString(self, s: str) -> str:

        suffix = ['']*len(s)
        suffix[-1] = s[-1]
        for i in range(len(s)-2,-1,-1):
            suffix[i] = min(suffix[i+1],s[i])
        
        stack = []
        res = []

        for i in range(len(s)):
            while len(stack)>0 and stack[-1]<=suffix[i]:
                res.append(stack.pop())
            stack.append(s[i]) 
        while len(stack)>0:
                res.append(stack.pop())
        return "".join(res)
