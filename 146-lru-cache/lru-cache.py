class Node:
        def __init__(self, key = None, prev=None, next=None, val=None):
            self.key = key
            self.prev = prev
            self.next = next
            self.val = val
class LRUCache:

    
    def __init__(self, capacity: int):
        self.cap = capacity
        self.mp = {}
        self.head = Node()
        self.tail = Node()
        self.head.next = self.tail
        self.tail.prev = self.head

    def get(self, key: int) -> int:
        if key not in self.mp: return -1
        self.addFirst(self.mp[key])
        return self.mp[key].val 

    def put(self, key: int, value: int) -> None:
        mp = self.mp
        if key not in mp: mp[key] = Node(key = key)
        self.mp[key].val = value
        self.addFirst(mp[key])
        if self.cap<len(mp):
            self.removeLast()
    
    def addFirst(self,n: Node):
        self.remove(n)
        self.head.next.prev = n
        n.next = self.head.next
        n.prev = self.head
        self.head.next = n
    def remove(self, n: Node):
        if n.prev is None:return
        prev = n.prev
        next = n.next
        n.next=None
        n.prev = None
        prev.next = next
        next.prev = prev
        return n
    def removeLast(self):
        n = self.remove(self.tail.prev)
        self.mp.pop(n.key)


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)