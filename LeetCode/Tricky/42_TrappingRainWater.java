class Solution {
    public int trap(int[] height) {
        
        if(height.length <= 2)
            return 0;
        
        int[] leftBound = new int[height.length];
        int[] rightBound = new int[height.length];
        
        fillLeftBound(height, leftBound);
        fillRightBound(height, rightBound);
        
        int area = 0;
        for(int i = 0; i<height.length; i++) {
            int minBoundHeight = Math.min(leftBound[i], rightBound[i]);
            if(minBoundHeight > height[i]) {
                area += (minBoundHeight - height[i]);
            }
        }
        return area;
    }
    
    private void fillRightBound(int[] height, int[] rightBound) {

        rightBound[height.length -1] = 0;
        int maxr = height[height.length -1];
        for(int i = height.length - 2; i >= 0; i--) {
            rightBound[i] = maxr;
            if(maxr < height[i])
                maxr = height[i];
        }
    }

    private void fillLeftBound(int[] height, int[] leftBound) {

        leftBound[0] = 0;
        int maxl = height[0];

        for(int i = 1; i<height.length; i++) {
            leftBound[i] = maxl;
            if(maxl < height[i])
                maxl = height[i];
        }
    }
}