class Solution {
    public int orangesRotting(int[][] grid) {
        
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
         int fresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((grid[i][j])==2){
                    q.add(new int[]{i,j});
                }
                if((grid[i][j])==1){
                    fresh++;
                }
            }
        }
        if(fresh==0)return 0;
        
        int total=0;
        int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            boolean roten=false;
            int size=q.size();
        for(int i=0;i<size;i++){
            int[] curr=q.poll();
            for(int[] d :dir){
                int r=curr[0]+d[0];
                int c=curr[1]+d[1];

                if(c>=0&&r>=0&&r<n&&c<m&&grid[r][c]==1){
                    grid[r][c]=2;
                    fresh--;
                    q.add(new int[]{r,c});
                    roten=true;
                }
            }
        }
        if(roten==true){
                  total++;
        }
    }
    return fresh==0?total:-1;
    }
}