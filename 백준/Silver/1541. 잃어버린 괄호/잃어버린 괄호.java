import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String[] num = str.split("-");

        int sum = 0;
        int init = 0;
        String[] plus;
        plus = num[0].split("\\+");
        for(String p : plus){
            init += Integer.parseInt(p);
        }
        for(int i = 1; i < num.length; i++){
            plus = num[i].split("\\+");

            for (String p : plus) {
                sum += Integer.parseInt(p);
            }

        }
        System.out.println(init - sum);
    }
}