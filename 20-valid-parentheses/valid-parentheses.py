class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        mp = {')':'(','}':'{',']':'['}
        for c in s:
            if len(stack)>0 and c in mp and mp[c] == stack[-1]:
                stack.pop()
            else: stack.append(c)
        
        if len(stack)==0: return True
        return False