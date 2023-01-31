import java.awt.*;
import java.util.Scanner;

/**
 * @auther gxs
 * @create 2020-11-23-17:22
 */
public class TransposeMatrix {
    public static void main(String[] args) {
        int[] nums1 = {1,2}; int[] nums2 = {3,4};
        int[] nums3 = new int[nums1.length+nums2.length];
        int a = 0;
        int b = 0;
        int c = 0;
        while (a<nums1.length && b< nums2.length){
            if (nums1[a]<nums2[b])
            nums3[c++] = nums1[a++];
            else
                nums3[c++] = nums2[b++];
        }
        while (a<nums1.length){
            nums3[c++] = nums1[a++];
        }
        while (b<nums2.length){
            nums3[c++] = nums2[b++];
        }
        for (int i = 0; i < nums3.length; i++) {
            System.out.print(nums3[i]+" ");
        }
        if (nums3.length==0){
            System.out.println("0");
        }else if (nums3.length == 1){
            System.out.println(nums3[0]);
        }else if (nums3.length %2 ==0){
            System.out.println((nums3[nums3.length/2]+nums3[nums3.length/2-1])/2);
        }else if (nums3.length %2!=0){
            System.out.println(nums3[(nums3.length-1)/2]);
        }
    }
}
