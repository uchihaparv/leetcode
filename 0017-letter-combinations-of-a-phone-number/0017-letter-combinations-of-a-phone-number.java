class Solution {
    String[] str = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {

        if(digits.length() == 0){
            List<String> res = new ArrayList<>();
            res.add("");
            return res;
        }
        
        char c = digits.charAt(0);
        String ros = digits.substring(1);
        List<String> rres = letterCombinations(ros);
        List<String> mres = new ArrayList<>();

        String ele = str[c-'0'];

        for(int i = 0; i<ele.length(); i++){
            char cur = ele.charAt(i);

            for(String s : rres){
                mres.add(cur+s);
            }
        }

        return mres;
    }
}