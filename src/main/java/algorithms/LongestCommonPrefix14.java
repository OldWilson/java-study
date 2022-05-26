package algorithms;

import java.util.Arrays;

public class LongestCommonPrefix14 {

    public static String getRes(String[] strs) {
        if (strs == null || strs.length <1) {
            return "";
        }
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length - 1];
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s2.substring(0,i);
            }
        }
        return s1;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(getRes(strs));
    }

}
