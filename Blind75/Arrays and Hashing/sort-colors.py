# Time - O(N)
# Space - O(1)
# Single pass solution
class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # 3 pointers technique
        # if mid = 0, swap mid with left and increment both (as both the values will be at correct position)
        # if mid = 1, just increment the mid
        # if mid = 2, swap mid with right, only decrement right (as the new mid value might be out of place)

        left = 0
        right = len(nums)-1
        mid = 0

        while mid <= right:
            if nums[mid] == 0:
                nums[left], nums[mid] = nums[mid], nums[left]
                left += 1
                mid += 1
            elif nums[mid] == 1:
                mid += 1
            else:
                nums[mid], nums[right] = nums[right], nums[mid]
                right -= 1

        