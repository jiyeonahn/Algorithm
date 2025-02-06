import java.util.*;
import java.io.*;
class Main{
    static int[][] board;
    static int[] dx = {0, 1, 1, -1};
    static int[] dy = {1, 0, 1, 1};
    static int winner;
    static int locationX, locationY;
    public static int whoWin(int x, int y, int len, int dir) {

        int dx_x = x + dx[dir];
        int dy_y = y + dy[dir];

        if(dx_x >= 0 && dy_y >= 0 && dx_x < 19 && dy_y < 19 && board[dx_x][dy_y] == board[x][y]){
            return whoWin(dx_x, dy_y, len+1, dir);
        }
        return len;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[19][19];
        for(int i = 0; i < 19; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 19; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < 19; i++){
            for(int j = 0; j < 19; j++){
                if(board[i][j] > 0 && winner == 0){
                    for(int k = 0; k < 4; k++){
                        if (whoWin(i, j, 1, k) == 5) {
                            //반대반향 검사해서 육목 쳐내기
                            if(i-dx[k]>=0 && i-dx[k] < 19 && j-dy[k]>=0 && j-dy[k] < 19 && board[i][j] == board[i-dx[k]][j-dy[k]]){
                                continue;
                            }
                            winner = board[i][j];
                            locationX = i + 1;
                            locationY = j + 1;
                        }
                    }

                }
            }
        }
        System.out.println(winner);
        if( winner != 0 ){//25%
            System.out.println(locationX + " " + locationY);
        }
    }
}