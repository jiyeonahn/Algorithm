import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // 초기값 100에서 움직일 수 있는 값으로 초기화
        int answer = Math.abs(target-100);

        // 고장난 버튼이 없는 경우
        if(M == 0) {
            System.out.println(Math.min(String.valueOf(target).length(), answer));
            return;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] broken = new boolean[10];
        for(int i = 0; i < M; i++){
            broken[Integer.parseInt(st.nextToken())] = true;
        }

        // 특정 채널로가서 +,-하기
        for(int i = 0; i <= 999999; i++){
            boolean pass = false;
            String num = String.valueOf(i);
            for(int j = 0; j < num.length(); j++){
                if(broken[num.charAt(j) -'0']){
                    pass = true;
                    break;
                }
            }
            if(!pass){
                answer = Math.min(Math.abs(target-i) + num.length(), answer);
            }
        }

        System.out.println(answer);
    }
}