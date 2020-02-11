def puerto(start, nums, target):
    if start >= len(nums):
        return target==0
    return puerto(start+1, nums, target-nums[start]) or puerto(start+1, nums, target)

print (puerto(0, [2, 6, 7], 10))