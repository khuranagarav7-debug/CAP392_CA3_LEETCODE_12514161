class Solution {
    public int compress(char[] chars) {
        int write = 0; // Index where we write the compressed characters
        int read = 0;  // Index scanning through the input array

        while (read < chars.length) {
            char currentChar = chars[read];
            int count = 0;

            // Count consecutive occurrences of currentChar
            while (read < chars.length && chars[read] == currentChar) {
                read++;
                count++;
            }

            // Write the character itself
            chars[write++] = currentChar;

            // If count > 1, write each digit of count individually
            if (count > 1) {
                for (char digit : Integer.toString(count).toCharArray()) {
                    chars[write++] = digit;
                }
            }
        }

        return write;
    }
}