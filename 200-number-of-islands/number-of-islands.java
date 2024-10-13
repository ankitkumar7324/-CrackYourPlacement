class Solution {
    static class Pair{
        int first;
        int second;
        public Pair(int fir,int sec)
        {
            this.first = fir;
            this.second = sec;
        }
    }
    public static void bfs(int ro,int co,char[][] grid,int vis[][],int delrow[],int delcol[])
    {
        vis[ro][co] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(ro,co));
        int n = grid.length;
        int m = grid[0].length;
        while(!q.isEmpty())
        {
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();
            for(int i=0;i<4;i++)
            {
                int nrow = row+delrow[i];
                int ncol = col+delcol[i];
                if(nrow>=0 && nrow <n && ncol >=0 && ncol<m && grid[nrow][ncol]=='1' && vis[nrow][ncol]==0)
                {
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow,ncol));
                }
            }

        }

    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        int delrow[] = {-1,0,1,0};
        int delcol[] = {0,1,0,-1};
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j]==0 && grid[i][j]=='1')
                {
                    bfs(i,j,grid,vis,delrow,delcol);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}