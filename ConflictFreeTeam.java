import java.util.*;
public class ConflictFreeTeam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        List<Integer>[] conflicts = new List[n];
        for (int i = 0; i < n; i++) conflicts[i] = new ArrayList<>();
        for (int i = 0; i < c; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            conflicts[a].add(b);
            conflicts[b].add(a);
        }
        int[] expertise = new int[n];
        for (int i = 0; i < n; i++) expertise[i] = sc.nextInt();
        boolean[] visited = new boolean[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                Queue<Integer> queue = new LinkedList<>();
                visited[i] = true;
                queue.add(i);
                while (!queue.isEmpty()) {
                    int u = queue.poll();
                    component.add(u);
                    for (int v : conflicts[u]) {
                        if (!visited[v]) {
                            visited[v] = true;
                            queue.add(v);
                        }
                    }
                }
                int size = component.size();
                if (size <= 24) {
                    // Use bitmask DP
                    Map<Integer, Integer> idxMap = new HashMap<>();
                    for (int j = 0; j < size; j++) idxMap.put(component.get(j), j);
                    // Build adjacency mask for each node
                    int[] adjMask = new int[size];
                    for (int j = 0; j < size; j++) {
                        int u = component.get(j);
                        int mask = 0;
                        for (int v : conflicts[u]) {
                            if (idxMap.containsKey(v)) mask |= (1 << idxMap.get(v));
                        }
                        adjMask[j] = mask;
                    }
                    int max = 0;
                    int all = 1 << size;
                    for (int mask = 0; mask < all; mask++) {
                        boolean valid = true;
                        int sum = 0;
                        for (int j = 0; j < size; j++) {
                            if (((mask >> j) & 1) == 1) {
                                // If any neighbor is also included, invalid
                                if ((mask & adjMask[j]) != 0) {
                                    valid = false;
                                    break;
                                }
                                sum += expertise[component.get(j)];
                            }
                        }
                        if (valid && sum > max) max = sum;
                    }
                    result += max;
                } else if (isTree(component, conflicts)) {
                    // DP on tree
                    int root = component.get(0);
                    int[] dp0 = new int[n]; // exclude
                    int[] dp1 = new int[n]; // include
                    Arrays.fill(visited, false);
                    treeDP(root, -1, conflicts, expertise, visited, dp0, dp1);
                    result += Math.max(dp0[root], dp1[root]);
                } else {
                    int max = 0;
                    for (int u : component) max = Math.max(max, expertise[u]);
                    result += max;
                }
            }
        }
        System.out.print(result);
    }
    static void treeDP(int u, int parent, List<Integer>[] conflicts, int[] expertise, boolean[] visited, int[] dp0, int[] dp1) {
        visited[u] = true;
        dp0[u] = 0;
        dp1[u] = expertise[u];
        for (int v : conflicts[u]) {
            if (v != parent && !visited[v]) {
                treeDP(v, u, conflicts, expertise, visited, dp0, dp1);
                dp0[u] += Math.max(dp0[v], dp1[v]);
                dp1[u] += dp0[v];
            }
        }
    }
    static boolean isTree(List<Integer> component, List<Integer>[] conflicts) {
        int n = component.size();
        int edgeCount = 0;
        for (int u : component) edgeCount += conflicts[u].size();
        edgeCount /= 2;
        return edgeCount == n - 1;
    }
}