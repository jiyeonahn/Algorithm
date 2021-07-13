class Solution {
    public int solution(int[] numbers, int target) {

        return dfs(numbers, target, 0, 0);
    }

    public int dfs(int[] numbers, int target, int level, int sum){
        if(level == numbers.length){
            if(sum == target)
                return 1;
            return 0;
        }
        else return dfs(numbers, target, level + 1, sum + numbers[level]) + dfs(numbers, target, level + 1, sum - numbers[level]);
    }
}