import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num  = br.readLine();
        int cnt01 = 0;
        int cnt10 = 0;

        if(num.substring(num.length()-1).equals("0"))
            num += "1";
        else
            num += "0";

        for(int i = 1; i < num.length(); i++){
            String s = num.substring(i-1,i) + num.substring(i,i+1);
            if(s.equals("01"))
                cnt01++;
            else if(s.equals("10"))
                cnt10++;
        }

        System.out.println(Math.min(cnt01,cnt10));

    }
}
