// https://leetcode.com/problems/longest-substring-without-repeating-characters

// Time - O(N)
// Space - O(N)
class Solution {
  public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int left = 0;
    int right = 0;
    int longestSubstrLen = 0;
    
    while(right < s.length()) {
      Character rightChar = s.charAt(right);
      if(map.containsKey(rightChar)) {
        while(left < map.get(rightChar)) {
          map.remove(s.charAt(left));
          left++;
        }
        left++;
      }
      // System.out.println(left + " " + right);
      map.put(s.charAt(right), right);
      longestSubstrLen = Math.max(longestSubstrLen, right-left+1);
      right++;
    }
    
    return longestSubstrLen;
  }
}

// Solution without deletions in map
class Solution {
  public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int left = 0;
    int right = 0;
    int longestSubstrLen = 0;
    
    while(right < s.length()) {
      if(map.containsKey(s.charAt(right))) {
        // as we have stale values in map, we need to check if this duplicate entry in whithin our sliding window
        // eg - abba , when left=2, right=3 we get duplicate entry of 'a' in map but as it is outside our window (less than left) therefore we ignore it.
        if(map.get(s.charAt(right)) >= left) {
          left = map.get(s.charAt(right)) + 1;
        }
      }
      map.put(s.charAt(right), right);
      longestSubstrLen = Math.max(longestSubstrLen, right-left+1);
      right++;
    }
    
    return longestSubstrLen;
  }
}