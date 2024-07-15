class Solution {
    public String solution(String polynomial) {
        int sum = 0;
        int xSum = 0;
        String[] arr = polynomial.split(" ");
        
        for(String p : arr){
            if("+".equals(p)) continue;
            if(!p.contains("x")){
                sum += Integer.parseInt(p);
            }else{
                xSum += Integer.parseInt(p.replace("x","").equals("") ? "1" : p.replace("x",""));
            }
        }
        
        if(xSum == 0){
            return String.valueOf(sum);
        }else if(sum == 0){
            if(xSum == 1) return "x";
            return xSum + "x";
        }else{
            if(xSum == 1) return "x + " + sum;
             return xSum + "x + " + sum;
        }
    }
}