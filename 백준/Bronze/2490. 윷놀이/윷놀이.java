import java.io.*;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int front;
        int back;
        for(int i = 0; i < 3; i++){
            front = 0;
            back = 0;
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++){
                int n = Integer.parseInt(st.nextToken());
                if(n == 0){
                    front++;
                }else{
                    back++;
                }
            }
            switch(front){
                case 1:
                    System.out.println("A");
                    break;
                case 2:
                    System.out.println("B");
                    break;
                case 3:
                    System.out.println("C");
                    break;
                case 4:
                    System.out.println("D");
                    break;
                case 0:
                    System.out.println("E");
                    break;
            }
        }
    }
}