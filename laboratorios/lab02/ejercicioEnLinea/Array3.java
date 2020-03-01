package lab2;

public class Array3 {
	
	public int maxSpan(int[] nums) {
		  
		  int span1 = 0;
		  int span2 = 0;
		  
		  for (int i = 0; i < nums.length; i++){
		    for (int j = 0; j < nums.length; j++){
		      if (nums[i] == nums[j]){
		        span1 = j-i+1;
		        span2 = Math.max(span1, span2);
		      }
		    }
		  }
		  return span2;
		}
	
	public int[] fix34(int[] nums) {
		  
		  int var = 0;
		  
		  for (int i = 0; i <= nums.length-1; i++){
		    for (int j = 0; j <= nums.length-1; j++){
		      if(nums[j] == 3){
		        var = nums[j+1];
		      }
		      if(nums[j] == 4){
		        nums[j] = var;
		      }
		      if(nums[i] == 3){
		        nums[i+1] = 4;
		      }
		    }
		  }
		  return nums;
		}
	
	/*
	* Title: fix45
	* Author:  mirandaio
	* Date: 2013
	* Availability: https://github.com/mirandaio/codingbat/blob/master/java/array-3/fix45.java
	*/
	public int[] fix45(int[] nums) {
	    int i = 0;
	    int j = 0;
	        
	    while(j < nums.length && nums[j] != 5)
	        j++;
	        
	    while(i < nums.length) {
	        if(nums[i] == 4) {
	            int temp = nums[i+1];
	            nums[i+1] = nums[j];
	            nums[j] = temp;
	            
	            while((j < nums.length && nums[j] != 5) || j == i + 1)
	                j++;
	        }
	        i++;
	    }
	    return nums;
	}
	
	public boolean canBalance(int[] nums) {
	    
		  int sumL = 0;
		  int sumR = 0;
		    
		  for(int i = 0; i < nums.length; i++){
		    sumL += nums[i];
		    for(int j = 0; j < i; j++){
		      sumR += nums[j];
		    }
		    if(sumL == sumR){
		    return true;
		    }
		  }
		  
		  return false;
		}
	
	/*
	* Title: linearIn
	* Author:  mirandaio
	* Date: 2013
	* Availability: https://github.com/mirandaio/codingbat/blob/master/java/array-3/linearIn.java
	*/
	public boolean linearIn(int[] outer, int[] inner) {
	    int i = 0;
	    int j = 0;
	      
	    while(i < inner.length && j < outer.length) {
	        if(inner[i] > outer[j]) {
	            j++;
	        } else if(inner[i] < outer[j]) {
	            return false;
	        } else {
	            i++;
	        }
	    }
	                                              
	    if(i != inner.length)
	        return false;
	                                                      
	    return true;
	}

}
