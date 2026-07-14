class Solution {

    String[] str = {
        "", "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };

    public List<String> letterCombinations(String digits) {

        // Base case
        if (digits.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        char c = digits.charAt(0);
        String ros = digits.substring(1);

        List<String> rres = letterCombinations(ros);
        List<String> mres = new ArrayList<>();

        String dig = str[c - '0'];

        for (int i = 0; i < dig.length(); i++) {
            char curr = dig.charAt(i);

            for (String ele : rres) {
                mres.add(curr + ele);
            }
        }

        return mres;
    }
}