class Solution {
    public void markRow(int[][] matrix,int n,int m,int i)
    {
        for(int j=0;j<m;j++)
        {
            if(matrix[i][j]!=0)
            {
                matrix[i][j]=-11;
            }
        }
    }
    public void markCol(int[][] matrix,int n,int m,int j)
    {
        for(int i=0;i<n;i++)
        {
            if(matrix[i][j]!=0)
            {
                matrix[i][j]=-11;
            }
        }
    }
    public void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]==0)
                {
                    markRow(matrix,n,m,i);
                    markCol(matrix,n,m,j);
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]==-11)
                {
                    matrix[i][j]=0;
                }
            }
        }
        
    }
}