class Solution {
    class Pair{
        int first;
        int second;
        public Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int delrow[] = {-1,0,1,0};
        int delcol[] = {0,1,0,-1};
        int cnt1=0;
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                }
                if(grid[i][j]==1){
                    cnt1++;
                }
                
            }
        }
        int cnt=0;
        while(!q.isEmpty()){
            int size = q.size();
            boolean anyfreshrotten = false;
            for(int i=0;i<size;i++){
                int row = q.peek().first;
                int col = q.peek().second;
                q.remove();
                for(int j=0;j<4;j++){
                    int nrow = delrow[j]+row;
                    int ncol = delcol[j]+col;
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1){
                        grid[nrow][ncol]=2;
                        cnt1--;
                        q.add(new Pair(nrow,ncol));
                        anyfreshrotten = true;
                    }
                }
            }
            if(anyfreshrotten) cnt++;
        }
        if(cnt1>0){
            return -1;
        }
        return cnt;
    }
}