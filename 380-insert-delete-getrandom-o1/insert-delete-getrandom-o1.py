class RandomizedSet:

    def __init__(self):
        self.s = {}
        self.l = []
        self.size = 0


    def insert(self, val: int) -> bool:
        if val in self.s:
            return False
        self.s[val] = self.size
        self.l.append(val)
        self.size += 1
        return True

    def remove(self, val: int) -> bool:
        if val not in self.s:
            return False
        idx = self.s.pop(val)
        self.size -= 1
        if idx!= self.size:
            self.s[self.l[-1]] = idx
            self.l[idx],self.l[self.size] = self.l[self.size], self.l[idx]
        self.l.pop()
        return True

    def getRandom(self) -> int:
        return random.choice(self.l)
        


# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()