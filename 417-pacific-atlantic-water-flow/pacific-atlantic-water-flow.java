class Solution {
    private int[][] directions = {{0,1}, {1,0}, {-1,0},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        if (heights == null || m == 0 || n == 0) {
            return new ArrayList<>();
        }
        boolean[][] visitedP = new boolean[m][n];
        boolean[][] visitedA = new boolean[m][n];
        for(int i=0;i<m;i++){
              dfs(heights,i,0,visitedP);
        }
            
        for(int j=0;j<n;j++){
              dfs(heights,0,j,visitedP);
        }

        for(int i=0;i<m;i++){
              dfs(heights,i,n-1,visitedA);
        }

        for(int j=0;j<n;j++){
              dfs(heights,m-1,j,visitedA);
        }

          List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visitedP[i][j] && visitedA[i][j]) {
                    List<Integer> coord = new ArrayList<>();
                    coord.add(i);
                    coord.add(j);
                    result.add(coord);
                }
            }
        }
        return result; 
        
    
    }
    private void dfs(int[][] heights, int row, int col, boolean[][] visited) {
        int m = heights.length;
        int n = heights[0].length;
        visited[row][col] = true;
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow>=0 && newRow< m && newCol>=0 && newCol < n)
              if(!visited[newRow][newCol] && heights[newRow][newCol] >= heights[row][col]) {
                dfs(heights, newRow, newCol, visited);
            }
        }
    }
}