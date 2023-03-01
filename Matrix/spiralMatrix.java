Given an m x n matrix, return all elements of the matrix in spiral order.
  
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]


class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> spiral_order = new ArrayList<>();
        int start_row = 0, start_col = 0, end_row = matrix.length - 1, end_col = matrix[0].length - 1;

        while(start_row <= end_row && start_col <= end_col){

            // top - row (constant), col (left -> right) 
            for(int i = start_col; i <= end_col; i++){
                spiral_order.add(matrix[start_row][i]);
            }

            // right - row(top -> bottom), col (const)
            for(int i = start_row + 1; i <= end_row; i++){
                spiral_order.add(matrix[i][end_col]);
            }

            // bottom - row(const), col (right -> left)
            for(int i = end_col - 1; i >= start_col; i--){
                if(start_row == end_row) {
                    break;
                }
                spiral_order.add(matrix[end_row][i]);
            }

            // left - row(bottom -> top), col (const)
            for(int i = end_row - 1; i > start_row; i--){
                if(start_col == end_col) {
                    break;
                }
                spiral_order.add(matrix[i][start_col]);
            }
            start_row++;
            start_col++;
            end_row--;
            end_col--;
        }

        return spiral_order;
    }
}
