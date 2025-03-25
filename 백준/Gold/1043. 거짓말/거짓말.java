import java.util.*;
import java.io.*;
class Main{
    static int[] parent;
    static HashSet<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //사람의 수
        int M = Integer.parseInt(st.nextToken()); //파티의 수

        parent = new int[N+1];
        for(int i = 0; i <= N; i++){
            parent[i] = i;
        }

        ArrayList<Integer>[] party = new ArrayList[M+1];
        for(int i = 0; i <= M; i++){
            party[i] = new ArrayList<>();
        }

        set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        int truth = Integer.parseInt(st.nextToken());
        for(int i = 0; i < truth; i++){//진실을 아는 사람
            int n = Integer.parseInt(st.nextToken());
            set.add(n);
        }

        int answer = M;

        for(int i = 1; i <= M; i++){
            boolean know = false;
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int prev = -1;
            for(int j = 0; j < cnt; j++){
                int p = Integer.parseInt(st.nextToken());//파티 참석자
                party[i].add(p);
                if(prev != -1){
                    union(prev, p);
                }else{
                    prev = p;
                }
            }
        }

        for(int i = 1; i <= M; i++){
            for(int p : party[i]){
                if(set.contains(find(p))){
                    answer--;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
    public static int find(int n){//최상위 노드 찾기
        if(parent[n] == n){
            return n;
        }
        return parent[n] = find(parent[n]); //경로 압축
    }
    public static void union(int n, int m){
        int rootN = find(n);
        int rootM = find(m);

        if(set.contains(rootN)){
            parent[rootM] = rootN;
        }else{
            parent[rootN] = rootM;
        }
    }
}