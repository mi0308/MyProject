import java.io.*;
 
class Matrix {
    static final int MOD = (int)1e9 + 7;
     
    public Matrix() {
    }
     
    public Matrix(int a, int b, int c, int d) {
        m[0][0] = a;
        m[0][1] = b;
        m[1][0] = c;
        m[1][1] = d;
    }
     
    int[][] m = new int[2][2];
     
    public Matrix multiply(Matrix ot) {
        Matrix ret = new Matrix();
        for (int i=0;i<2;i++) for (int j=0;j<2;j++){
            for (int k=0;k<2;k++)
                ret.m[i][j] = (ret.m[i][j]+(int)(((long)m[i][k]*ot.m[k][j])%MOD))%MOD;
        }
        return ret;
    }
}
 
public class source {
    static final int MOD = (int)1e9 + 7;
    static int N;
    static Matrix A, V;
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new Matrix(1, 1, 1, 0);
        V = new Matrix(1, 0, 0, 1);
        for (;N>0;N>>=1,A=A.multiply(A))
            if ((N&1) == 1)
                V = V.multiply(A);
        System.out.println((V.m[1][0]+V.m[1][1])%MOD);
    }
}
