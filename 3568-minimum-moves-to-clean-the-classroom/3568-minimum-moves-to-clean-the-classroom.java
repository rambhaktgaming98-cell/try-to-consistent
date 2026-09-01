/* In this problem i havent wrote  single line of code i just try to figure to solve this and after about 30 mins of tal with chat
gpt i did that stuff soo thats his code  
*/

 import java.util.*;

class Solution {
    static class State {
        int r, c, energy, mask, moves;

        State(int r, int c, int energy, int mask, int moves) {
            this.r = r;
            this.c = c;
            this.energy = energy;
            this.mask = mask;
            this.moves = moves;
        }
    }

    public int minMoves(String[] grid, int maxEnergy) {
        int m = grid.length;
        int n = grid[0].length();

        int startR = -1, startC = -1;
        List<int[]> litters = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = grid[i].charAt(j);
                if (ch == 'S') {
                    startR = i;
                    startC = j;
                } else if (ch == 'L') {
                    litters.add(new int[]{i, j});
                }
            }
        }

        int totalLitters = litters.size();
        if (totalLitters == 0) return 0;

        int targetMask = (1 << totalLitters) - 1;
        boolean[][][][] visited = new boolean[m][n][maxEnergy + 1][1 << totalLitters];

        Queue<State> queue = new LinkedList<>();
        queue.add(new State(startR, startC, maxEnergy, 0, 0));
        visited[startR][startC][maxEnergy][0] = true;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            State curr = queue.poll();

            for (int[] dir : dirs) {
                int nr = curr.r + dir[0];
                int nc = curr.c + dir[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr].charAt(nc) == 'X') {
                    continue;
                }

                char cell = grid[nr].charAt(nc);
                int nextEnergy = curr.energy - 1;
                int nextMask = curr.mask;

                if (cell == 'R') {
                    nextEnergy = maxEnergy;
                } else if (cell == 'L') {
                    for (int k = 0; k < totalLitters; k++) {
                        if (litters.get(k)[0] == nr && litters.get(k)[1] == nc) {
                            nextMask |= (1 << k);
                            break;
                        }
                    }
                }

                if (nextMask == targetMask) {
                    return curr.moves + 1;
                }

                if (nextEnergy == 0 && cell != 'R') {
                    continue;
                }

                if (!visited[nr][nc][nextEnergy][nextMask]) {
                    visited[nr][nc][nextEnergy][nextMask] = true;
                    queue.add(new State(nr, nc, nextEnergy, nextMask, curr.moves + 1));
                }
            }
        }

        return -1;
    }
}