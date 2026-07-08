class Solution {
    public void reverse(char[] s, int i){
        if(i == s.length/2)return;

        char c=s[i];
        s[i]=s[s.length-1-i];
        s[s.length-1-i]=c;
        reverse(s,i+1);
    }
    public void reverseString(char[] s) {
        reverse(s,0);
    }
}