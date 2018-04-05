class Solution {
    public int[] twoSum2(int[] nums, int target) {
        
        List<Element> elements = new ArrayList<Element>();
        for (int i = 0; i < nums.length ; i++)
            elements.add(new Element(i, nums[i]));
        
        Collections.sort(elements);
        
        int start = 0;
        int end = elements.size() - 1;
        
        while (start < end) {
            int curSum = elements.get(start).getVal() + elements.get(end).getVal();
            if(curSum == target){
                int[] reqdIndices = { elements.get(start).getIdx(), elements.get(end).getIdx() };
                return reqdIndices;
            }
            if(curSum > target)
                end--;
            else
                start++;
        }
        
        int[] reqdIndices = { -1,-1 };
        return reqdIndices;
    }
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> numToIdx = new HashMap<Integer, Integer>();
        
        for(int i = 0; i< nums.length; i++){
            int residue = target - nums[i];
            Integer residueIdx = numToIdx.get(residue);
            if(residueIdx != null){
                int[] reqdIndices = {residueIdx.intValue(), i};
                return reqdIndices;
            }
            numToIdx.put(nums[i], i);
        }
        int[] reqdIndices = { -1,-1 };
        return reqdIndices;
    }
}

class Element implements Comparable {
    int idx;
    int val;
    Element(int idx, int val) {
        this.idx = idx;
        this.val = val;
    }
    int getIdx(){
        return idx;
    }
    int getVal(){
        return val;
    }
    public int compareTo (Object o){
        if(! (o instanceof Element))
            throw new ClassCastException();
        return this.val - ((Element)o).getVal();
    }
}