import java.io.*;
class Main{
    static char[][] star;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        star = new char[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                star[i][j] = '*';
                star(i,j, N);
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                answer.append(star[i][j]);
            }
            answer.append('\n');
        }
        System.out.println(answer);
    }
    public static void star(int i, int j, int n){
        if(n == 0) return;
        if((i/n)%3 == 1 && (j/n)%3 == 1){
            star[i][j] = ' ';
        }else{
            star(i,j,n/3);
        }
    }
}