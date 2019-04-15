package W100;
/**
 * ÅÐ¶Ï»ØÎÄ×Ö·û´®
 * @author myy
 *
 */
public class m70_MirrorString {
	public static void main(String[] args) {
		System.out.println(isSymmetry("abcba"));
	}
	public static boolean isSymmetry(String s) {
		if (s == null)
			return false;
		if (s.equals("") || s.length() == 1)
			return true;
		int i=0;
		int j=s.length()-1;
		while(i<j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
