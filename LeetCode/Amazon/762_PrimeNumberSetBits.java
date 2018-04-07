class Solution {
    
    private int getNumSetBits(int num){
        int numSetBits = 0;
        while (num != 0) {
            if((num & 1) != 0) {
                numSetBits++;
            }
            num = num >> 1;
        }
        return numSetBits;
    }
    
    public int countPrimeSetBits(int L, int R) {
        
        int primeSetBitsCount = 0;
        
        List<Integer> primes = Arrays.asList(2,3,5,7,11,13,17,19,23,29,31);
        
        for(int n = L ; n <= R ; n++){
            int numSetBits = getNumSetBits(n);
            if (primes.contains(numSetBits)) {
                primeSetBitsCount++;   
            }
        }
        
        return primeSetBitsCount;
    }
}