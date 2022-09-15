
// Time - O(n * m)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      Map<String, List<String>> map = new HashMap<>();
      List<List<String>> ans = new ArrayList<>();
      
      for(int i=0; i<strs.length; i++) {
        // generate some unique string to use as a key in hashmap
        String sorted = getSortedString(strs[i]);
        map.putIfAbsent(sorted, new ArrayList<>());
        map.get(sorted).add(strs[i]);
      }
      
      for(List<String> anagramList : map.values()) {
        ans.add(new ArrayList(anagramList));
      }
      
      return ans;
    }
  
    // sort string using couting sort --> O(m)
    public String getSortedString(String s) {
      StringBuilder sb = new StringBuilder();
      int[] freq = new int[26];
      for(int i=0; i<s.length(); i++) {
        freq[s.charAt(i) - 'a']++;
      }
      
      // reconstruct string from frequency array
      for(int i=0; i<freq.length; i++) {
        for(int j=0; j<freq[i]; j++) {
          sb.append((char)(i+97));
        }
      }
      
      return sb.toString();
    }
}