import java.util.*;
import java.lang.*;
class Solution {

    boolean[] visited = new boolean[7];
    ArrayList<Integer> list = new ArrayList<>();

    public int solution(String numbers) {
        String[] num = new String[numbers.length()];

        for(int i = 0; i < numbers.length(); i++)
            num[i] = numbers.substring(i,i+1);

        String str = "";

        for(int i = 1; i <= num.length; i++)
            dfs(num,i,str);

        return list.size();
    }

    public void dfs(String num[], int level, String str){
        if(level == str.length()){
            if(!list.contains(Integer.parseInt(str)) && isPrime(Integer.parseInt(str)))
                list.add(Integer.parseInt(str));
            return;
        }

        for(int i = 0; i < num.length; i++){
            if(!visited[i]){
                str += num[i];
                visited[i] = true;
                dfs(num, level, str);
                str = str.substring(0, str.length() - 1);
                visited[i] = false;
            }

        }
    }

    public boolean isPrime(int n){
        if(n == 0 || n == 1) return false;
        else if(n == 2) return true;
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0)
                return false;
        }
        return true;
    }

}