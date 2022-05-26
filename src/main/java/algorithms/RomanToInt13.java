package algorithms;

import java.util.Map;

public class RomanToInt13 {
    public static int romantoint(String  s) {
        Map<String, Integer> map = Map.of(
                "I", 1,
                "V", 5,
                "X", 10,
                "L", 50,
                "C", 100,
                "D", 500,
                "M", 1000
        );
        int result = 0;
        for (int i = 0;i < s.length(); ++i) {
            if (i < s.length() - 1
                    && map.get(String.valueOf(s.charAt(i))) < map.get(String.valueOf(s.charAt(i + 1)))) {
                result-=map.get(String.valueOf(s.charAt(i)));
            } else {
                result+=map.get(String.valueOf(s.charAt(i)));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romantoint(s));
    }

}
