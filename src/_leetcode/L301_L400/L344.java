package _leetcode.L301_L400;

public class L344 {
    private static void reverseString(char[] s) {
        if ( s == null)
            return;
        int l = 0 ;
        int r = s.length - 1;
        char temp;
        for ( l = 0; l <= r; l++) {
            if (l == r)
                break;
            temp = s[r];
            s[r] = s[l];
            s[l] = temp;
            r--;
        }
        for (int i = 0; i < s.length; i++) {
            System.out.printf(s[i] + ",");
        }
    }

    public static void main(String[] args) {
        char s[] = {'h','e','l','l','o'};
        L344.reverseString(s);
    }
}
