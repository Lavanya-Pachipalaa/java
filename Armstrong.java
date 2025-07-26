class Armstrong {

    public static boolean armstrong(int n) {
        // converting to string
        String number = Integer.toString(n);

        int length = number.length();
        int output = 0;

        for (char c : number.toCharArray()) {
            output += (int) Math.pow(c - '0', length);
        }

        // check if equal to number
        if (output == Integer.parseInt(number))
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        int n = 153;
        if (armstrong(n)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}