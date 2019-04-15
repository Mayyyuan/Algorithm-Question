package W100;
/**
 * 字符串中最长数字序列长度
 * @author myy
 *
 */
public class m15_stringMaxInt {
	public static void main(String[] args) {
		String s="asdasda1254123jhsd213";
		System.out.println(helper(s));
	}
	public static int helper(String s) {
		char[] ch=s.toCharArray();
		int[] dp=new int[ch.length];
		if(ch[0]>='0' && ch[0]<='9') {
			dp[0]=1;
		}
		int max=0;
		int lh=-1;
		for(int i=1;i<ch.length;i++) {
			if(ch[i]>='0' && ch[i]<='9') {
				dp[i]=dp[i-1]+1;
			}
//			if(ch[i]>='0' && ch[i]<='9') {  字符串中最长递增数字序列长度。
//				if(ch[i-1]>='0' && ch[i-1]<='9' && ch[i]>ch[i-1]) {
//					dp[i]=dp[i-1]+1;
//				}
//				else {
//					dp[i]=1;
//				}
//			}
			if(dp[i]>max) {
				max=dp[i];
				lh=i;
			}
		}
		String str="";
		for(int i=lh-max+1;i<=lh;i++) {
//			System.out.println(ch[i]);
			str+=ch[i];
		}
		return max;
	}
}
