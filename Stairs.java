package prof_day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//계단 오르기 (최종) 
	   
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
	   
	public class day8_stairs {
	    static final int MOD = (int)1e9 + 7;
	    static int N;
	    static Matrix A, V;
	       
	    public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        N = Integer.parseInt(br.readLine());
	        if(N == 1) System.out.println("1");
	        else {
	            A = new Matrix(1, 1, 1, 0);
	            V = new Matrix(1, 0, 0, 1);//V 행렬은 일종의 E 행렬 (E*A=A가 나오는 그런 행렬)
	            N-=2; //N-2번을 제곱해야 한다..
	            for (;N>0;N>>=1,A=A.multiply(A)) //shift 연산 과 제곱을 동시에 해 나간다..>>1 하게 되면 맨 마지막 bit를 버린다는 뜻
	                if ((N&1) == 1) //& 연산하게 되면 맨마지막Bit가 1인지 아닌지 판별 가능 //1이라는 얘기는 해당 bit가 있다는 이야기
	                	            //즉, 해당 bit를 가지고 있을 때에만, 다시 곱셈을 해 준다는 뜻 
	                    V = V.multiply(A);
	            System.out.println((V.m[0][0]*2%MOD+V.m[0][1])%MOD);//행렬로 생각하기!
	        }
	    }
	}
