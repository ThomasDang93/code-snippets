public class ReverseInteger {
    public static void main(String[] args) {
        int x = -1534236000;
        System.out.println(reverse(x));
    }

    public static int reverse(int x) {
        StringBuilder sb = new StringBuilder();
        if (x == 0)
                return x;

        try {
            if (x > 0) {
                while (x > 0) {
                    sb.append(x % 10);
                    x = x / 10;
                }
                String string = sb.toString();
                return Integer.parseInt(string);
            } else {
                x = Math.abs(x);
                while (x > 0) {
                    sb.append(x % 10);
                    x = x / 10;
                }
                String string = sb.toString();
                return -1 * Integer.parseInt(string);
            }
        } catch (NumberFormatException nfe) {
            return 0;
        }
    }
}
