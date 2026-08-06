import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack();
        int count = 0;
        
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && count < k) {
                stack.pop();
                count++;
            }
            stack.push(c);
        }
        
        while (count < k) {
            stack.pop();
            count++;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}