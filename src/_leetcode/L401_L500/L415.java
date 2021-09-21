package _leetcode.L401_L500;

public class L415 {
    private static String addStrings(String num1, String num2) {
        if (num1.equals("0") && num2.equals("0"))
            return "0";
        int carry = 0, t1 = 0, t2 = 0, t = 0;
        int r1 = num1.length() - 1;
        int r2 = num2.length() - 1;

        StringBuilder res = new StringBuilder();

        while (r1 >= 0 || r2 >= 0) {
            if (r1 < 0)
                t1 = 0;
            else
                t1 = num1.charAt(r1) - '0';
            if (r2 < 0)
                t2 = 0;
            else
                t2 = num2.charAt(r2) - '0';
            t = (carry + t1 + t2) % 10;
            carry = (carry + t1 + t2) / 10;
            res.append(t);
            r1--;
            r2--;
        }
        if (carry == 1)
            res.append(carry);
        res = res.reverse();
        if (res.charAt(0) == '0')
            res.deleteCharAt(0);
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("11", "123"));

    }
}
