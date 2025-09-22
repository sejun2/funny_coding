package Programmers;

class Solution {

    int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(0, numbers, target,0);

        return answer;
    }

    void dfs(int index, int[] numbers, int target, int current){
        if(index == numbers.length) {
            if(current == target) answer++;
            return;
        }

        dfs(index + 1, numbers, target, current + numbers[index]);
        dfs(index + 1, numbers, target, current - numbers[index]);
    }
}