
# Time - O(N)
# Space - O(N)
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq_map = dict()
        max_freq = -1
        topK = []

        for num in nums:
            if num in freq_map:
                freq_map[num] += 1
            else:
                freq_map[num] = 1
            
            max_freq = max(max_freq, freq_map[num])

        freq_bucket = [[] for i in range(max_freq+1)]
        

        # freq_map - (number, frequency)
        for key in freq_map:
            freq_bucket[freq_map[key]].append(key)

        # print("map", freq_map)
        # print("freq_bucket", freq_bucket)

        # pick the last k numbers from the freq_bucket
        count = 0
        for ith_bucket in range(max_freq, -1, -1):
            for num in freq_bucket[ith_bucket]:
                topK.append(num)
                count += 1

                if count == k:
                    return topK

        return []

