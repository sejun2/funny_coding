package BaekJoon; /// 백준 2606 - 바이러스
/// [https://www.acmicpc.net/problem/2606]

import java.io.*;
import java.util.*;

class Sol2606 {
    static void main(String[] args) throws IOException {
        // 1. DFS
        Solution.dfsSolution();

        // 2. BFS
        Solution.bfsSolution();
    }

    static class Solution {

        static void dfsSolution() throws IOException {
            boolean[][] graph;
            boolean[] visited;

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int n, v;

            n = Integer.parseInt(br.readLine());
            v = Integer.parseInt(br.readLine());

            visited = new boolean[n + 1];

            // 그래프 초기화
            // 1부터 시작하므로 n+1
            graph = new boolean[n + 1][n + 1];
            for (int i = 0; i < v; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[x][y] = true;
                graph[y][x] = true;
            }

            dfs(1, graph, visited, n);

            int answer = 0;

            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) answer++;
            }

            // 시작 노드는 제외하므로 answer - 1
            bw.write(String.valueOf(answer - 1));

            br.close();
            bw.close();
        }

        static void bfsSolution() throws IOException {
            boolean[][] graph;
            boolean[] visited;

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int n, v;

            n = Integer.parseInt(br.readLine());
            v = Integer.parseInt(br.readLine());

            visited = new boolean[n + 1];

            // 그래프 초기화
            // 1부터 시작하므로 n+1
            graph = new boolean[n + 1][n + 1];
            for (int i = 0; i < v; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[x][y] = true;
                graph[y][x] = true;
            }

            bfs(1, graph, visited, n);

            int answer = 0;

            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) answer++;
            }

            // 시작 노드는 제외하므로 answer - 1
            bw.write(String.valueOf(answer - 1));

            br.close();
            bw.close();
        }

        static void dfs(int index, boolean[][] graph, boolean[] visited, int n) {
            visited[index] = true;

            // 1 부터 n 까지이므로
            for (int i = 1; i <= n; i++) {
                if (visited[i] == true) continue;

                if (graph[index][i] == true) {
                    dfs(i, graph, visited, n);
                }
            }
        }

        static void bfs(int index, boolean[][] graph, boolean[] visited, int n) {
            Queue<Integer> q = new LinkedList<>();
            q.add(index);
            visited[index] = true;

            while (!q.isEmpty()) {
                int polled = q.poll();

                for (int i = 1; i <= n; i++) {
                    if (visited[i] == true) continue;

                    if (graph[polled][i] == true) {
                        visited[i] = true;
                        q.add(i);
                    }
                }
            }
        }
    }
}