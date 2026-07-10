class Solution {
    public String decodeString(String s) {
        
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();
        int num = 0;
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            if(Character.isDigit(c)){
                num = num*10 + (c - '0');
            }else if(c == '['){
                countStack.push(num);
                stringStack.push(sb);
                num = 0;
                sb = new StringBuilder();
            }else if(c == ']'){
                int k = countStack.pop();
                StringBuilder prev = stringStack.pop();               
                StringBuilder temp = new StringBuilder(prev);
                for(int i=0;i<k;i++){
                    temp.append(sb);
                }
                sb = temp;
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}