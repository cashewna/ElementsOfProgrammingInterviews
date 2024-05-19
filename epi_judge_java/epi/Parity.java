package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class Parity {
  @EpiTest(testDataFile = "parity.tsv")
  public static short parity(long x) {
    // time complexity = O(n)
    //    short result = 0;
    //    while (x != 0) {
    //      result ^= (short) (x & 1);
    //      x = x >> 1;
    //    }
    //    return result;

    // time complexity = O(k) where k is the number of bits set to 1
//    short result = 0;
//    while (x != 0) {
//      result ^= 1;
//      x &= (x - 1); // drops the lowest set bit of x
//    }
//    return result;

    // time complexity = O(log n)
    x ^= x >>> 32;
    x ^= x >>> 16;
    x ^= x >>> 8;
    x ^= x >>> 4;
    x ^= x >>> 2;
    x ^= x >>> 1;
    return (short)(x & 0x1);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest.runFromAnnotations(
                args, "Parity.java", new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
