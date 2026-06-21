class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int res=0;
        for(int i:costs){
            if(i<=coins){
                res++; coins -= i;
            }
            else break;
        }
        return res;
    }
}