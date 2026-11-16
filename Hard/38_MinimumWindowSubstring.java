class Solution {
    public String minWindow(String s, String t) {
        int[] need = new int[128];
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        int missing = t.length();
        int left = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        for (int right = 0; right < s.length(); right++) {
            if (need[s.charAt(right)] > 0) missing--;
            need[s.charAt(right)]--;
            while (missing == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                need[s.charAt(left)]++;
                if (need[s.charAt(left)] > 0) missing++;
                left++;
            }
        }
        if (minLen == Integer.MAX_VALUE) return "";
        return s.substring(start, start + minLen);
    }
}