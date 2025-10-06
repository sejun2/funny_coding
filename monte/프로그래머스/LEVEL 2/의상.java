import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int result = 1;

		Map<String, Integer> counts = new HashMap<>();

		for(int i = 0; i < clothes.length; i++){
			counts.put(clothes[i][1], counts.getOrDefault(clothes[i][1], 0) + 1);
		}

		for(int count : counts.values()){
			result *= (count + 1);
		}

		return result - 1;
    }
}
