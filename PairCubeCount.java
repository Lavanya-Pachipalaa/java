class PairCubeCount {
    static int pairCubeCount(int n) {
        // code here
        int count=0;
        for(int i=1;i<=Math.cbrt(n);i++) {
            int cube=i*i*i;
            int diff=n-cube;
            int cubrtdiff=(int) Math.cbrt(diff);
            if(cubrtdiff*cubrtdiff*cubrtdiff == diff)
              count++;
        }
        return count;
    }
};