package W100;
/**
 * �ַ���ת���ͣ�Ҫ��4�д��롣
 * @author myy
 *
 */
public class M1_5_StringToInteger {
	public static void main(String[] args) {
		char[] ch="-342".toCharArray();
		System.out.println(stringToInt(ch,ch.length));
	}
	public static int stringToInt(char[] str,int length)  
		{  
		    if(length==1)
		        return str[0]=='-' ? 0 : str[0]-'0';  
		     return str[0]=='-' ? stringToInt(str, length-1)*10-(str[length-1]-'0') 
		    		 : stringToInt(str, length-1)*10+str[length-1]-'0';  
		}
}
