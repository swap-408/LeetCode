class Solution:
    def scoreOfParentheses(self, s: str) -> int:
        depth = 0
        res = 0
        for i, char in enumerate(s):
            if char == "(":
                depth += 1
            else:
                depth -= 1
                if s[i-1]=="(":
                    res += 2**depth
        return res