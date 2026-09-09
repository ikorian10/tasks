public class Task1 {
    public static void main(String[] args) {
        int x1 = Integer.parseInt(args[0]);
        int x2 = Integer.parseInt(args[1]);
        int x3 = Integer.parseInt(args[2]);
        int x4 = Integer.parseInt(args[3]);
        System.out.println(getPath(x1, x2).append(getPath(x3, x4)));
    }

    public static StringBuilder getPath(int n, int m) {
        StringBuilder result = new StringBuilder();
        int value = 1;
        do {
            result.append(value);
            value = (value + m - 2) % n + 1;
        } while (value != 1);
        return result;
    }
}
