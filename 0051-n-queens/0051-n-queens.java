class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res= new ArrayList<>();
        char[][] board = new char[n][n];

        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        solve(0,board,res);
        return res;
    }
    void solve(int row,char[][] board,List<List<String>> res){
        if(row==board.length){
            res.add(construct(board));
            return;
        }

        for(int col=0;col<board.length;col++){
            if(isSafe(board,row,col)){
                board[row][col]='Q';
                solve(row+1,board,res);
                board[row][col]='.';
            }
        }
    }
boolean isSafe(char[][] board,int row,int col){
    for(int i=0;i<row;i++){
        if(board[i][col]=='Q')return false;
    }
    for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
        if(board[i][j]=='Q')return false;
    }
    for(int i=row-1,j=col+1;i>=0&&j<board.length;i--,j++){
        if(board[i][j]=='Q')return false;
    }
   return true;
}
List<String> construct(char[][] board){
    List<String> ans = new ArrayList<>();
    for(char[] row:board){
        ans.add(new String(row));
    }
    return ans;
}
}