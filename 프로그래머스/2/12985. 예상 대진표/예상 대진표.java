import java.util.*;
class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        int nextA = a;
        int nextB = b;
        while(nextA != nextB){
            answer++;
            nextA = (int)Math.round(nextA/2.0);
            nextB = (int)Math.round(nextB/2.0);
        }
        

        return answer;
    }
}