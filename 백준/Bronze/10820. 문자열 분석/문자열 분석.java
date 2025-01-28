import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine()) != null){
            StringBuilder sb = new StringBuilder();
            char[] ch = str.toCharArray();
            int lowerCase = 0;
            int upperCase = 0;
            int number = 0;
            int blank = 0;
            for(char c : ch){
                if(c >= 'a' && c <= 'z'){
                    lowerCase++;
                }else if(c >= 'A' && c <= 'Z'){
                    upperCase++;
                }else if(c == ' '){
                    blank++;
                }else{
                    number++;
                }
            }
            sb.append(lowerCase).append(" ")
                    .append(upperCase).append(" ")
                    .append(number).append(" ")
                    .append(blank);
            System.out.println(sb);
        }
    }
}