class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> list = new ArrayList<>();
         int n=grid.length;
         int m=grid[0].length;
         int[][] grid1 = new int[n][m];
         for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                      grid1[i][j]=grid[i][j];
                }
         }
        while(k>0){
            int[][] temp=new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if (i == n - 1 && j == m - 1) {
    temp[0][0] = grid1[i][j];
}
else if (j == m - 1) {
    temp[i + 1][0] = grid1[i][j];
}
else {
    temp[i][j + 1] = grid1[i][j];
}
                }
            }
            grid1=temp;
            k--;
        }
        for (int i = 0; i < n; i++) {
    List<Integer> row = new ArrayList<>();
    for (int j = 0; j < m; j++) {
        row.add(grid1[i][j]);
    }
    list.add(row);
}

      return list;
        
    }
}