import java.util.Scanner;

public class Algorithm {
    public static void main(String[] args) {
        //x=2(mod 5), a1=2, m1=5
        //x=15(mod 17), a2=15, m1=17
        //x=5(mod 12), a3=5, m3=12

        System.out.print("Введите число уравнений в системе: ");
        Scanner in = new Scanner(System.in);

        int numberEquations = in.nextInt();

        System.out.println("Вводите а1, а2...аn через enter (x = a1 (mod m1)): ");
        int[] numsA = fillingArray(numberEquations);

        System.out.println("Вводите m1, m2...mn через enter (x = a1 (mod m1))" +
                "m1, m2...mn - простые числа: ");
        int[] numsM = fillingArray(numberEquations);

        findX(numberEquations, numsA, numsM);
    }

    private static int[] fillingArray(int quantity) {
        Scanner in = new Scanner(System.in);
        int[] nums = new int[quantity];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = in.nextInt();
        }
        return nums;
    }

    private static void findX(int numEq, int[] numsA, int[] numsM) {
        int multM = 1;
        for (int m = 0; m < numEq; m++) {
            multM *= numsM[m];
        }

        int[] Mn = new int[numEq];
        for (int i = 0; i < numEq; i++) {
            Mn[i] = multM / numsM[i];
        }

        int[] Yn = new int[numEq];
        for (int i = 0; i < numEq; i++) {
            int mi = Mn[i];
            int mn = numsM[i];
            for (int j = 1; j < mn; j++) {
               if ((mi * j - 1) % mn == 0) {
                    Yn[i] = j;
                    break;
               }
            }
        }

        int x = 0;
        for (int i = 0; i < numEq; i ++)
            x += (numsA[i] * Mn[i] * Yn[i]);
        x = x % multM;
        System.out.println(x + " profit");
    }
}
