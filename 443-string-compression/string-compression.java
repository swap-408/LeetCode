class Solution {
    public int compress(char[] chars) {
        StringBuilder s = new StringBuilder();
        int start = 0, end =0;
        while(start<chars.length){
            char c = chars[start];
            end = start + 1; 
            while(end<chars.length && chars[end] == chars[start]) end++;
            int count = end - start;
            if(count==1) s.append(c);
            else{s.append(c); s.append(count);}
            start = end;
        }
        String res = s.toString();
        int i=0;
        for(char c: res.toCharArray()){
            chars[i] = c;
            i++;
        } 
        return i;
    }
}