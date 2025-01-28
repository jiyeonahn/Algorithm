import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] ch = str.toCharArray();
        for(int i = 0; i < ch.length; i++){
            if('a' <= ch[i] && 'z' >= ch[i]){
                if(ch[i] + 13 > 'z'){
                    ch[i] = (char)('a' + ch[i] + 13 - 'z' - 1);
                }else{
                    ch[i] = (char)(ch[i] + 13);
                }
            }else if('A' <= ch[i] && 'Z' >= ch[i]){
                if(ch[i] + 13 > 'Z'){
                    ch[i] = (char)('A' + ch[i] + 13 - 'Z' - 1);
                }else{
                    ch[i] = (char)(ch[i] + 13);
                }
            }
        }//65~90, 97~122
        StringBuilder sb = new StringBuilder();
        for(char c : ch){
            sb.append(c);
        }

        System.out.println(sb);
    }
}