# Input: strs = ["eat","tea","tan","ate","nat","bat"]
# Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

# Time - O(len(strs) * max(len(string)))
def groupAnagrams(strs):
  anagram_map = dict()
  for string in strs:
    sorted_str = ''.join(sorted(string))
    if sorted_str in anagram_map:
        anagram_map[sorted_str].append(string)
    else:
        anagram_map[sorted_str] = [string]
  
  result = []
  for key in anagram_map:
    result.append(anagram_map[key])
  
  return result

# Time - O(len(strs))
def groupAnagrams2(strs):
  anagram_map = dict()
  for string in strs:
    sorted_str = getUniqueKey(string)
    if sorted_str in anagram_map:
        anagram_map[sorted_str].append(string)
    else:
        anagram_map[sorted_str] = [string]
  
  result = []
  for key in anagram_map:
    result.append(anagram_map[key])
  
  return result

# O(1)
def getUniqueKey(string):
  freq_arr = [0]*26
  for char in string:
    freq_arr[ord(char) - ord('a')] += 1

  return "#".join([str(i) for i in freq_arr])