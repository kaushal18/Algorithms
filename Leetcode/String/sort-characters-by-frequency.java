
// time - O(N)
class Solution {
    public String frequencySort(String s) {
      Map<Character, Integer> map = new HashMap<>();
      StringBuilder ans = new StringBuilder();
      for(int i=0; i<s.length(); i++) {
        map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
      }
      
      // arraylist inside primitive array
      // index in bucket represents frequency of the character
      List<Character>[] bucket = new ArrayList[s.length() + 1];
      
      for(Map.Entry<Character, Integer> entry : map.entrySet()) {
        if(bucket[entry.getValue()] == null) {
          bucket[entry.getValue()] = new ArrayList<>();
        }
        bucket[entry.getValue()].add(entry.getKey());
      }
      
      for(int i=bucket.length-1; i>=0; i--) {
        if(bucket[i] != null) {
          int frequency = i;
          for(Character c : bucket[i]) {
            for(int j=0; j<frequency; j++) {
              ans.append(c);
            }
          }
        }
      }
      return ans.toString();
    }
}