public class TestDome {
    public static void main1(String[] args) {
        int x = 5;
        int mid = x/2;
        for (int i = 0; i < mid; i++) {
            for (int j = 0; j < mid-i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i+1; k++) {
                System.out.print("x ");
            }
            System.out.println();
        }
        for (int i = mid; i < x; i++) {
            for (int j = 0; j < i-mid; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < x-i; k++) {
                System.out.print("x ");
            }
            System.out.println();
        }
    }

}
