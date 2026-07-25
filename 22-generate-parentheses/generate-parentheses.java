class Solution {

    List<String> res = new ArrayList<>(); 
    public List<String> generateParenthesis(int n) {
        int countOpenBracket =n;
        int countClosedBracket =n;
        String currentString = "";
        solve(countOpenBracket, countClosedBracket, currentString);
        return res;
    }

    private void solve(int open, int close, String cs){
        if(open ==0 && close == 0){
            res.add(cs);
            return;
        }

        if(open == close){
            cs += '(';
            solve(open-1,close,cs);
        }
        else if(open == 0){
            cs += ')';
            solve(open,close -1,cs);
        }
        else if(close == 0){
            return;
        }
        else{
            String s1 = cs + '(';
            String s2 = cs + ')';
            solve(open -1, close, s1);
            solve(open, close-1, s2);
        }
    }

    
}