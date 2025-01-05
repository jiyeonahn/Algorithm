import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = str.length() / 10; //몫
        int m = str.length() % 10; //나머지

        for(int i = 0; i < n; i++){
            System.out.println(str.substring(i*10,i*10+10));
        }
        if(m > 0){
            System.out.println(str.substring(n*10));
        }
    }
}