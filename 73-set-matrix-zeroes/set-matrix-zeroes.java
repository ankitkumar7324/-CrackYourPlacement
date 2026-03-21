class Solution {
    void markrow(int matrix[][],int i,int m){
        for(int j=0;j<m;j++){
            if(matrix[i][j]!=0){
                matrix[i][j] = -10;
            }
        }
    }
    void markcol(int matrix[][],int j,int n){
        for(int i=0;i<n;i++){
            if(matrix[i][j]!=0){
                matrix[i][j] = -10;
            }
        }
    }
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    markrow(matrix,i,m);
                    markcol(matrix,j,n);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==-10){
                    matrix[i][j]=0;
                }
            }
        }
    }
}