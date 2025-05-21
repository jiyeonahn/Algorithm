import java.util.*;
import java.io.*;
class Main{
    static int answer;
    static int N,K;
    static boolean[] alpha;
    static String[] word;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());//남극 언어에 단어는 N개 밖에 없다
        K = Integer.parseInt(st.nextToken());

        word = new String[N];

        for(int i = 0; i < N; i++){
            word[i] = br.readLine().replace("anta", "");
            word[i] = word[i].replace("tica","");
        }

        if(K < 5) {
            System.out.println(0);
            return;
        }

        if(K == 26){
            System.out.println(N);
            return;
        }

        K -= 5;
        alpha = new boolean[26];
        alpha[0] = true;
        alpha['c'-'a'] = true;
        alpha['i'-'a'] = true;
        alpha['n'-'a'] = true;
        alpha['t'-'a'] = true;

        dfs(0,0);

        System.out.println(answer);
    }
    public static void dfs(int idx, int cnt){
        if(cnt == K){
            int read = 0;
            for(int i = 0; i < N; i++){
                boolean readPossible = true;
                for(int j = 0; j < word[i].length(); j++){
                    if(!alpha[word[i].charAt(j)-'a']){
                        readPossible = false;
                        break;
                    }
                }
                if(readPossible){
                    read++;
                }
            }
            answer = Math.max(answer, read);
            return;
        }
        for(int i = idx; i < 26; i++){
            if(!alpha[i]){
                alpha[i] = true;
                dfs(i+1,cnt+1);
                alpha[i] = false;
            }
        }
    }
}