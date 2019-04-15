package W100;
/**
 * œ¥≈∆À„∑®
 * @author myy
 *
 */
import java.util.Random;

public class Shuffle {
	public static void main(String[] args) {
		int[] nums=new int[54];
		for(int i=0;i<54;i++) {
			nums[i]=i+1;
			System.out.println(nums[i]);
		}
		shuffle(nums);
		for(int num:nums) {
			System.out.println(num);
		}
	}
	public static void shuffle(int[] nums){
		for(int i=0;i<54;i++) {
			int random=new Random().nextInt(54);
			int temp=nums[random];
			nums[random]=nums[i];
			nums[i]=temp;
		}
	}
}
