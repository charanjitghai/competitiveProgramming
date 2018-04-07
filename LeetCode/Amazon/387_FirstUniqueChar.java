class Solution {
    public int firstUniqChar(String s) {
        Map<Character, List<Integer>> charToIdx = new HashMap<Character, List<Integer>> ();
        
        for(int i = 0; i<s.length() ; i++) {
            char cur = s.charAt(i);
            if(charToIdx.containsKey(cur)) {
                if(charToIdx.get(cur).size() == 1) {
                    charToIdx.get(cur).add(i);
                }
            }
            else {
                List<Integer> idxList = new ArrayList<Integer>();
                idxList.add(i);
                charToIdx.put(cur, idxList);
            }
        }
        
        int minIdx = s.length();
        Iterator it = charToIdx.keySet().iterator();
        while(it.hasNext()){
            char c = (Character) it.next();
            if(charToIdx.get(c).size() == 1){
                int idx = charToIdx.get(c).get(0);
                if (idx < minIdx)
                    minIdx = idx;
            }
        }
        
        if(minIdx == s.length())
            minIdx = -1;
        
        return minIdx;
    }
}
