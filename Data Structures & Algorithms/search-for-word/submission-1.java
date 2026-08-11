class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(backtrack(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, String word, int rows, int cols, int index){
        if(index == word.length()){
            return true;
        }

        if(rows<0 || rows >= board.length || cols<0 || cols >= board[0].length){
            return false;
        } 

        if(board[rows][cols] != word.charAt(index)){
            return false;
        }

        char temp = board[rows][cols];
        board[rows][cols] = '#';

        boolean exist = backtrack(board, word, rows+1, cols, index+1) || backtrack(board, word, rows-1, cols, index+1) || backtrack(board, word, rows, cols+1, index+1) || backtrack(board, word, rows, cols-1, index+1);

        board[rows][cols] = temp;
        return exist;
    }
}
