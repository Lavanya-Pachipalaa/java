import java.util.*;
public class BoardGameSolver{
 static class State {
  int x, y, moves;
  State(int x, int y, int moves) {
  this.x = x; 
  this.y = y; 
  this.moves = moves;
  }
 }
 public static int minMoves(int[][] grid, int[] src, int[] dst, int[] moveRule) {
 int M = grid.length, N = grid[0].length;
 boolean[][] visited = new boolean[M][N];
 int[][] directions= {
 {moveRule[0], moveRule[1]},
 {moveRule[1], -moveRule[0]},
 {-moveRule[1], moveRule[0]},
 {-moveRule[0], -moveRule[1]},
 };
 Queue<State> queue = new LinkedList<>();
 queue.add(new State(src[0], src[1], 0));
 visited[src[0]][src[1]] = true;
 while (!queue.isEmpty()) {
  State curr = queue.poll();
  if (curr.x == dst[0] && curr.y == dst[1]) return curr.moves;
  for (int[] dir : directions){
   int nx = curr.x + dir[0], ny = curr.y + dir[1];
   if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny] && grid[nx][ny] == 0) {
     visited[nx][ny] = true;
     queue.add(new State(nx, ny, curr.moves + 1));
    }
  }
 }
 return -1;
}
public static void main(String[] args){
  Scanner sc = new Scanner(System.in);
  int M = sc.nextInt(), N = sc.nextInt();
  int[][] grid = new int[M][N];
  for (int i = 0; i < M; i++)
    for (int j = 0; j < N; j++)
       grid[i][j] = sc.nextInt();
  int[] src = { sc.nextInt(), sc.nextInt() };
  int[] dst = { sc.nextInt(), sc.nextInt() };
  int[] moveRule = { sc.nextInt(), sc.nextInt() };
  System.out.print(minMoves(grid, src, dst, moveRule));
 }
}