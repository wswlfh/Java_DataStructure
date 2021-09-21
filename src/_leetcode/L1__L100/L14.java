package _leetcode.L1__L100;

public class L14 {
    private static String longestCommonPrefix(String[] strs) {

        StringBuilder res = new StringBuilder();
        int j = 0;
        int minLen = strs[0].length();
        for (String str : strs){
            if (str.length() <= minLen)
                minLen = str.length();
        }
        while (j < minLen){
            char c = strs[0].charAt(j);
            int t = 0;
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].charAt(j) == c){
                    t++;
                }else {
                    j = minLen;
                    break;
                }
                if (t == strs.length){
                    res.append(c);
                }
            }
            j++;
            if (res.toString().equals(""))
                break;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String strs[] = {"cir","car"};
        System.out.println(L14.longestCommonPrefix(strs));
    }

}
