class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        Arrays.fill(color,-1);
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(helper(i,color,graph,V)==false){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean helper(int start,int[] color,int[][] graph,int V){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        color[start] = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int i:graph[node]){
                if(color[i]==-1){
                    q.add(i);
                    color[i] = 1 - color[node];
                }
                else if(color[i]==color[node]){
                    return false;
                }
            }
        }
        return true;
    }
}