/**
 * Class GrayCode
 * Generates GrayCode for N- Bits
 *
 * n=1
 *  0
 *  1
 * n=2
 *  00
 *  01
 *  11
 *  10
 * n=3
 *  000
 *  001
 *  011
 *  010
 *  100
 *  101
 *  111
 *  110
 *  etc.
 */
public class GrayCode {

    /** Array of Strings used for the answers */
    static String[] answ;

    public static void main(String[] args) {

        GrayCode(12);

    }


    /**
     * GrayCode Method
     * Generates the GrayCode for N-Bits
     * @param n
     * @return
     */
    static String[] GrayCode(int n) {

        /**
         * BaseCase
         * n=1
         */
        if (n == 1) {
            answ = new String[]{"0", "1"};
            return answ;

        } else { // Else we generate the GrayCode for n-1
            GrayCode(n - 1);
        }

        /** String array newAnsw used to store the new Answers */
        String[] newAnsw = new String[(int) Math.pow(2,n)];

        /**
         * We append '0' to the first Strings
         * For example if n=1
         * 0 is set to be 00
         * 1 is set to be 10
         */
        for (int i = 0; i < answ.length; i++) {

            StringBuilder stringBuilder = new StringBuilder(answ[i]);
            stringBuilder.insert(0, '0');

            newAnsw[i] = stringBuilder.toString();
        }

        /**
         * Int index used to set keep the index after answ.length
         * For example index is 4,5,6,7 if n=3
         */
        int index = answ.length;

        /**
         * We append '1' to the mirrored Strings
         * For example if n=1
         * 1 is set to be 11
         * 0 is set to be 10
         */
        for (int i = answ.length - 1; i >= 0; i--) {

            StringBuilder stringBuilder = new StringBuilder(answ[i]);
            stringBuilder.insert(0, '1');

            newAnsw[index] = stringBuilder.toString();

            // Index is incremented
            index++;
        }

        answ = newAnsw;


        /** We print out the GrayCode */
        for (String s : answ) {
            System.out.println(s);
        }

        return answ;

    }


}
