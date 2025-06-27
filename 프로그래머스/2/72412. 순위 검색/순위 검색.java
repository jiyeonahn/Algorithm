import java.util.*;
class Solution {
    HashMap<String, ArrayList<Integer>> map = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        for(int i = 0; i < info.length; i++){
            String[] str = info[i].split(" ");
            dfs(str, "", 0);
        }
        
        for(String key : map.keySet()){
            Collections.sort(map.get(key));
        }
        
        for(int i = 0; i < query.length; i++){
            String q = query[i].replace(" and ", "");
            String[] arr = q.split(" ");
            answer[i] = 0;
            if(map.containsKey(arr[0])){
                answer[i] = binarySearch(map.get(arr[0]), Integer.parseInt(arr[1]));
            }
        }
        
        return answer;
    }
    public int binarySearch(ArrayList<Integer> arr, int target){
        int low = 0;
        int high = arr.size()-1;
        int result = 0;
        
        while(low <= high){
            int mid = (low+high)/2;
            
            if(arr.get(mid) < target){
                low = mid + 1;
            }else{
                high = mid - 1;
                result = mid;
            }
        }
        
        return arr.size() - low;
    }
    public void dfs(String[] infoStr, String result, int idx){
        if(idx == 4){
            int score = Integer.parseInt(infoStr[4]);
            if(map.containsKey(result)){
                map.get(result).add(score);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(score);
                map.put(result,list);
            }
            
            return;
        }
        dfs(infoStr, result+infoStr[idx], idx+1);
        dfs(infoStr, result+"-", idx+1);
    }
}