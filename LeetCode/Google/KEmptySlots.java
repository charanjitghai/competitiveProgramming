/**
* author: charanjitghai
* question: https://leetcode.com/explore/interview/card/google/67/sql-2/470/
*/


class bit {
    int maxDays;
    int[] tree;
    bit(int maxDays) {
        tree = new int[maxDays + 1];
        this.maxDays = maxDays;
    }
    void update(int idx, int val) {
        while(idx <= maxDays) {
            tree[idx] += val;
            idx += (idx & -idx);
        }
    }
    int read(int idx) {
        int sum = 0;
        while(idx > 0) {
            sum += tree[idx];
            idx -= (idx & -idx);
        }
        return sum;
    }
}


class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        int[] blooming = new int[flowers.length + 1];
        bit b = new bit(flowers.length);
        b.update(flowers[0], 1);
        blooming[flowers[0]] = 1;
        for(int i = 1; i < flowers.length; i++) {
            int oi = flowers[i];
            if(oi + k + 1 < blooming.length && blooming[oi + k + 1] == 1) {
                int x = b.read(oi + k + 1);
                int y = b.read(oi);
                if(x == y + 1)
                    return i+1;
            }
            if(oi - k - 1 >= 1 && blooming[oi - k - 1] == 1) {
                int x = b.read(oi - k - 1);
                int y = b.read(oi);
                if(x == y)
                    return i+1;
            }
            blooming[oi] = 1;
            b.update(oi, 1);
        }
        return -1;
    }
}
