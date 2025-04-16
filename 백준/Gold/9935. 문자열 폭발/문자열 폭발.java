import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();
        int strLen = 0;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            sb.append(str.charAt(i));

            if(sb.length()-bomb.length() >= 0){
                int idx = 0;
                int cnt = 0;
                for(int j = sb.length()-bomb.length(); j < sb.length(); j++){
                    if(sb.charAt(j) == bomb.charAt(idx++)){
                        cnt++;
                    }
                }

                if(cnt == bomb.length()){
                    sb.delete(sb.length()-bomb.length(), sb.length());
                }
            }
        }

        System.out.println(sb.toString().isBlank() ? "FRULA" : sb);
    }
}