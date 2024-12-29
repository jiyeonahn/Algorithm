class Solution {
    boolean[] visited;
    int answer;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin, 0, words, target);            
        return answer;
    }
    public void dfs(String currentWord, int currentCount, String[] words, String target){
        if(currentWord.equals(target)){
            answer = answer == 0 ? currentCount : Math.min(answer, currentCount);
            return;
        }
        
        for(int i = 0; i < words.length; i++){
            int equalCount = 0;
            for(int j = 0; j < currentWord.length(); j++){
                if(!visited[i] && currentWord.charAt(j) == words[i].charAt(j)){
                    equalCount++;
                }
            }
            if(equalCount == currentWord.length() - 1){
                visited[i] = true;
                dfs(words[i], currentCount + 1, words, target);
                visited[i] = false;
            }
        }
        
        
    }
}