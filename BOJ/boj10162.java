import java.util.*;
public class boj10162{
    public static void main(String[] args) {
        int[] numArray = {300, 60, 10};
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        if(T % 10 == 0) {
            for(int i = 0; i < 3; i++){
                if(T % numArray[i] < T) {
                    int temp = numArray[i];
                    numArray[i] = T / numArray[i];
                    T = T % temp;
                }
                else numArray[i] = 0;
            }
            System.out.print(numArray[0] + " " + numArray[1] + " " + numArray[2]);
        }
        else
            System.out.println(-1);
    }
}