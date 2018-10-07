/**
** author: charanjitghai
** question: https://leetcode.com/problems/add-bold-tag-in-string/
*/

class Solution {
    int[] getMaxEndings(String s, String[] ds) {
        int[] maxEndings = new int[s.length()];
        Arrays.fill(maxEndings, -1);
        for(int start = 0; start < s.length(); start++) {
            int mx = -1;
            for(String w : ds) {
                int i = 0;
                while((i < w.length()) && (i+start < s.length()) && (s.charAt(i + start) == w.charAt(i)))
                    i++;
                if(i == w.length())
                    mx = Math.max(mx, i-1);
            }
            if(mx != -1)
                maxEndings[start] = mx + start;
        }
        return maxEndings;
    }
    int[] getMaxEndings(String s, Set<String> ds) {
        int[] maxEndings = new int[s.length()];
        Arrays.fill(maxEndings, -1);
        for(int start = 0; start < s.length(); start++) {
            for(int end = start + 1; end <= s.length(); end++) {
                String candidate = s.substring(start, end);
                if(ds.contains(candidate)) {
                    maxEndings[start] = end-1;
                }
            }
        }
        return maxEndings;
    }

    Set<String> getDictAsSet(String[] dict) {
        Set<String> ds = new HashSet<>();
        for(String word : dict) {
            ds.add(word);
        }
        return ds;
    }
    public String addBoldTag(String s, String[] dict) {

        if(s.length() == 0)
            return s;

        Set<String> ds = getDictAsSet(dict);
        //int[] maxEndings = getMaxEndings(s, ds);
        int[] maxEndings = getMaxEndings(s, dict);

        int start = 0;
        int end = 0;
        StringBuilder sb = new StringBuilder();
        while(end < s.length()) {
            int cMaxEnd = maxEndings[end];
            if(cMaxEnd == -1) {
                sb.append(s.charAt(end));
                end++;
                start = end;
            }
            else {
                while(end <= cMaxEnd) {
                    cMaxEnd = Math.max(cMaxEnd, maxEndings[end]);
                    if(cMaxEnd + 1 < s.length() && maxEndings[cMaxEnd+1] != -1)
                        cMaxEnd = maxEndings[cMaxEnd+1];
                    end++;
                }
                sb.append("<b>");
                for(int i = start; i < end; i++)
                    sb.append(s.charAt(i));
                sb.append("</b>");
                start = end;
            }
        }
        return sb.toString();
    }
}
