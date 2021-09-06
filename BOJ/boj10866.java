import java.io.*;
import java.util.StringTokenizer;

class Deque{
    private int front;
    private int back;
    private int dequeArr[];
    private int size;

    public Deque(){
        this.dequeArr = new int[10000];
        this.front = 0;
        this.back = 0;
        this.size = 0;
    }

    public void push_front(int n){
        this.dequeArr[front] = n;
        this.front = (front - 1 + 10000) % 10000;
        size++;
    }

    public void push_back(int n){
        this.back = (back + 1) % 10000;
        this.dequeArr[back] = n;
        size++;
    }

    public int pop_front(){
        if(size == 0) return -1;
        int temp = (front + 1) % 10000;;
        this.front = (front + 1) % 10000;
        size--;
        return dequeArr[temp];
    }

    public int pop_back(){
        if(size == 0) return -1;
        int temp = back;
        this.back = (back - 1 + 10000) % 10000;
        size--;
        return dequeArr[temp];
    }

    public int size(){
        return size;
    }
    public int empty(){
        if(size == 0) return 1;
        return 0;
    }
    public int front(){
        if(size == 0) return -1;
        return dequeArr[(front + 1) % 10000];
    }

    public int back(){
        if(size == 0) return -1;
        return dequeArr[back];
    }

}

public class boj10866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        Deque deque = new Deque();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine()," ");
            switch (st.nextToken()){
                case "push_front":
                    deque.push_front(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.push_back(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    sb.append(deque.pop_front() + "\n");
                    break;
                case "pop_back":
                    sb.append(deque.pop_back() + "\n");
                    break;
                case "size":
                    sb.append(deque.size() + "\n");
                    break;
                case "empty":
                    sb.append(deque.empty() + "\n");
                    break;
                case "front":
                    sb.append(deque.front() + "\n");
                    break;
                case "back":
                    sb.append(deque.back() + "\n");
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
