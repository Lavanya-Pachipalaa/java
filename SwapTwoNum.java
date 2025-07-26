class SwapTwoNum {
    static List<Integer> get(int a, int b) {
        // code here
        List<Integer> arr=new ArrayList<>();
        a=a^b;
        b=a^b;
        a=a^b;
        arr.add(a);
        arr.add(b);
        return arr;
    }
}