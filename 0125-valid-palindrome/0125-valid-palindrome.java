class Solution {
    public boolean check(String s, int st, int e){
        if(st>e)return true;

        if(!Character.isLetterOrDigit(s.charAt(st)))return check(s,st+1,e);
        if(!Character.isLetterOrDigit(s.charAt(e)))return check(s,st,e-1);

        return s.charAt(st) == s.charAt(e) && check(s,st+1,e-1);
    }
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int st=0;
        int e=s.length()-1;

        return check(s,st,e);



    }
}