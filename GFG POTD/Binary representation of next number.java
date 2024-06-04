class Solution {
    String binaryNextNumber(String s) {
        int n = s.length();
        char[] result = new char[n];
        boolean carry = true;

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '1' && carry) {
                result[i] = '0';
            } else if (s.charAt(i) == '0' && carry) {
                result[i] = '1';
                carry = false;
            } else {
                result[i] = s.charAt(i);
            }
        }

        if (carry) {
            return '1' + new String(result);
        } else {
            return new String(result);
        }
    }
}
