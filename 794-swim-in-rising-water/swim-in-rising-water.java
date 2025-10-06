class Pair {
    int time;
    int row;
    int col;
    public Pair(int time, int row, int col) {
        this.time = time;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);

        pq.offer(new Pair(grid[0][0], 0, 0));
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int t = p.time, r = p.row, c = p.col;

            if (r == n - 1 && c == n - 1) return t;
            if (visited[r][c]) continue;
            visited[r][c] = true;

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nc >= 0 && nr < n && nc < n && !visited[nr][nc]) {
                    pq.offer(new Pair(Math.max(t, grid[nr][nc]), nr, nc));
                }
            }
        }
        return -1; 
    }
}
