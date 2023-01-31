package aboveOneHundred;


/**
 * FileName: MajorityElement
 * author: gxs
 * Date: 2021/9/17  23:02
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num :
                nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        int[] nums = {0,0,1,1,1,1,1,0,0};
        System.out.println(majorityElement.majorityElement(nums));
    }
}
