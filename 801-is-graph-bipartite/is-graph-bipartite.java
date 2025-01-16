class Solution {
    public boolean check(int start,int col[],int graph[][]){
        Queue<Integer> q = new LinkedList<>();
        col[start] = 0;
        q.add(start);
        while(!q.isEmpty()){
            int node = q.remove();
            for(int it : graph[node]){
                if(col[it]==-1){
                    col[it]=1-col[node];
                    q.add(it);
                }else{
                    if(col[it]==col[node]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int col[] = new int[V];
        for(int i=0;i<V;i++){
            col[i] = -1;
        }
        for(int i=0;i<V;i++){
            if(col[i]==-1){
                if(check(i,col,graph)==false){
                    return false;
                }
            }
        }
        return true;
    }
}