package W100;
/**
 * ��n ����Ϊm+1 ���ַ��������ĳ���ַ��������m ���ַ���ĳ���ַ�����ǰm ���ַ�ƥ�䣬�������ַ����������ӣ� 
 * ����n ���ַ�������������һ���೤���ַ������������ѭ�����򷵻ش���
 * @author myy
 *
 */
public class m22_maxLengthCircle {
	public static void main(String[] args){
		String[] text = new String[]{    
				"abcd",    
	             "bcde",    
	              "cdea",    
	               "deab",    
	                "eaba",    
	                 "abab",    
//	                "babc",   
	                  "deac",    
	                  "cdei",    
	                  "bcdf",    
	                   "cdfi",    
	                    "dfic",    
	                  "cdfk",    
	                  "bcdg",    
		};    
		System.out.println(maxCatenate(text));    
	}   
	public static int maxCatenate(String[] text){
		int size=text.length;  
	    int[][] dp=new int[size][size];  
	    //create Graph.Use adjacent matrix  
	    for(int i=0;i<size;i++){  
	        for(int j=0;j<size;j++){  
	            if(hasEdge(text[i],text[j])){  
	                dp[i][j]=1;  
	            }  
	        }  
	    }   
	    int max=0;  
	    for(int k=0;k<size;k++){  
	        for(int i=0;i<size;i++){  
	        	for(int j=0;j<size;j++){  
	                if(dp[i][k]!=0 && dp[k][j]!=0){  
	                	dp[i][j]=Math.max(dp[i][j],dp[i][k]+dp[k][j]);  
	                    max=Math.max(max,dp[i][j]);  
	                }  
	            }  
	        }  
	    }       
	    for(int i=0;i<size;i++){  
	        if(dp[i][i]>1){//not '>0',consider "bbbb"   
	            return -1;  
	        }  
	    }  
	    return max+text[0].length();  
	}  
	public static boolean hasEdge(String s1,String s2){   
	    String tmp=s1.substring(1);  
	    return s2.startsWith(tmp);  
	}  
}
