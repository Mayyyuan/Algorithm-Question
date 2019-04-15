package W100;
/**
 * 有n 个长为m+1 的字符串，如果某个字符串的最后m 个字符与某个字符串的前m 个字符匹配，则两个字符串可以联接， 
 * 问这n 个字符串最多可以连成一个多长的字符串，如果出现循环，则返回错误。
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
