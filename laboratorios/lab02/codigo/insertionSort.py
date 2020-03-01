import time
import random
t1 = time.time()
def insertionSort(nums):
    for index in range(1, len(nums)):
        value = nums[index]
        i = index - 1
        while i >= 0:
            if value < nums[i]:
                nums[i+1] = nums[i]
                nums[i] = value
                i = i - 1
            else:
                break
    return nums

nums = random.sample(range(1, 10000), 500)
print(insertionSort(nums))
t2 = time.time()
time = (t2 - t1)*1000
print("Time in ms:", round(time, 2))