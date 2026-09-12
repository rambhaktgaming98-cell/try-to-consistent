 import java.util.*;

class Solution {

    static class Interval {
        int l, r, weight, id;

        Interval(int l, int r, int weight, int id) {
            this.l = l;
            this.r = r;
            this.weight = weight;
            this.id = id;
        }
    }

    static class State {
        long sum;
        List<Integer> indices;

        State(long sum, List<Integer> indices) {
            this.sum = sum;
            this.indices = indices;
        }

        boolean isBetterThan(State other) {
            if (other == null) return true;
            if (this.sum != other.sum) {
                return this.sum > other.sum;
            }
            int len = Math.min(this.indices.size(), other.indices.size());
            for (int i = 0; i < len; i++) {
                if (!this.indices.get(i).equals(other.indices.get(i))) {
                    return this.indices.get(i) < other.indices.get(i);
                }
            }
            return this.indices.size() < other.indices.size();
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervalsList) {
        int n = intervalsList.size();
        Interval[] intervals = new Interval[n];

        for (int i = 0; i < n; i++) {
            List<Integer> row = intervalsList.get(i);
            intervals[i] = new Interval(row.get(0), row.get(1), row.get(2), i);
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a.r, b.r));

        State[][] dp = new State[n + 1][5];
        for (int i = 0; i <= n; i++) {
            for (int c = 0; c <= 4; c++) {
                dp[i][c] = new State(0, new ArrayList<>());
            }
        }

        int[] prev = new int[n];
        for (int i = 0; i < n; i++) {
            int low = 0, high = i - 1;
            int best = -1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (intervals[mid].r < intervals[i].l) {
                    best = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            prev[i] = best;
        }

        for (int i = 1; i <= n; i++) {
            Interval curr = intervals[i - 1];
            int p = prev[i - 1] + 1;

            for (int c = 1; c <= 4; c++) {
                State bestState = dp[i - 1][c];

                State prevState = dp[p][c - 1];
                List<Integer> nextIndices = new ArrayList<>(prevState.indices);
                nextIndices.add(curr.id);
                Collections.sort(nextIndices);

                State takeState = new State(prevState.sum + curr.weight, nextIndices);

                if (takeState.isBetterThan(bestState)) {
                    bestState = takeState;
                }

                dp[i][c] = bestState;
            }
        }

        State bestOverall = dp[n][4];
        for (int c = 1; c < 4; c++) {
            if (dp[n][c].isBetterThan(bestOverall)) {
                bestOverall = dp[n][c];
            }
        }

        int[] result = new int[bestOverall.indices.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = bestOverall.indices.get(i);
        }
        return result;
    }
}