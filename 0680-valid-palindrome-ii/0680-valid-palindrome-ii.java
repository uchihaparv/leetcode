class Solution {
    int cnt = 0;

    public boolean check(String s, int st, int end){
        if(st>end)return true;

        if(cnt == 1 && s.charAt(st)!=s.charAt(end)){
            return false;
        }
        else if(cnt == 0 && s.charAt(st)!=s.charAt(end)){
            cnt++;
            return check(s, st + 1, end) || check(s, st, end - 1);
        }

        return check(s,st+1, end-1);
    }
    public boolean validPalindrome(String s) {
        int st = 0;
        int end = s.length()-1;

        return check(s,st,end);
    }
}