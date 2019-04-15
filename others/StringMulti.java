package W100;
/**
 * 大数的乘积
 * @author myy
 *
 */
public class StringMulti {
	public static void main(String[] args) {
		String s1="123";
		String s2="399";
		System.out.println(multi(s1,s2));
	}
	public static String multi(String s1,String s2) {
		char sign1=s1.charAt(0);
		char sign2=s2.charAt(0);
		char sign='+';
		if(sign1=='+' || sign1=='-') {
			sign=sign1;
			s1=s1.substring(1);
		}
		if(sign2=='+' || sign2=='-') {
			if(sign==sign2) {
				sign='+';
			}
			else {
				sign='-';
			}
			s2=s2.substring(2);
		}
		char[] c1=new StringBuffer(s1).reverse().toString().toCharArray();
		char[] c2=new StringBuffer(s2).reverse().toString().toCharArray();
		int len1=c1.length;
		int len2=c2.length;
		int maxlen=len1+len2;
		int[] result=new int[maxlen];
		for(int i=0;i<len1;i++) {
			for(int j=0;j<len2;j++) {
				result[i+j]+=(int)(c1[i]-'0')*(int)(c2[j]-'0');
			}
		}
		for(int i=0;i<maxlen;i++) {
			if(result[i]>=10) {
				result[i+1]+=result[i]/10;
				result[i]%=10;
			}
		}
		StringBuffer res=new StringBuffer();
		boolean flag=false;
		for(int i=maxlen-1;i>=0;i--) {
			if(result[i]==0 && flag==false) {
				continue;
			}
			else {
				flag=true;
			}
			res.append(result[i]);
		}
		if(!res.toString().equals("")) {
			if(sign=='-') {
				res.insert(0,sign);
			}
		}
		else {
			res.append(0);
		}
		return res.toString();
	}
}
