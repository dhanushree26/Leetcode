class Solution {
    public String minWindow(String s, String t) {
        int l = 0;
        int r =0;
        Map<Character,Integer> maps = new HashMap<>();
        Map<Character,Integer> mapt = new HashMap<>();
        for(char c:t.toCharArray()){
            mapt.put(c,mapt.getOrDefault(c,0)+1);
        }
        //StringBuilder str = new StringBuilder();
        int val = 0;
        int min = Integer.MAX_VALUE;
        int ind1 = 0;
        int ind2 = 0;
        while(r<s.length()){
            char c = s.charAt(r);
            r++;
            if(mapt.containsKey(c)){
                maps.put(c,maps.getOrDefault(c,0)+1);
                if(mapt.get(c).equals(maps.get(c))){
                    val++;
                }
            }
            while(val==mapt.size()){
                if(r-l<min){
                    min = r-l;
                    ind1 = l;
                    ind2 = r;
                }
                char d = s.charAt(l);
                l++;
                if(mapt.containsKey(d)){
                    if(mapt.get(d).equals(maps.get(d))){
                        val--;
                    }
                    maps.put(d,maps.get(d)-1);
                }
            }
        }
        // if(min==Integer.MAX_VALUE){
        //     return "";
        // }
        return s.substring(ind1,ind2);
    }
}