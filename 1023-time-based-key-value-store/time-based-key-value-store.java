class TimeMap {
    class Entry{
        String value; int timestamp; Entry next;
        Entry(String value, int timestamp){
            this.value = value;
            this.timestamp = timestamp;
        }
    }
    HashMap<String, Entry> map;
    public TimeMap() {
       map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Entry newEntry = new Entry(value, timestamp);
        if(map.keySet().contains(key)){
            newEntry.next = map.get(key);
        }
        map.put(key,newEntry);
    }
    
    public String get(String key, int timestamp) {
        Entry entry = map.get(key);

        while(entry != null && entry.timestamp>timestamp){
            entry = entry.next;
        }
        return entry == null ? "": entry.value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */