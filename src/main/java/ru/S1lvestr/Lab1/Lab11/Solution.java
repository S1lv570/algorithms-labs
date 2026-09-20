package ru.S1lvestr.Lab1.Lab11;
import java.util.Deque;
import java.util.ArrayDeque;

public class Solution {
    public boolean isBalanced(String string) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : string.toCharArray()) {
            switch (c) {
                case '(' -> stack.push(')');
                case '{' -> stack.push('}');
                case '[' -> stack.push(']');
                default -> {
                    if (stack.isEmpty() || c != stack.pop()) return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
