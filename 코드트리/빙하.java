import java.util.*;

public class Main {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};

    static int n, m;
    static int[][] grid;
    static boolean[][] visited;
    static int time = 0;
    static int size = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        
        Point startPoint = new Point(0, 0);
        while(isIceLeft()){
            time++;
            meltDown(startPoint);
        }

        System.out.print(time + " " + size);
    }

    static void meltDown(Point startPoint){
        visited = new boolean[n][m];
        Queue<Point> queue = new LinkedList<>();
        size = 0;

        visited[startPoint.x][startPoint.y] = true;
        queue.offer(startPoint);

        while(!queue.isEmpty()){
            Point point = queue.poll();
            for(int dir = 0; dir < 4; dir++){
                int nx = point.x + dx[dir];
                int ny = point.y + dy[dir];

                if(!isInBoundary(nx, ny)) continue;
                if(grid[nx][ny] == 1) continue;
                if(visited[nx][ny]) continue;

                visited[nx][ny] = true;
                queue.offer(new Point(nx, ny));
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int dir = 0; dir < 4; dir++){
                    int nx = i + dx[dir];
                    int ny = j + dy[dir];
                    if(isInBoundary(nx, ny) && visited[i][j] && grid[nx][ny] == 1){
                        size++;
                        grid[nx][ny] = 0;
                    }
                }
            }
        }
    }

    static boolean isInBoundary(int x, int y){
        if(x < 0 || x >= n || y < 0 || y >= m) return false;
        return true;
    }

    static boolean isIceLeft(){
        boolean iceLeft = false;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    iceLeft = true;
                    break;
                }
            }
        }

        return iceLeft;
    }
}

class Point{
    int x, y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
