# Time - O(N * log(N)) - for each number we can calculating its sum of digits too
class Solution:
    def getDigitSum(self, num):
        sum = 0
        while num > 0:
            sum += (num % 10)
            num = num // 10

        return sum

    def maximumSum(self, nums: List[int]) -> int:
        # [9, 7, 9, 4, 7]
        # 9: [18, 36]
        _map = dict()

        for i in range(len(nums)):
            key = self.getDigitSum(nums[i])
            if key in _map:
                val = _map[key]

                if len(val) == 2:
                    _min = min(val)
                    if nums[i] > _min:
                        val[val.index(_min)] = nums[i]
                else:
                    val.append(nums[i])
                
                _map[key] = val
            else:
                _map[key] = [nums[i]]

        # key - sum of digits
        # value - arr of length 2 with the greatest nums with "key" digit sum
        # print(_map)
        maxPairSum = -1
        for key in _map:
            if len(_map[key]) == 2:
                maxPairSum = max(maxPairSum, sum(_map[key]))

        return maxPairSum
