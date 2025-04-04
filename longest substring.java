import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0, maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            while (set.contains(current)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(current);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "abcabcbb";
        System.out.println(solution.lengthOfLongestSubstring(s1)); 

        String s2 = "bbbbb";
        System.out.println(solution.lengthOfLongestSubstring(s2)); 

        String s3 = "pwwkew";
        System.out.println(solution.lengthOfLongestSubstring(s3)); 
    }
}
