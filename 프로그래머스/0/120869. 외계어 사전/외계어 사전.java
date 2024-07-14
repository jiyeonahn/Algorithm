class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        int[] cnt = new int[dic.length];
        for(int i = 0; i < spell.length; i++){
            for(int j = 0; j < dic.length; j++){
                if(dic[j].contains(spell[i])){
                    cnt[j]++;
                }
            }
        }
        
        for(int i = 0; i < dic.length; i++){
            if(dic[i].length() == spell.length && cnt[i] == spell.length){
                answer = 1;
            }
        }
        
        return answer;
    }
}