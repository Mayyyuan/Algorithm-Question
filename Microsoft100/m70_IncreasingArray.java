package W100;
/**
 * 判断是否为递归数组，递归方式
 * @author myy
 *
 */
public class m70_IncreasingArray {
	public static void main(String[] args) {
		int[] array={1,3,4,65};
		System.out.println(isIncreasing(array,0));
	}
	public static boolean isIncreasing(int[] array,int i) {
		if(array==null || array.length==0) {
			return false;
		}
		if(i==array.length-1) {
			return true;
		}
		if(array[i]<array[i+1]) {
			return isIncreasing(array,i+1);
		}
		return false;
	}
}
