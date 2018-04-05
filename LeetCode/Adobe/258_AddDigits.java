class Solution {
    public int addDigits(int num) {
        if(num == 0)
            return 0;
        int group = num%9;
        if(group == 0)
            group = 9;
        return group;
    }
}