import java.util.Scanner;

public class boj2839{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int count = 0;
        int count1 = 0;
        int temp = T;

        if ((T % 5) % 3 == 0) {
            count += T / 5;
            T = T % 5;

            count += T / 3;
        } else if ((T % 3) % 5 == 0) {
            count += T / 3;
            T = T % 3;

            count += T / 5;
        }

        while (true) {
            count1++;
            temp = temp - 3;
            if(temp <= 0){
                count1 = 0;
                break;
            }
            else if (temp % 5 == 0) {
                count1 += temp / 5;
                break;
            }
        }

        if(count == 0 && count1 == 0)
            System.out.println(-1);
        else if(count != 0 && count1 != 0)
            System.out.println(Math.min(count1, count));
        else if(count == 0 && count1 != 0)
            System.out.println(count1);
        else
            System.out.println(count);
    }
    }
