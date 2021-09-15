import java.io.*;

public class boj6588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = 1000000;
        boolean[] arr = new boolean[max+1];

        arr[0] = true;
        arr[1] = true;

        for(int i = 2; i <= Math.sqrt(max); i++){
            if(arr[i]) continue;
            for(int j = i*i; j <= max; j+=i){
                arr[j] = true;
            }
        }

        String input = "";
        while(!(input = br.readLine()).equals("0")){
            int end = Integer.parseInt(input);
            boolean bool = false;
            for(int i = 3; i <= end; i++){
                if(!arr[i] && !arr[end - i]){
                    bw.write(end + " = " + i + " + " + (end - i) + "\n");
                    bool = true;
                    break;
                }
            }
            if(!bool) bw.write("Goldbach's conjecture is wrong.");
        }
        bw.flush();
        bw.close();
    }
}