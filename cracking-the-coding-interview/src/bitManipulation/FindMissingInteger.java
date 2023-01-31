package bitManipulation;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * FileName: FindMissingInteger
 * author: gxs
 * Date: 2022/1/20  19:20
 */
/* An array A contains all the integers from 0 through n, except for one number which is
 * missing. In this problem, we cannot access an entire integer in A with a single operation.
 * The elements of A are represented in binary, and the only operation we can use to acces them
 * is "fetch the jth bit of A[i]," which takes constant time. Write code to find the missing
 * integer. Can you do it in O(n) time? */
public class FindMissingInteger {
    public int findMissing(ArrayList<BigInteger> array) {
        /* start from the least significant bit, and work our way up */
        return findMissing(array, 0);
    }

    public int findMissing(ArrayList<BigInteger> input, int column) {
        if (column >= BigInteger.ONE.bitLength()) {
            return 0;
        }

        ArrayList<BigInteger> oneBits = new ArrayList<>(input.size() / 2);
        ArrayList<BigInteger> zeroBits = new ArrayList<>(input.size() / 2);
//        for(BigInteger t : input) {
//            if(t.fetch(column) == 0) {
//                zeroBits.add(t);
//            }
//            else {
//                oneBits.add(t);
//            }
//        }
//        if(zeroBits.size() <= oneBits.size()) {
//            int v = findMissing(zeroBits, column + 1);
//            return (v << 1) | 0;
//        }
//        else {
//            int v = findMissing(oneBits, column + 1);
//            return (v << 1) | 1;
//        }
        return 0;
    }
}
