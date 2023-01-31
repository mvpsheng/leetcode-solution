package recursionanddynamicprogramming;

import java.util.ArrayList;

/**
 * FileName: AllSubsets
 * author: gxs
 * Date: 2022/1/22  14:22
 */
/* write a method to return all subsets of a set */
public class AllSubsets {
    ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allSubsets;
        if (set.size() == index) {
            allSubsets = new ArrayList<ArrayList<Integer>>();
            allSubsets.add(new ArrayList<>());
        } else {
            allSubsets = getSubsets(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moreSubsets =
                    new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> subset: allSubsets) {
                ArrayList<Integer> newSubset = new ArrayList<Integer>();
                newSubset.addAll(subset);
                newSubset.add(item);
                moreSubsets.add(newSubset);
            }
            allSubsets.addAll(moreSubsets);
        }
        return allSubsets;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        System.out.println(new AllSubsets().getSubsets(nums, 0));
    }
}

