import java.util.*;
import java.io.*;
class Main{
    static boolean[] visited;
    static boolean[] finished;
    static int[] student;
    static int n, count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < T; i++){
            count = 0;
            n = Integer.parseInt(br.readLine());
            student = new int[n+1];
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                student[j] = Integer.parseInt(st.nextToken());
            }
            visited = new boolean[n+1];
            finished = new boolean[n+1];
            for(int j = 1; j <= n; j++){
                if(!visited[j]){
                    dfs(j);
                }
            }
            System.out.println(n-count);
        }
    }
    public static void dfs(int current){
        if(!visited[current]){//방문하지않았다면
            visited[current] = true;//방문처리
        }else{//방문했다면
            finished[current] = true;//팀결성
            count++;
        }

        if(!finished[student[current]]){
            dfs(student[current]);
        }

        //visited[current] = false;
        finished[current] = true;
    }
}