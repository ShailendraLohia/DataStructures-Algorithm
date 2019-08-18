package Matrix;

// https://www.geeksforgeeks.org/rotate-matrix-elements/

public class RotateMatrixElements {
    static int R=3;
    static int C=3;
    public static void main(String[] args) {
        int mat[][]=
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                };

        rotateMatrixElement(R,C,mat);

    }

    static void rotateMatrixElement(int m, int n, int[][] mat) {
        if(mat.length==0)
            return;

        int row=0;
        int col=0;
        int prev, curr;

        while(row<m && col<n) {
            if(row+1==m || col+1==n)
                break;

            prev=mat[row +1][col];

            //Move first row element
            for(int i=col;i<n;i++) {
                curr=mat[row][i];
                mat[row][i]=prev;
                prev=curr;
            }
            row++;

            // Move last column element
            for(int i=row;i<m;i++) {
                curr=mat[i][n-1];
                mat[i][n-1]=prev;
                prev=curr;
            }
            n--;

            // Move last row element
            for(int i=n-1; i>=0;i--){
                curr=mat[row+1][i];
                mat[row+1][i]=prev;
                prev=curr;
            }

            m--;

            // Move first column element
            for(int i=m-1;i>0;i--) {
                curr=mat[i][n-2];
                mat[i][n-2]=prev;
                prev=curr;
            }
            col++;

            // Print rotated matrix
            for (int i = 0; i < R; i++)
            {
                for (int j = 0; j < C; j++)
                    System.out.print( mat[i][j] + " ");
                System.out.print("\n");
            }
        }
    }
}
