class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] baby = {"aya", "ye", "woo", "ma"};
        for(int i = 0; i < babbling.length; i++){
            for(int j = 0; j < baby.length; j++){
                babbling[i] = babbling[i].replace(baby[j], " ");
            }
        }
        for(String str :babbling){
            if(str.trim().isEmpty()){
                answer++;
            }
        }
        return answer;
    }
}