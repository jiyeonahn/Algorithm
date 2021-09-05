import java.io.*;

class Queue{
    private int tail;
    private int head;
    private int queueArr[];

    public Queue(int size){
        this.queueArr = new int[size];
        this.head = 0;
        this.tail = -1;
    }

    public void push(int n){
        this.queueArr[++tail] = n;
    }

    public int pop(){
        if(head > tail) return -1;
        return this.queueArr[head++];
    }

    public int size(){
        return tail - head + 1;
    }

    public int empty(){
        if(head > tail) return 1;
        return 0;
    }

    public int front(){
        if(head > tail) return -1;
        return this.queueArr[head];
    }

    public int back(){
        if(head > tail) return -1;
        return this.queueArr[tail];
    }

}
public class boj10845 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Queue queue = new Queue(N);

        String cmd;
        for(int i = 0; i < N; i++){
            cmd = br.readLine();
            if(cmd.length() >= 6)
                queue.push(Integer.parseInt(cmd.substring(5)));
            else if(cmd.equals("pop")){
                bw.write(queue.pop() + "\n");
            }
            else if(cmd.equals("size")){
                bw.write(queue.size() + "\n");
            }
            else if(cmd.equals("empty")){
                bw.write(queue.empty() + "\n");
            }
            else if(cmd.equals("front")){
                bw.write(queue.front() + "\n");
            }
            else if(cmd.equals("back")){
                bw.write(queue.back() + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
