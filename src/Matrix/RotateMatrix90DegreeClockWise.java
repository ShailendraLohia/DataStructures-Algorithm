package Matrix;

//https://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/

public class RotateMatrix90DegreeClockWise {
    public static void main(String[] args) {
        int mat[][]=
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                };
        int N=3;
        rotateMatrix(mat,N);
        displayMatrix(N,mat);

    }

    public static void rotateMatrix(int mat[][], int N) {
        if(mat.length==0)
            return;

        for(int x=0;x<N/2;x++) {
            for(int y=x;y<N-x-1;y++) {
                int temp=mat[x][y]; // assign mat[0][0]- iteration 1
                mat[x][y]=mat[y][N-x-1]; // row will be change in each iteration, column not
                mat[y][N-x-1]=mat[N-x-1][N-y-1]; // row will be same but column will change
                mat[N-x-1][N-y-1]=mat[N-y-1][x]; // row will be change in each iteration, column not
                mat[N-y-1][x]=temp; // assign temp variable
            }
        }
    }

    static void displayMatrix(int N, int mat[][])
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print(" " + mat[i][j]);

            System.out.print("\n");
        }
        System.out.print("\n");
    }

}
