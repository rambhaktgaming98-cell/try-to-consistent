import java.util.*;

class Solution {
    public String smallestSubsequence(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastSeen.put(s.charAt(i), i);
        }
        Deque<Character> stack = new ArrayDeque<>();
        Set<Character> visited = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (visited.contains(c)) {
                continue;
            }
            while (!stack.isEmpty() && c < stack.peek() && lastSeen.get(stack.peek()) > i) {
                char removed = stack.pop();
                visited.remove(removed);
            }
            stack.push(c);
            visited.add(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast());
        }
        return sb.toString();
    }

}