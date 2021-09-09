import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Double> stack = new Stack<>();
        String str = br.readLine();

        double result = 0;

        Double[] numArr = new Double[N];
        for(int i = 0; i < N; i++)
            numArr[i] = Double.parseDouble(br.readLine());

        double n1,n2;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                stack.push(numArr[str.charAt(i) - 'A']);
                continue;
            }
            n2 = stack.pop();
            n1 = stack.pop();
            switch (str.charAt(i)){
                case '*':
                    result = n1 * n2;
                    break;
                case '+':
                    result = n1 + n2;
                    break;
                case '/':
                    result = n1 / n2;
                    break;
                case '-':
                    result = n1 - n2;
                    break;
            }
            stack.push(result);
        }

        System.out.printf("%.2f",result);
    }
}
