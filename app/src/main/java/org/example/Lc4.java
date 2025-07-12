package org.example;

public class Lc4 {
    public static void showList(int[] nums){
        for(int n :nums){
            System.out.print("," + n);

        }
        System.out.println(" ");
    }
    public static double  findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l =  nums1.length + nums2.length;
        if (l%2 == 1){
            return helper(l/2,nums1,nums2);
        }

        System.out.println(l);

        double n1 = helper(l/2-1,nums1,nums2);
        System.out.println("n1 "+ n1);
        double n2 = helper(l/2,nums1,nums2);
        System.out.println("n1: "+n2);
        System.out.println("final " + (n1+n2)/2.0);
        return (n1+n2)/2.0;
    };

    public static double helper(int ind, int[] nums1, int[] nums2) {
        System.out.println("------------");
        System.out.println(ind);
        showList(nums1);
        showList(nums2);
        System.out.println("------------/");

        if(nums1.length == 0) {
            return (double) nums2[ind];
        }

        if (nums2.length == 0) {
            return (double) nums1[ind];
        }

        if (ind <= 0) {
            return Math.min(nums1[0], nums2[0]);
        }

        if (nums1[nums1.length-1] < nums2[0]) {
            if (ind < nums1.length) return (double) nums1[ind];

            return nums2[ind - nums1.length];
        }

        if (nums2[nums2.length-1] < nums1[0]) {
            return helper(ind,nums2,nums1);
        }

        // Notice 这题关键就是这句，要记住最多 只能拿 ind/2 ，因为如果一次比完肯定是不行的，因为不能保证整体的数都在需要的范围内
        int ind1 = Math.max(0,Math.min((nums1.length)/2-1,ind/2));
        int ind2 = Math.max(0,Math.min(nums2.length/2-1,ind/2));


        if (nums1[ind1] < nums2[ind2]){
            if (ind1 == 0) {
                ind1++;
            }

            int[] nn1 = new int[nums1.length-ind1];
            System.arraycopy(nums1,ind1,nn1,0,nn1.length);

            return helper(ind-ind1,nn1 ,nums2);

        }
        if (ind2 == 0) {
            ind2++;
        }

        int[] nn2 = new int[nums2.length-ind2];
        System.arraycopy(nums2,ind2,nn2,0,nn2.length);

        return helper(ind-ind2,nums1 ,nn2);
    }

    public static void main(String[] args){
        int[] nums1 = {1,3};
        int[] nums2 = {2,4,5,6,7,8};

        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

}
