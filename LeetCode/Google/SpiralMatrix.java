/**
** author: charanjitghai
** question: https://leetcode.com/explore/interview/card/google/59/array-and-strings/338/
*/


class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if(matrix.length == 0)
            return order;
        int upBound = 0;
        int riBound = matrix[0].length;
        int leBound = -1;
        int dwBound = matrix.length;

        int x = 0, y = 0;
        int total = 0;

        int dirx = 0;
        int diry = 1;

        while(total < matrix.length * matrix[0].length) {

            //System.out.println("adding - " + matrix[x][y]);
            order.add(matrix[x][y]);

            int nx = x + dirx;
            int ny = y + diry;

            if(ny == riBound) {
                dirx = 1;
                diry = 0;
                x++;
            }
            else if(ny == leBound) {
                dirx = -1;
                diry = 0;
                x--;
            }
            else if(nx == dwBound) {
                dirx = 0;
                diry = -1;
                y--;
            }
            else if(nx == upBound && dirx == -1) {
                dirx = 0;
                diry = 1;
                y++;
                upBound++;
                riBound--;
                leBound++;
                dwBound--;
            }
            else {
                x = nx;
                y = ny;
            }
            total++;
        }
        return order;
    }
}
