package W100;
/**
 * 大数求和
 * @author myy
 *
 */
public class StringSum {
	public static void main(String[] args) {
		String s1="123";
		String s2="399";
		System.out.println(add1(s1,s2));
		System.out.println(add2(s1,s2));
	}
	public static String add1(String s1,String s2) {
		StringBuffer res=new StringBuffer();
		s1=new StringBuffer(s1).reverse().toString();
		s2=new StringBuffer(s2).reverse().toString();
		int len1=s1.length();
		int len2=s2.length();
		int maxlen=Math.max(len1,len2);
		boolean isOver=false;
		int carry=0;
		if(len1<len2){
			for(int i=len1;i<len2;i++) {
				s1+='0';
			}
		}
		else {
			for(int i=len2;i<len1;i++) {
				s2+='0';
			}
		}
		for(int i=0;i<maxlen;i++) {
			int nsum=Integer.parseInt(s1.charAt(i)+"")+Integer.parseInt(s2.charAt(i)+"")+carry;
			if(nsum>=10) {
				if(i==maxlen-1) {
					isOver=true;
				}
				carry=1;
				res.append(nsum-10);
			}
			else {
				carry=0;
				res.append(nsum);
			}
		}
		if(isOver) {
			res.append(carry);
		}
		return res.reverse().toString();
	}
	public static String add2(String s1,String s2) {
		char[] c1=new StringBuffer(s1).reverse().toString().toCharArray();
		char[] c2=new StringBuffer(s2).reverse().toString().toCharArray();
		int len1=c1.length;
		int len2=c2.length;
		int maxlen=Math.max(len1,len2);
		int[] result=new int[maxlen+1];
		for(int i=0;i<maxlen;i++) {
			int num1=i<len1? c1[i]-'0':0;
			int num2=i<len2? c2[i]-'0':0;
			result[i]+=num1+num2;
//			if(result[i]>=10) {
//				result[i+1]+=result[i]/10;
//				result[i]%=10;
//			}
		}
		for(int i=0;i<maxlen;i++) {
			if(result[i]>=10) {
				result[i+1]+=result[i]/10;
				result[i]%=10;
			}
		}
		StringBuffer res=new StringBuffer();
		boolean flag=false;
		for(int i=maxlen;i>=0;i--) {
			if(result[i]==0 && flag==false) {
				continue;
			}
			else {
				flag=true;
			}
			res.append(result[i]);
		}
		return res.toString();
	}
}
