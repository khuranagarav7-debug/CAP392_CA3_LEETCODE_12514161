class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;

        while (i >= 0) {
            // 1. Skip trailing or multiple spaces
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            if (i < 0) {
                break;
            }

            // 2. Mark the end of the word, then find its start
            int j = i;
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            // 3. Append a single space before every word after the first
            if (sb.length() > 0) {
                sb.append(' ');
            }
            sb.append(s, i + 1, j + 1);
        }

        return sb.toString();
    }
}