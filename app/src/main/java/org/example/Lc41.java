package org.example;

public class Lc41 {
    public static int firstMissingPositive(int[] nums) {

        int l = nums.length;

        int tmp = -1;
        for (int i = 0; i < l; i++) {
            int n = nums[i];
            while (tmp != -1) {
                if (tmp <= 0 || tmp > l) {
                    tmp = -1;
                    break;
                }

                System.out.println(tmp);
                System.out.println("-<<");
                if (nums[tmp - 1] == tmp) {
                    tmp = -1;
                    break;
                }

                System.out.println(tmp);
                System.out.println("-??");
                int a = nums[tmp - 1];
                System.out.println(a);
                nums[tmp - 1] = tmp;
                tmp = a;
                System.out.println(a);
            }

            if (nums[i] == i + 1) continue;

            if (nums[i] <= 0 || nums[i] > l) continue;

            tmp = n;

            System.out.println(tmp);
            System.out.println("--------");
            nums[i] = -1;
        }

        System.out.println(tmp);

        while (tmp != -1) {
            if (tmp <= 0 || tmp > l) {
                tmp = -1;
                break;
            }

            if (nums[tmp - 1] == tmp) {
                tmp = -1;
                break;
            }

            int a = nums[tmp - 1];
            nums[tmp - 1] = tmp;
            tmp = a;
        }

        String r = "";
        for (int n : nums) r += " " + String.valueOf(n);
        System.out.println(r);
        for (int i = 0; i < l; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return l + 1;
     }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 0};
        System.out.println(firstMissingPositive(nums));
    }

    public void use() {
        int a = 0;
        return;
    }
}
