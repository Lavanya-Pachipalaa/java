public class HexaDecimal {

    public String str;

    public HexaDecimal(String str) {
        this.str = str;
    }

    public boolean isHexadecimalChar(char ch) {
        // Write your code here
        if ((ch >= 'a' && ch <= 'f') || (ch >= 'A' && ch <= 'F')) {
            return true;
        } else
            return false;
    }

    public boolean isHexadecimal() {
        // Write your code here
        if (str == null || str.length() == 0)
            return false;
        else {
            char[] ch = str.toCharArray();
            for (char c : ch) {
                if (!Character.isDigit(c) && !isHexadecimalChar(c))
                    return false;

            }
            return true;

        }

    }

}