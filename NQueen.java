import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class NQueen {
 
    public static int [][] horses;
    public static int count;
    public static int size;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         
        size = Integer.parseInt(br.readLine());
 
        horses = new int[size][size];
 
        backtracking(0);
         
        bw.write(count+"");
        bw.newLine();
        bw.flush();
        bw.close();
    }
 
    private static void backtracking(int depth) {
 
        if(depth == 0) {
            for(int i = 0 ; i < size; i++) {
                horses[i][depth] = 1;
                backtracking(depth+1);
                horses[i][depth] = 0;
            }
        } else if(depth == size) {
            count++;
        } else {
 
            for( int x = 0; x < size; x++) {
 
                boolean killCheck = false;
                 
                for(int y= 0; y < depth; y++) {
                 
                    if(horses[x][y] == 1 ) {
                        killCheck= true;
                    }
                     
                    int check_x1 = x-(depth-y);
                    int check_x2 = x+(depth-y);
                    if( check_x1 >= 0 ) 
                        if( horses[check_x1][y] == 1) killCheck = true;
                    if( check_x2 < size )
                        if( horses[check_x2][y] == 1) killCheck = true;
                }
                 
                if(!killCheck) {
                    horses[x][depth] = 1;
                    backtracking(depth+1);
                    horses[x][depth] = 0;
                }
                 
            }
             
             
        }
         
    }
 
}
