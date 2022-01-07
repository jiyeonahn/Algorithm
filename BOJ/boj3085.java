import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj3085 {
    private static int N, answer;
    private static char[][] arr;

    public static void width(){
        for(int i = 0; i < N; i++){
            int count = 1;
            for(int j = 1; j < N; j++){
                if(arr[i][j] == arr[i][j-1])
                    count++;
                else count = 1;//이전 문자와 다를 경우 1로 초기화
                answer = Math.max(answer, count);
            }
        }
    }

    public static void height(){
        for(int i = 0; i < N; i++){
            int count = 1;
            for(int j = 1; j < N; j++){
                if(arr[j][i] == arr[j-1][i])
                    count++;
                else count = 1;
                answer = Math.max(answer, count);//마지막에 1로 끝날 수 있으니깐,,for문 안에 써줘요
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        String str;

        for(int i = 0; i < N; i++){
            str = br.readLine();
            for(int j = 0; j < N; j++){
                arr[i][j] = str.charAt(j);
            }
        }

        char temp;
        for(int i = 0; i < N; i++){
            for(int j = 1; j < N; j++){
                temp = arr[i][j];
                arr[i][j] = arr[i][j-1];
                arr[i][j-1] = temp;

                width();
                height();

                temp = arr[i][j];
                arr[i][j] = arr[i][j-1];
                arr[i][j-1] = temp;
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 1; j < N; j++){
                temp = arr[j][i];
                arr[j][i] = arr[j-1][i];
                arr[j-1][i] = temp;

                width();
                height();

                temp = arr[j][i];
                arr[j][i] = arr[j-1][i];
                arr[j-1][i] = temp;
            }
        }
        System.out.println(answer);
    }
}