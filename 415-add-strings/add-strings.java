class Solution {
    public String addStrings(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        if(n1>n2) return addStrings(num2,num1);
        StringBuilder resB = new StringBuilder();
        int carry = 0;
        for(int i=0;i<n1;i++){
            int a = num1.charAt(n1-i-1)-'0', b = num2.charAt(n2-i-1)-'0';
            int c = a + b + carry;
            //System.out.println(a + " " + b + " " + c + " " + carry);
            //System.out.println((char)('0'+c));
            carry = c/10; c = c%10;
            resB.append((char)('0'+c));
        }
        for(int i=n1;i<n2;i++){
            int b = num2.charAt(n2-i-1)-'0';
            int c = b + carry;
            //System.out.println(b + " " + c + " " + carry);
            carry = c/10; c = c%10;
            resB.append((char)('0'+c));
        }
        if(carry==1){
            resB.append('1');
        }
        resB.reverse();
        return resB.toString();
    }
}