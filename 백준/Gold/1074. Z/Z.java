import java.util.*;
import java.io.*;
class Main{
    static int r, c;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2,N);
        recursive(size, 0, 0);

        System.out.println(count);
    }
    public static void recursive(int size, int x, int y){
        if(size == 1) return;
        int newSize = size/2;

        //왼쪽 위
        if(r < x + newSize && c < y + newSize){
            recursive(newSize, x, y);
        }

        //오른쪽 위
        if(r < x + newSize && c >= y + newSize){
            count += newSize * newSize;
            recursive(newSize, x, y+ newSize);
        }

        //왼쪽 아래
        if(r >= x + newSize && c < y + newSize){
            count += newSize * newSize * 2;
            recursive(newSize, x+newSize, y);
        }

        //오른쪽 아래
        if(r >= x + newSize && c >= y + newSize){
            count += newSize * newSize * 3;
            recursive(newSize, x+newSize, y+newSize);
        }
    }
}