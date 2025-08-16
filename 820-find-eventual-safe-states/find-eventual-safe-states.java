class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = graph.length;
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        int[] indeg = new int[V];
        for(int i=0;i<V;i++){
            for(int j:graph[i]){
                adj.get(j).add(i);
                indeg[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indeg[i]==0){
                q.offer(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            for(int i:adj.get(node)){
                indeg[i]--;
                if(indeg[i] == 0){
                    q.offer(i);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}