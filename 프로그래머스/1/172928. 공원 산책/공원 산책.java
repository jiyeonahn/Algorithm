class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        
        char[][] map = new char[park.length][park[0].length()];
        
        for(int i = 0; i < park.length; i++){
            map[i] = park[i].toCharArray();
        }
        
        int x = 0;
        int y = 0;
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                if(map[i][j] == 'S'){
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        
        for(int i = 0; i < routes.length; i++){
            String[] route = routes[i].split(" ");
            int[] dx = {0, 0, 1, -1};
            int[] dy = {1, -1, 0, 0};
            
            int idx = 0;
            
            if("E".equals(route[0])){
                idx = 0;
            }
            if("W".equals(route[0])){
                idx = 1;
            }
            if("S".equals(route[0])){
                idx = 2;
            }
            if("N".equals(route[0])){
                idx = 3;
            }
            
            boolean moveOk = true;
            int repeat = Integer.parseInt(route[1]);
            for(int j = 1; j <= repeat; j++){
                int nx = x + dx[idx] * j;
                int ny = y + dy[idx] * j;
                if(nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length || map[nx][ny] == 'X'){
                    moveOk = false;
                    break;
                }
            }
            
            if(!moveOk) continue;
            
            x += dx[idx] * Integer.parseInt(route[1]);
            y += dy[idx] * Integer.parseInt(route[1]);
            
        }
        
        return new int[]{x,y};
    }
}