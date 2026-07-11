class Solution {
    List<Integer> l=new ArrayList<>();
    public int findMinDifference(List<String> timePoints) {
        for(String s: timePoints){
            covert(s);
        }
        Collections.sort(l);
        int res = 24*60+10;
        for(int i=0;i<l.size()-1;i++){
            res = Math.min(res, l.get(i+1)-l.get(i));
        }
        return res;
    }
    public void covert(String tp){
        int h = (tp.charAt(0)-'0')*10 + (tp.charAt(1)-'0');
        int m = (tp.charAt(3)-'0')*10 + (tp.charAt(4)-'0');
        int t = (h-1)*60 + m;
        l.add(t);
        l.add(t+24*60);
    }

}