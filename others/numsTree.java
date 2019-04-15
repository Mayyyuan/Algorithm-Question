package W100;
/**
 * n个节点可构成二叉搜索树的数量
 * @author myy
 *
 */
public class numsTree {
	public static void main(String[] args) {
		System.out.println(numTrees(4));
		System.out.println(numTrees2(4));
	}
	public static int numTrees(int n) {
		if(n==0 || n==1) {
			return 1;
		}
		int[] dp=new int[n+1];
		dp[0]=1;
		dp[1]=1;
		for(int i=2;i<=n;i++) {
			for(int j=0;j<i;j++) {
				dp[i]+=dp[j]*dp[i-j-1];
			}
		}
		return dp[n];
	}
	public static int numTrees2(int n) {
		if(n<=1) {
			return 1;
		}
		int sum=0;
		for(int i=1;i<=n;i++) {
			sum+=numTrees2(i-1)*numTrees2(n-i);
		}
		return sum;
	}
}
