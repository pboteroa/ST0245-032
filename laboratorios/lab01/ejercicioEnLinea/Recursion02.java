
public class Recursion02 {
	
	public boolean groupSum6(int start, int[] nums, int target) {
	    if (start >= nums.length){
	        return target == 0;
	    }
	    else if (nums[start] == 6) {
	        return groupSum6(start + 1, nums, target - 6);
	    }
	    else if (groupSum6(start + 1, nums, target - nums[start])){
	        return true;
	    }
	    else if (groupSum6(start + 1, nums, target)){
	        return true;
	    }
	    else {
	        return false;
	    } 
	}
	
	
	public boolean groupNoAdj(int start, int[] nums, int target) {
	    if (start >= nums.length){
	        return target == 0;
	    }
	    else if (groupNoAdj(start + 2, nums, target - nums[start])) {
	        return true;
	    }
	    else if (groupNoAdj(start + 1, nums, target)){
	        return true;
	    }
	    else {
	        return false;
	    } 
	}
	
	
	public boolean groupSum5(int start, int[] nums, int target) {
	    if (start >= nums.length){
	        return target == 0;
	    }
	    else if (nums[start] % 5 == 0) {
	        if (start <= nums.length - 2 && nums[start + 1] == 1){
	          return groupSum5(start + 2, nums, target - nums[start]);
	      }
	        return groupSum5(start + 1, nums, target - nums[start]);
	    }
	    else if (groupSum5(start + 1, nums, target - nums[start])) {
	        return true;
	    }
	    else if (groupSum5(start + 1, nums, target)){
	        return true;
	    }
	    else {
	        return false;
	    } 
	}
	
	
	/*
	* Title: groupSumClump
	* Author:  mirandaio
	* Date: 2013
	* Availability: https://github.com/mirandaio/codingbat/blob/master/java/recursion-2/groupSumClump.java
	*/
	public boolean groupSumClump(int start, int[] nums, int target) {
	    if (start >= nums.length)
	        return target == 0;
	    int i = start;
	    int sum = 0;
	    while(i < nums.length && nums[start] == nums[i]) {
	        sum += nums[i];
	        i++;
	    }
	    if(groupSumClump(i, nums, target - sum))
	        return true;
	    if(groupSumClump(i, nums, target))
	        return true;
	    return false;
	}
	
	
	public boolean splitArray(int[] nums) {
	    return helper(0, nums, 0, 0);
	}
	public boolean helper(int start, int[] nums, int x, int y) {
	    if (start >= nums.length){
	        return x == y;
	    }
	    else if(helper(start + 1, nums, x + nums[start], y)){
	        return true;
	    }
	    else if(helper(start + 1, nums, x, y + nums[start])){
	        return true;
	    }
	    else{
	      return false;
	    } 
	}
}
