class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i = 0; i < n; i++){
            int a = arr1[i];
            int b = arr2[i];
            String encode = Integer.toBinaryString(a | b);
            
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n-encode.length(); j++){
                sb.append(" ");
            }
            for(int j = 0; j < encode.length(); j++){
                 sb.append(encode.charAt(j) == '1' ? "#" : " ");
            }
            answer[i] = sb.toString();
        }
        
        
        return answer;
    }
}