class Solution {
    public int solution(int a, int b) {
        int min = a>b?b:a;
        int n = 1;
        for(int i = 2; i <= min; i++){
            if(a%i == 0 && b%i == 0){
               n = i;//최대공약수 찾기
            }
        }
        a = a/n;
        b = b/n;
        
        for(int i = 2; i <= b; i++){
            if(b%i == 0){
                if(i%2 != 0 && i%5 != 0){
                    return 2;
                }
            }
        }
        
        return 1;
    }
}