package W100;
/**
 * 求数组中和为n个三个元素
 * @author myy
 *
 */
import java.util.ArrayList;
import java.util.HashMap;

public class threeSum {
	public static void main(String[] args) {
		int[] nums={1,6,4,3,0};
		ArrayList<ArrayList<Integer>> res=threeSum(nums,7);
		for(ArrayList<Integer>list:res) {
			for(int num:list) {
				System.out.println(num);
			}
			
		}
	}
	public static ArrayList<ArrayList<Integer>> threeSum(int[] nums,int target) {
		ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<nums.length-2;i++) {
			ArrayList<ArrayList<Integer>> restemp=twoSum(nums,target-nums[i],i+1);
			for(ArrayList<Integer> listtemp:restemp) {
				list=new ArrayList<Integer>();
				list.add(nums[i]);
				for(int numtemp:listtemp) {
					list.add(numtemp);
				}
				res.add(list);
			}
		}
		return res;
}
	public static ArrayList<ArrayList<Integer>> twoSum(int[] nums, int target,int start) {
		ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list=new ArrayList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = start; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				list=new ArrayList<Integer>();
				list.add(target-nums[i]);
				list.add(nums[i]);
				res.add(list);
			}
	        map.put(nums[i], nums[i]);
	    }
	    return res;
	}
}
