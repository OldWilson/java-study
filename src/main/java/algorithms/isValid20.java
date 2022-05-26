package algorithms;

import java.util.Stack;

public class isValid20 {
    public static boolean isValid(String s) {
        if (s == null || s.trim().isEmpty()) {
            return false;
        }
        while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            s = s.replace("()", "").replace("[]", "").replace("{}", "");
        }
        return s.isEmpty();
    }

    // 使用栈
    public static boolean isValid2(String s) {
        if (s == null || s.trim().isEmpty()) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || c != stack.pop()) return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{[]()}";
        System.out.println(isValid2(s));
    }
}
