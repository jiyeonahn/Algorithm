import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        int index = pattern.indexOf("*");
        String start = pattern.substring(0, index);
        String end = pattern.substring(index+1);
        int startLen = start.length();
        int endLen = end.length();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            if(str.length() < startLen){
                sb.append("NE").append("\n");
                continue;
            }
            String newStr = str.substring(startLen);
            if(str.substring(0,startLen).equals(start) && newStr.length() >= endLen){
                if(newStr.substring(newStr.length() - endLen).equals(end)){
                    sb.append("DA").append("\n");
                }else{
                    sb.append("NE").append("\n");
                }
            }else{
                sb.append("NE").append("\n");
            }
        }

        System.out.println(sb);
    }
}