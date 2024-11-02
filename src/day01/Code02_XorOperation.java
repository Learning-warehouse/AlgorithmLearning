package day01;

/**
 * 在一个数组中，整形数组，已知一种数出现了奇数次，其他都是偶数次，找到这个数。
 * 要求时间复杂度O(n)，空间复杂度O(1)。
 * 异或原理:
 * 1.交换律
 */
public class Code02_XorOperation {
    /**
     * 利用异或操作，将数组中所有数进行异或操作，得到的结果就是出现奇数次的数。
     * 因为异或操作满足交换律，所以两个数异或之后再异或，结果不变。
     */
    public static void findOdd(int[] arr) {
        int xor = 0;

        for (int cur : arr) {
            xor ^= cur;
        }
        int onlyOne = 0;
        // xor = a^b
        // xor != 0
        // xor必然有一个位置上为1
        System.out.println(~xor);
        // 打印8位二进制
        String binary = String.format("%8s", Integer.toBinaryString(~xor)).replace(' ', '0');
        System.out.println(binary);
        int rightOne = xor & (~xor + 1); // 提取出最右边的1
        for (int cur : arr) {
            if ((cur & rightOne) == 0) {
                onlyOne ^= cur;
            }
        }
        System.out.println("出现奇数次的数：" + (xor ^ onlyOne));
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 2, 4, 4, 2, 5, 5, 2, 6, 2};
        findOdd(arr);
    }
}
