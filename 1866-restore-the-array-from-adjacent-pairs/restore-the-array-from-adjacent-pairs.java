class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer,List<Integer>> mp = new HashMap<>();
        HashSet<Integer> s = new HashSet<>();
        for(int[] i: adjacentPairs){
            if(s.contains(i[0])) s.remove(i[0]);
            else s.add(i[0]);

            if(s.contains(i[1])) s.remove(i[1]);
            else s.add(i[1]);
        }
        for(int[] i: adjacentPairs){
            if(!mp.containsKey(i[0])) mp.put(i[0], new ArrayList());
            mp.get(i[0]).add(i[1]);
            if(!mp.containsKey(i[1])) mp.put(i[1], new ArrayList());
            mp.get(i[1]).add(i[0]);
            
        }
        int start = s.iterator().next();
        int[] res = new int[adjacentPairs.length+1];
        res[0]=start;
        for(int i=0;i<res.length-1;i++){
            List<Integer> l = mp.get(res[i]);
            int a, b=0;
            System.out.println(res[i]);
            a = l.get(0);
            if(l.size()==2) b = l.get(1);
            if(i!=0) res[i+1] = a == res[i-1] ? b : a;
            else res[i+1] = a;
        }
        return res;

    }
}