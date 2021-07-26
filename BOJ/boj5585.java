import java.util.Scanner;

public class boj5585 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int count = 0;

        T = 1000 - T;

        while(T > 0) {
            if(T >= 500) {
                count += T / 500;
                T = T % 500;
            }
            else if(T >= 100) {
                count += T / 100;
                T = T % 100;
            }
            else if(T >= 50) {
                count += T / 50;
                T = T % 50;
            }
            else if(T >= 10) {
                count += T / 10;
                T = T % 10;
            }
            else if(T >= 5) {
                count += T / 5;
                T = T % 5;
            }
            else if(T >= 1) {
                count += T / 1;
                T = T % 1;
            }
        }

        System.out.println(count);
    }
}
