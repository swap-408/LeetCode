class Solution:
    def asteroidCollision(self, asteroids: list[int]) -> list[int]:

        stack = []
        for curr in asteroids:
            while stack and stack[-1] > 0 and curr < 0:
                if stack[-1] < -curr:
                    stack.pop()
                    continue
                if stack[-1] == -curr:
                    stack.pop()
                break
            else:
                stack.append(curr)

        return stack
