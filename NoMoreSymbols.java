import java.util.*;

public class NoMoreSymbols {
    private static final Map<String, String> DIGIT_MAP = new HashMap<>();
    private static final Set<String> OPERATIONS = new HashSet<>(Arrays.asList("add", "sub", "mul", "div", "rem", "pow"));

    static {
        DIGIT_MAP.put("zero", "0");
        DIGIT_MAP.put("one", "1");
        DIGIT_MAP.put("two", "2");
        DIGIT_MAP.put("three", "3");
        DIGIT_MAP.put("four", "4");
        DIGIT_MAP.put("five", "5");
        DIGIT_MAP.put("six", "6");
        DIGIT_MAP.put("seven", "7");
        DIGIT_MAP.put("eight", "8");
        DIGIT_MAP.put("nine", "9");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();
        System.out.print(process(input));
    }

    private static String process(String input) {
        String[] tokens = input.split(" ");

        // Validate tokens
        for (String token : tokens) {
            if (!OPERATIONS.contains(token) && !isValidNumberWord(token)) {
                return "expression evaluation stopped invalid words present";
            }
        }

        // Parse into operations/numbers
        List<Object> parsed = new ArrayList<>();
        for (String token : tokens) {
            if (OPERATIONS.contains(token)) parsed.add(token);
            else parsed.add(convertWordToNumber(token));
        }

        try {
            int result = evaluate(parsed);
            return String.valueOf(result);
        } catch (Exception e) {
            return "expression is not complete or invalid";
        }
    }

    // Validate number word (allow 'c' as separator)
    private static boolean isValidNumberWord(String word) {
        String cleaned = word.replace("c", ""); // remove 'c' separators
        int i = 0;
        while (i < cleaned.length()) {
            boolean matched = false;
            for (String key : DIGIT_MAP.keySet()) {
                if (cleaned.startsWith(key, i)) {
                    i += key.length();
                    matched = true;
                    break;
                }
            }
            if (!matched) return false;
        }
        return true;
    }

    // Convert word to number (remove 'c' and map digits)
    private static int convertWordToNumber(String word) {
        String cleaned = word.replace("c", "");
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < cleaned.length()) {
            for (String key : DIGIT_MAP.keySet()) {
                if (cleaned.startsWith(key, i)) {
                    sb.append(DIGIT_MAP.get(key));
                    i += key.length();
                    break;
                }
            }
        }
        return Integer.parseInt(sb.toString());
    }

    // Evaluate expressions with 3, 5, or 7 tokens
    private static int evaluate(List<Object> parsed) {
        int size = parsed.size();

        if (size == 3) {
            return apply((String) parsed.get(0), (Integer) parsed.get(1), (Integer) parsed.get(2));
        } else if (size == 5) {
            // Pattern: Op1 Op2 Num Num Num
            if (parsed.get(0) instanceof String && parsed.get(1) instanceof String) {
                int temp = apply((String) parsed.get(1), (Integer) parsed.get(2), (Integer) parsed.get(3));
                return apply((String) parsed.get(0), temp, (Integer) parsed.get(4));
            }
            // Pattern: Op1 Num Op2 Num Num
            else if (parsed.get(0) instanceof String && parsed.get(2) instanceof String) {
                int temp = apply((String) parsed.get(2), (Integer) parsed.get(3), (Integer) parsed.get(4));
                return apply((String) parsed.get(0), (Integer) parsed.get(1), temp);
            }
        } else if (size == 7) {
            // Pattern: Op1 Op2 Op3 Num Num Num Num
            if (parsed.get(0) instanceof String && parsed.get(1) instanceof String && parsed.get(2) instanceof String) {
                int res1 = apply((String) parsed.get(2), (Integer) parsed.get(3), (Integer) parsed.get(4));
                int res2 = apply((String) parsed.get(1), res1, (Integer) parsed.get(5));
                return apply((String) parsed.get(0), res2, (Integer) parsed.get(6));
            }
        }

        throw new RuntimeException(); // invalid structure
    }

    private static int apply(String op, int a, int b) {
        switch (op) {
            case "add": return a + b;
            case "sub": return a - b;
            case "mul": return a * b;
            case "div": return a / b;
            case "rem": return a % b;
            case "pow": return (int) Math.pow(a, b);
            default: throw new RuntimeException();
        }
    }
}
