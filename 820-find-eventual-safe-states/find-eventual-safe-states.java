class Solution {
    public boolean dfscheck(int start,int graph[][],int vis[],int pathvis[],int check[]){
        vis[start]=1;
        pathvis[start] = 1;
        check[start] = 0;
        for(int it : graph[start]){
            if(vis[it]==0){
                if(dfscheck(it,graph,vis,pathvis,check)==true){
                    return true;
                }
            }else{
                if(pathvis[it]==1){
                    return true;
                }
            }
        }
        pathvis[start] = 0;
        check[start] = 1;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
       int V = graph.length;
       int vis[] = new int[V];
       int pathvis[] = new int[V];
       int check[] = new int[V]; 
       for(int i=0;i<V;i++){
        if(vis[i]==0){
            dfscheck(i,graph,vis,pathvis,check);
        }
       }
       List<Integer> ans = new ArrayList<>();
       for(int i=0;i<V;i++){
        if(check[i]==1){
            ans.add(i);
        }
       }
       return ans;
    }
}