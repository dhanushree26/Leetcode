class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i[]:prerequisites){
            int u = i[0];
            int v = i[1];
            adj.get(v).add(u);
        }
        int[] indeg = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int j:adj.get(i)){
                indeg[j]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0){
                q.offer(i);
            }
        }
        int[] arr = new int[numCourses];
        int idx = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            arr[idx++] = node;
            for(int i:adj.get(node)){
                indeg[i]--;
                if(indeg[i]==0){
                    q.offer(i);
                }
            }
        }
        if(idx == numCourses){
            return arr;
        }
        else{
            return new int[0];
        }
    }
}