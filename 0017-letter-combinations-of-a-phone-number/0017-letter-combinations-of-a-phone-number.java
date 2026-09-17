class Solution {
    String[] dig = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            List<String> ls = new ArrayList<>();
            ls.add("");
            return ls;
        }

        char c = digits.charAt(0);
        String ros = digits.substring(1);
        List<String> rres = letterCombinations(ros);
        List<String> ans = new ArrayList<>();
        String ele = dig[c-'0'];

        for(char ch : ele.toCharArray()){
            for(String s : rres){
                String curr = ch+s;
                ans.add(curr);
            }
        }

 

        return ans;
    }
}