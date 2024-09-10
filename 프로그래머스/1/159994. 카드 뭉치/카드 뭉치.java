class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int x = 0;
        int y = 0;
       
        for(int i = 0; i < goal.length; i++){
            if(x < cards1.length && cards1[x].equals(goal[i])){
                x++;
                continue;
            }
            if(y < cards2.length && cards2[y].equals(goal[i])){
                y++;
                continue;
            }

            return "No";
        }
        
        
        return "Yes";
    }
}