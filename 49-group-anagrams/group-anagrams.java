class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mp = new HashMap<>();
        for(String s: strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);
            mp.computeIfAbsent(sorted, k -> new ArrayList<>()).add(s);
        }
        List<List<String>> res = new ArrayList<>(mp.values());
        return res;
    }
}