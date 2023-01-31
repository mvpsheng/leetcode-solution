package secondTen;

/**
 * FileName: DeleteDuplicate
 * author: gxs
 * Date: 2021/9/25  20:43
 */
public class DeleteDuplicate {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int num :
                nums) {
            if (num != nums[index]) {
                nums[++index] = num;
            }
        }
        return index + 1;
    }

    public static void main(String[] args) {
        DeleteDuplicate deleteDuplicate = new DeleteDuplicate();
        int[] nums = new int[] {0,0,1,1,1,2,2,3,3,4};
        int n = deleteDuplicate.removeDuplicates(nums);
        System.out.println(n);
        for (int i = 0; i < n; i++) {
            System.out.print(" "+nums[i]);
        }
    }
}
