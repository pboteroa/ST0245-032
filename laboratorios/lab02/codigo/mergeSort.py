import time
import random

t1 = time.time()
def mergeSort(nums):
    if len(nums) > 1:
        mid = len(nums) // 2
        left = nums[:mid]
        right = nums[mid:]

        mergeSort(left)
        mergeSort(right)

        i = 0
        j = 0

        k = 0

        while i < len(left) and j < len(right):
            if left[i] < right[j]:
                nums[k] = left[i]
                i += 1
            else:
                nums[k] = right[j]
                j += 1
            k += 1

        while i < len(left):
            nums[k] = left[i]
            i += 1
            k += 1

        while j < len(right):
            nums[k] = right[j]
            j += 1
            k += 1
    return nums


nums = random.sample(range(1, 20000), 1000)
print(mergeSort(nums))
t2 = time.time()
time = (t2 - t1)*1000
print("Time in ms:", round(time, 2))
