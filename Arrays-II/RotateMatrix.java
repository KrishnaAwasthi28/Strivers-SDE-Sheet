// You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

class RotateMatrix {
    public void Transpose(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<i;j++){
                swap(matrix,i,j);
            }
        }
    } 
    public void swap(int[][] matrix,int i,int j){
        int temp=matrix[i][j];
        matrix[i][j]=matrix[j][i];
        matrix[j][i]=temp;
    }
    public void rotate(int[][] matrix) {
        Transpose(matrix);
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][n-1-j];
                matrix[i][n-1-j]=temp;
            }
        }
    }
}