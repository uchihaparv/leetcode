class Solution {
    public boolean judgeCircle(String moves) {
        int y=0;
        int x=0;

        for(char c : moves.toCharArray()){
            if(c == 'U')y++;
            if(c == 'D')y--;
            if(c == 'L')x++;
            if(c == 'R')x--;
        }
        if(x!=0 || y!=0)return false;
        return true;
    }
}