import java.util.*;

public class XFromY {
    static final long BASE = 911382323;
    static final long MOD = 1_000_000_007;

    // Compute prefix hash
    static long[] prefixHash(String s) {
        int n = s.length();
        long[] hash = new long[n + 1];
        for (int i = 0; i < n; i++) {
            hash[i + 1] = (hash[i] * BASE + s.charAt(i)) % MOD;
        }
        return hash;
    }

    // Get substring hash
    static long getHash(long[] hash, long[] pow, int l, int r) {
        return (hash[r] - (hash[l] * pow[r - l]) % MOD + MOD) % MOD;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String X = sc.nextLine();
        String Y = sc.nextLine();
        int S = sc.nextInt();
        int R = sc.nextInt();

        int m = Y.length();

        // Precompute powers
        long[] pow = new long[m + 1];
        pow[0] = 1;
        for (int i = 1; i <= m; i++) pow[i] = (pow[i - 1] * BASE) % MOD;

        // Hash sets for Y and reversed Y
        HashSet<Long> hashSetY = new HashSet<>();
        HashSet<Long> hashSetRevY = new HashSet<>();

        // Prefix hashes
        long[] hashY = prefixHash(Y);
        String revYStr = new StringBuilder(Y).reverse().toString();
        long[] hashRevY = prefixHash(revYStr);

        // Store all substring hashes for Y
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j <= m; j++) {
                hashSetY.add(getHash(hashY, pow, i, j));
                hashSetRevY.add(getHash(hashRevY, pow, i, j));
            }
        }

        // DP for X
        int n = X.length();
        long[] hashX = prefixHash(X);
        long[] powX = new long[n + 1];
        powX[0] = 1;
        for (int i = 1; i <= n; i++) powX[i] = (powX[i - 1] * BASE) % MOD;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;
            for (int j = i + 1; j <= n; j++) {
                long h = getHash(hashX, powX, i, j);
                if (hashSetY.contains(h)) {
                    dp[j] = Math.min(dp[j], dp[i] + S);
                }
                if (hashSetRevY.contains(h)) {
                    dp[j] = Math.min(dp[j], dp[i] + R);
                }
            }
        }

        System.out.print(dp[n] == Integer.MAX_VALUE ? "Impossible" : dp[n]);
    }
}
