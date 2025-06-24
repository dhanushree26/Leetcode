class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        Queue<Integer> pq = new PriorityQueue<>((a,b)->score[b]-score[a]);
        for(int i=0;i<n;i++){
            pq.add(i);
        }
        String[] ans = new String[n];
        int cnt = 1;
        while(!pq.isEmpty()){
            int idx = pq.poll();
            if(cnt==1){
                ans[idx] = "Gold Medal";
            }
            else if(cnt==2){
                ans[idx] = "Silver Medal";
            }
            else if(cnt==3){
                ans[idx] = "Bronze Medal";
            }
            else{
                ans[idx] = String.valueOf(cnt);
            }
            cnt++;
        }
        return ans;
    }
}