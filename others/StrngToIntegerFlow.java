package W100;
/**
 * 字符串转整型，包含溢出判断
 * @author myy
 *
 */
public class StrngToIntegerFlow {
	public static void main(String[] args) {
		System.out.println(StrToInt("-43223423423473"));
//		System.out.println(isOver("348728374932"));
		
	}
	public static int StrToInt(String str) {
        if(str.length()==0 || str=="") {
            return 0;
        }
        int symbol=1;
        
        if(str.charAt(0)=='+') {
            str=str.substring(1);
        }
        else if(str.charAt(0)=='-') {
        	str=str.substring(1);
            symbol=-1;
        }
        char[] ch=str.toCharArray();
        char[] max=(""+Integer.MAX_VALUE).toCharArray();
        char[] min=(""+Integer.MIN_VALUE).toCharArray();
        if(symbol==1) {
        	if(ch.length>max.length) {
        		throw new RuntimeException("溢出");
        	}
        	else if(ch.length==max.length) {
        		for(int i=0;i<ch.length;i++) {
        			if(ch[i]>max[i]) {
        				throw new RuntimeException("溢出");
        			}
        		}
        	}
        }
        else if(symbol==-1) {
        	if(ch.length>min.length-1) {
        		throw new RuntimeException("溢出");
        	}
        	else if(ch.length==min.length) {
        		for(int i=0;i<ch.length;i++) {
        			if(ch[i]>min[i]) {
        				throw new RuntimeException("溢出");
        			}
        		}
        	}
        }
        int result=0;
        for(int i=0;i<ch.length;i++) {
            if(ch[i]>'9' || ch[i]<'0') {
                return 0;
            }
            result=result*10+ch[i]-'0';
            
        }
        return result*symbol;
    }
}
