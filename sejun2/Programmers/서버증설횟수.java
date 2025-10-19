package Programmers;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/389479?language=java
 */
class 서버증설횟수 {

    public int solution(int[] players, int m, int k) {
        int answer = 0;
        List<Server> serverPool = new ArrayList<>();

        for(int currentTime = 0; currentTime < players.length; currentTime++){
            int time = currentTime;

            // 만료된 서버 제거
            serverPool.removeIf(server -> server.endTime <= time);

            int currentUser = players[currentTime];

            // 플레이어가 m 미만이면 서버 불필요
            if(currentUser < m) {
                continue;
            }

            // 현재 서버 풀로 수용 가능한 인원 계산
            int capacity = serverPool.size() * m;

            // 필요한 서버 수 계산
            int requiredServers = (currentUser ) / m;
            int currentServers = serverPool.size();

            // 부족한 만큼 서버 추가
            if(requiredServers > currentServers) {
                int need = requiredServers - currentServers;
                for(int i = 0; i < need; i++) {
                    serverPool.add(new Server(currentTime + k));
                    answer++;
                }
            }
        }

        return answer;
    }
}

class Server {
    int endTime;

    Server(int endTime){
        this.endTime = endTime;
    }
}
