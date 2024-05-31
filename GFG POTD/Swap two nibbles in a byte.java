class Solution {
    static int swapNibbles(int n) {
        
        int higherNibble = (n & 0xF0) >> 4;
        int lowerNibble = (n & 0x0F) << 4;
        return higherNibble | lowerNibble;
    }
}