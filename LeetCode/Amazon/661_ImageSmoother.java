class Solution {
    public int[][] imageSmoother(int[][] M) {
        
        if(M.length == 1 && M[0].length == 1)
            return M;
        
        for(int x = 0; x < M.length; x++) {
            
            for(int y = 0; y < M[x].length; y++) {
                
                int sum = M[x][y];
                int neighbors = 1;
                
                for(int tx = -1; tx <= 1; tx++) {
                    
                    for(int ty = -1; ty <= 1; ty++) {
                        
                        int srx = x + tx;
                        int sry = y + ty;
                        
                        if(srx >= 0 && srx < M.length && sry >= 0 && sry < M[x].length) {
                            
                            if(srx != x || sry != y) {
                                
                                sum += (M[srx][sry] & 255);
                                neighbors++;   
                            }
                            
                        }
                        
                    }  
                    
                }
                
                M[x][y] |= ((sum/neighbors) << 8);
                
            }
        }
        
        for(int x = 0; x < M.length; x++) {
            for(int y = 0; y<M[x].length; y++) {
                M[x][y] = (M[x][y] >> 8);
            }
        }
        
        return M;
    }
}