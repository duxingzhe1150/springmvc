package test.test;

public class Traverse {
    static int[] book= {0,0,0,0,0,0,0,0,0,0,0};
    static int sum=0,i;
    static int e[][]={{0,0,0,0,0,0},
           {0,0,1,1,99,1},
           {0,1,0,99,1,99},
           {0,1,99,0,99,1},
          {0,99,1,99,0,99},
          {0,1,99,1,99,0}};
    public static void main(String[] args){
        /*book[1]=1;   
        dfs(1);*/
    	
    	String str1="abc";
    	String str2="abc";
    	
    	String str3=new String("abc");
    	
    	String str4=new String("abc");
    	
    	System.out.println(str1==str2);
    	
    	System.out.println(str1==str3);
    	
    	System.out.println(str3==str4);
    	
    	System.out.println(str1);
    	
    	
    	
    }
    public static void dfs(int k){
        System.out.print(k);
        sum++;
        if(sum==5) return;
        for(i=1;i<=5;i++){
             
        }
        //return;
  
    }
}
