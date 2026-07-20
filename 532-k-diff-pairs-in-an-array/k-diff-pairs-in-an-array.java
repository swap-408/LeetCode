class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        int count =0;
        for(int i:nums){
            mp.put(i,mp.getOrDefault(i,0)+1);
        }
        for(int i: mp.keySet()){
            if(k==0){
                if(mp.get(i)>1)
                count += 1;
            }
            else{
                int plusk = mp.getOrDefault(i+k,0)==0 ? 0:1;
                int minusk = mp.getOrDefault(i-k,0)==0 ? 0:1;
                count = count +  plusk + minusk;
            }
        }
        if(k==0) return count;
        
        return count/2;
    }
}