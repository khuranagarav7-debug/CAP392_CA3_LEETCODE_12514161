import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;

        while (index < words.length) {
            
            int totalChars = words[index].length();
            int last = index + 1;

            while (last < words.length) {
               
                if (totalChars + 1 + words[last].length() > maxWidth) {
                    break;
                }
                totalChars += 1 + words[last].length();
                last++;
            }

            StringBuilder line = new StringBuilder(maxWidth);
            int wordCount = last - index;
            int gaps = wordCount - 1;

           
            if (last == words.length || gaps == 0) {
                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i < last - 1) {
                        line.append(' ');
                    }
                }
               
                while (line.length() < maxWidth) {
                    line.append(' ');
                }
            } 
            
            else {
                
                int extraSpaces = maxWidth - totalChars;
                int spacesPerGap = 1 + (extraSpaces / gaps);
                int remainderSpaces = extraSpaces % gaps;

                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i < last - 1) {
                        
                        int spacesToApply = spacesPerGap + ((i - index) < remainderSpaces ? 1 : 0);
                        line.append(" ".repeat(spacesToApply));
                    }
                }
            }

            result.add(line.toString());
            index = last;
        }

        return result;
    }
}