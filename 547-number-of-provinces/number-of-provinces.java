class Solution {
    private static void dfs(int node , ArrayList<ArrayList<Integer>> adj , boolean vis[])
    {
        vis[node] = true;
        for(int it : adj.get(node))
        {
            if(!vis[it])
            {
                dfs(it,adj,vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = isConnected.length;
        

        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(isConnected[i][j]==1 && i!=j)
                {
                    adj.get(i).add(j);
                }
            }
        }
        boolean vis[] = new boolean[n];
        int cnt =0;
        for(int i=0;i<n;i++)
        {
            if(!vis[i])
            {
                dfs(i,adj,vis);
                cnt++;
            }
        }
        return cnt;
    }
}