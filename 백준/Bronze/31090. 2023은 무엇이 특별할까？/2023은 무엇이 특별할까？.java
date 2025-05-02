import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++){
            String N = br.readLine();
            int endN = Integer.parseInt(N.substring(2));
            if((Integer.parseInt(N)+1)%endN == 0){
                sb.append("Good");
            }else{
                sb.append("Bye");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}