package W100;
/**
 * 子序列和为0的最大长度
 * @author myy
 *
 */
public class M4_addIsZero {
	public static void main(String[] args) {
		int[] array={1,0,2,5,-1,-2,2,1,7};
		System.out.println(find(array));
	}
	private static int find(int[] arr) {
		int[] B = new int[arr.length + 1];
		B[0] = 0;
		for (int x = 0; x < arr.length; x++) {
			B[x+1] = arr[x]+B[x];
		}
		int dp[] = new int [arr.length];
		int max=0;
		for(int i = 0;i<arr.length;i++){
			for(int j =arr.length;j>i;j--){
				if(B[i]==B[j]){
					dp[i]=j-i;
					break;
				}
			}
			max=Math.max(max,dp[i]);
		}
//		int max = 0;
//		for(int x =0;x<dp.length;x++){
//			if(dp[x]>max){
//				max=dp[x];
//			}
//		}
		return max;
	}
}
