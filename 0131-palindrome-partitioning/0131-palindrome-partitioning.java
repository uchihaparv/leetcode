class Solution {
    public boolean isPalidrome(String s){
        int i = 0;
        int j = s.length()-1;

        while(i<=j){
            if(s.charAt(i)!=s.charAt(j))return false;
            j--;
            i++;
        }
        return true;
    }
    public void Backtracking(List<List<String>> ans, List<String> ds, String s, int n, int i){
        if(i == n){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int st=i; st<n; st++){
            if(isPalidrome(s.substring(i,st+1))){
                ds.add(s.substring(i,st+1));
                Backtracking(ans,ds,s,n,st+1);
                ds.remove(ds.size()-1);
                
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> ds = new ArrayList<>();

        int n = s.length();
        int i = 0;

        Backtracking(ans , ds , s, n, i);
        
        return ans;
        
    }
}