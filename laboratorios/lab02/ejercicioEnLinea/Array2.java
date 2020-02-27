public class Array2 {
  public int countEvens(int[] nums) {
      int cont=0;
      for(int i=0; i<nums.length; i++) {
          if(nums[i]%2==0) {
              cont = cont + 1;
          }
      }
      return cont;
  }
  public int bigDiff(int[] nums) {
      int min=10000;
      int max=-2;
      for (int i=0; i<nums.length; i++) {
          if(nums[i] >= max) {
              max= nums[i];
          }
          if(nums[i] <= min) {
              min= nums[i];
          }
      }
      return max-min;
  }
  public int centeredAverage(int[] nums) {
      int max = nums[0];
      int min = nums[0];
      int sum = nums[0];
      for(int i = 1; i < nums.length; i++) {
	sum  += nums[i];
	if(nums[i] > max) max = nums[i];
	else if(nums[i] < min) min = nums[i];
      }
      return (sum-max-min) / (nums.length - 2);
  }
  public int sum13(int[] nums) {
      int sum= 0;
      if(nums.length==0) return 0;
      else {
          for(int i=0; i<nums.length; i++) {
              if(nums[i]==13) i++;
              else sum= sum +nums[i];
          }
      }
      return sum;
  }
  public boolean has22(int[] nums) {
      for(int i = 0; i < nums.length-1; i++) {
  	if(nums[i] == 2 && nums[i+1] == 2) return true;
      }
      return false;
  }
}