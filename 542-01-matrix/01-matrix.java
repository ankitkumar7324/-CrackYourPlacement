class Solution {
    class Pair{
        int row;
        int col;
        int steps;
        public Pair(int row,int col,int steps){
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        Queue<Pair> q = new LinkedList<>();
        int n = mat.length;
        int m = mat[0].length;
        int ans[][] = new int[n][m];
        int vis[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    vis[i][j] = 1;
                    q.add(new Pair(i,j,0));
                }
            }
        }
        int delrow[] = {-1,0,1,0};
        int delcol[] = {0,1,0,-1};
        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int steps = q.peek().steps;
            q.remove();
            ans[row][col] = steps;
            for(int i=0;i<4;i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if(nrow>=0&& nrow< n && ncol >= 0 && ncol <m && vis[nrow][ncol] == 0)
                {
                    vis[nrow][ncol]=1;
                    q.add(new Pair(nrow,ncol,steps+1));
                }
            }
        }
        return ans;

    }
}