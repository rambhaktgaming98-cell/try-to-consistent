 
import java.util.ArrayList;
import java.util.List;

class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        List<Integer> ones = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones.add(i);
            }
        }

        if (ones.size() < k) {
            return "";
        }

        String best = "";

        for (int i = 0; i <= ones.size() - k; i++) {
            int start = ones.get(i);
            int end = ones.get(i + k - 1);
            String candidate = s.substring(start, end + 1);

            if (best.isEmpty() 
                || candidate.length() < best.length() 
                || (candidate.length() == best.length() && candidate.compareTo(best) < 0)) {
                best = candidate;
            }
        }

        return best;
    }
}