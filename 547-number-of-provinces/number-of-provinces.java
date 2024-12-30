class Solution {
    public void dfs(int start,ArrayList<ArrayList<Integer>> adj , int vis[]){
        vis[start] = 1;
        for(int it : adj.get(start)){
            if(vis[it]==0){
                dfs(it,adj,vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int vis[] = new int[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j] == 1 && i!=j){
                    adj.get(i).add(j);
                }
            }
        }
        int cnt=0;
        for(int i = 0;i<n;i++){
            if(vis[i] == 0){
                dfs(i,adj,vis);
                cnt++;
            }
        }
        return cnt;
    }
}