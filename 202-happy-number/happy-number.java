class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            int sum = 0;
            while (n != 0) {
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            n = sum;
        }
        return n==1;
    }
}