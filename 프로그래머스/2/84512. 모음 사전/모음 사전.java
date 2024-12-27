class Solution {
    int answer = 0;
    int counter = 0;
    String[] alphabet = {"A", "E", "I", "O", "U"};
    public int solution(String word) {
        dfs(word, "");
        return answer;
    }
    void dfs(String word, String currentWord){
        if(currentWord.length() > 5){
            return;
        }
        if(currentWord.equals(word)){
            answer = counter;
            return;
        }
        counter++;
        for(int i = 0; i < 5; i++){
            dfs(word, currentWord + alphabet[i]);
        }
    }
}