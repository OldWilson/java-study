package algorithms;

public class PalindromNum9 {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String oldStr = String.valueOf(x);
        StringBuilder buffer = new StringBuilder(oldStr);
        return buffer.reverse().toString().equals(oldStr);
    }

    public static boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        String oldStr = String.valueOf(x);
        int len = oldStr.length();
        for (int i = 0; i < (len / 2); ++i) {
            if (oldStr.charAt(i) != oldStr.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome3(int x) {
        if (x < 0) {
            return false;
        }
        String str = x + "";
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int x = 121;
        System.out.println(isPalindrome(x));
    }
}
