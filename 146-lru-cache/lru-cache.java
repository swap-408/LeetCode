class LRUCache {
    int capacity;
    int size;
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    public class Node{
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        map = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.keySet().contains(key)) return -1;
        Node node = map.get(key);
        moveFirst(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        
        if(map.keySet().contains(key)){
            Node node = map.get(key);
            node.value = value;
            moveFirst(node);
        }else{
            size++;
            Node node = new Node(key, value);
            map.put(key,node);
            addFirst(node);
            if(size>capacity){
                size--;
                removeEntry(tail.prev);
            }
        }
    }

    public void removeNode(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    public void removeEntry(Node node){
        removeNode(node);
        map.remove(node.key);
    }
    public void moveFirst(Node node){
        removeNode(node);
        addFirst(node);
    }
    public void addFirst(Node node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */