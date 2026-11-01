class Solution:
    def asteroidCollision(self, asteroids: list[int]) -> list[int]:
        stack = []
        for i in asteroids:
            curr = i
            while len(stack)>0 and stack[-1] > 0 and curr < 0:
                top = stack.pop()
                if abs(curr)==abs(top):
                    curr = 0
                elif abs(curr)<abs(top):
                    curr = top
            if curr!=0: stack.append(curr)
        return stack
                     
