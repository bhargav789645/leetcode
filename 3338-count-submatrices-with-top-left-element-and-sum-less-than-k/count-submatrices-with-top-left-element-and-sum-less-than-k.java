class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        if(grid[0][0] > k) return 0;
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
               if(i==0 && j==0){
                grid[0][0] = grid[0][0];
            }
               else if(i==0) {
                grid[i][j] = grid[i][j-1] + grid[i][j];
               }
               else if(j==0) {
                 grid[i][j] = grid[i-1][j] + grid[i][j];
               }
               else{
                grid[i][j] = grid[i][j] + grid[i-1][j] + grid[i][j-1] - grid[i-1][j-1];
               }
               if(grid[i][j] <= k) count++;
            
            }
        }
        return count;
    }
}