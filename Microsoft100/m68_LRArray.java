package W100;
/**
 * 找到大于左边所有数并小于右边所有数的数
 * @author myy
 *
 */
public class m68_LRArray {
	public static void main(String[] args) {
		int[] array={7, 10, 2, 6, 19, 22, 32};
		System.out.println(find(array));
	}
	public static int find(int[] array) {
		int n=array.length;
		int[] leftmax=new int[n];
		leftmax[0]=array[0];
		int[] rightmin=new int[n];
		rightmin[n-1]=array[n-1];
		for(int i=1;i<n;i++) {
			leftmax[i]=Math.max(array[i],leftmax[i-1]);
		}
		for(int i=n-2;i>=0;i--) {
			rightmin[i]=Math.min(array[i],rightmin[i+1]);
		}
		for(int i=0;i<n;i++) {
			if(rightmin[i]==array[i] && leftmax[i]==array[i]) {
				return array[i];
			}
		}
		return -1;
	}
}
