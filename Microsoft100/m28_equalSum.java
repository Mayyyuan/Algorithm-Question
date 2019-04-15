package W100;
/**
 * 一个整数数组，长度为n，将其分为m 份，使各份的和相等，
 * 求m 的最大值比如{3，2，4，3，6} 可以分成
 * {3，2，4，3，6} m=1
 * {3,6}{2,4,3} m=2
 * {3,3}{2,4}{6} m=3 
 * 所以m 的最大值为3
 * @author myy
 *
 */
import java.util.Arrays;

/**
 * 划分为m块时，需要具备的条件：
 * m的取值为1~n
 * 每一部分之和为 sum/m; （sum为数组元素之和）
 * sum % m == 0，否则不可能平分
 * 递归思想：
 * 假设分为m块，每一块之和即为subSum = sum / m。subSum即为每一块元素之和。
 * 如果array[i]在某一个块中，则需要在数组的其中元素中找出和值为(subSum - array[i])的组合。
 * 利用bool数组标记元素是否已分配到每一块中。
 */
public class m28_equalSum {
	public static void main(String[] args) {
		int[] array = {3,2,4,3,6}; 
		System.out.println(maxLength(array,array.length));
	}
	public static int maxLength(int[] array,int n) {
		if(n<=1) {
			return n>=0? n:0;
		}
		int sum=0;
		for(int i=0;i<n;i++) {
			sum+=array[i];
		}
		boolean[] flag=new boolean[n];
		int m;
		for(m=n;m>1;m--) {
			if(sum%m!=0) {
				continue;
			}
			Arrays.fill(flag,false);
			int i;
			for(i=0;i<n;i++) {
				if(flag[i]==false) {
					flag[i]=true;
					if(!divide(array,flag,n,sum/m-array[i])) {
						break;
					}
				}
			}
			break;
		}
		return m;
	}
	public static boolean divide(int[] array,boolean[] flag,int n,int sum) {
		if(sum<0) {
			return false;
		}
		if(sum==0) {
			return true;
		}
		for(int i=n-1;i>=0;i--) {
			if(flag[i]==false && array[i]<=sum) {
				flag[i]=true;
				if(divide(array,flag,n,sum-array[i])) {
					return true;
				}
				else {
					flag[i]=false;
				}
			}
		}
		return false;
	}
}
