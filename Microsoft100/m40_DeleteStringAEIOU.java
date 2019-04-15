package W100;
/**
 * 删除字符串中指定的元素
 * @author myy
 *
 */
public class m40_DeleteStringAEIOU {
	public static void main(String[] args) {
		System.out.println(deleteAEIOU("They are students.","aeiou"));
	}
	public static String deleteAEIOU(String str,String dest) {
		int[] hashset=new int['z'+1];
		String res="";
		for(int i=0;i<dest.length();i++) {
			hashset[dest.charAt(i)]=1
					;
		}
		for(int i=0;i<str.length();i++) {
			if(hashset[str.charAt(i)]==0) {
				res+=str.charAt(i);
			}
		}
		return res;
	}
}
