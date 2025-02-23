import java.util.*;
import java.io.*;
class Main{ 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        
        ArrayList<Integer> list = new ArrayList<>();
        
        int answer = 0;
        int current = A;
        
        while(true){
            if(list.contains(current)){//list에 존재한다면
                answer = list.indexOf(current);
                break;
            }
            list.add(current);
            String numStr = String.valueOf(current);
            int sum = 0;
            for(int i = 0; i < numStr.length(); i++){
                int n = numStr.charAt(i) - '0';
                sum += Math.pow(n,P);
            }
            current = sum;
        }
        System.out.println(answer);
    }
}