import java.util.PriorityQueue;
class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        int[] diff = new int[numlist.length];
        for(int i = 0; i < numlist.length; i++){
            diff[i] = numlist[i] - n;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
           int absA = Math.abs(a); 
           int absB = Math.abs(b);
            
            if(absA != absB){
                return absA - absB;
            }else{
                return a > b ? -1 : 1;
            }
        });
        
        for(int num : diff){
            pq.add(num);
        }
        
        int idx = 0;
        while(!pq.isEmpty()){
            answer[idx++] = pq.poll() + n;
        }
        
        return answer;
    }
}