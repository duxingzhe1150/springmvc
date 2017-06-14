package test.test;

public class test {
	
	public static void main(String[] args) {
		
//		System.out.println(getNumCircle(900, 36));
		
		/*Integer i=Integer.parseInt("12b", 16);
		
		System.out.println("0000410708".substring(0, 6));
		
		System.out.println(String.format("%6x", i).replace(" ", "0"));*/
		
//		System.out.println(getChildNumId("0000090408", false));
		
//		System.out.println(getFartherNumId("0000010708"));
		
		
		short s=-12345;
		
		System.out.println(s);
		
		/*String[] arr=getChildNumId("0000090408");
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}*/
		
	}
	
	/**
	 * 
	 * Description: 根据父编号及指定的类型生成子编号   
	     * Create at:   2017年1月22日
		 * @param fartherId 父编号
		 * @param childType 类型
		 * @return
	 */
	public static String getChildNumId(String fartherId,boolean childType){
		
		String deepth=fartherId.substring(6, 8);
		String fartherNum=fartherId.substring(0, 6);
		
		int deepth_int=Integer.parseInt(deepth);
		
		int deepth_child=deepth_int+1;
		
		int child_sex=0x1;
		
		if (!childType) {
			child_sex=0x0;
		}
		
		int childNum=Integer.parseInt(fartherNum,16) | (child_sex<<deepth_int);
		
		
		StringBuilder childNumId=new StringBuilder(String.format("%6x", childNum).replace(" ", "0"));
		
		childNumId.append(String.format("%2d", deepth_child).replace(" ", "0"));
		 
		childNumId.append(fartherId.substring(8, 10));
		
		return childNumId.toString();
	}
	
	/**
	 * 
	 * Description: 根据父编号生成所有（两种）子编号  
	     * Create at:   2017年1月22日
		 * @param fartherId 父编号
		 * @return 字符串数组类型
	 */
	public static String[] getChildNumId(String fartherId){
		
		String[] child_arr=new String[2];
		
		
		child_arr[0]=getChildNumId(fartherId, true);
		child_arr[1]=getChildNumId(fartherId, false);
		
		return child_arr;
	}
	
	/**
	 * 
	 * Description: 根据子编号找出其对应的父编号  
	     * Create at:   2017年1月22日
		 * @param childNumId
		 * @return
	 */
	public static String getFartherNumId(String childNumId){
		
		String deepth=childNumId.substring(6, 8);
		String childNum=childNumId.substring(0, 6);   
		
		int deepth_int=Integer.parseInt(deepth);
		
		int deepth_farther=deepth_int-1;
		
		System.out.println(Integer.parseInt(childNum,16));
		
		int fartherNum=Integer.parseInt(childNum,16) & 0xffffff>>24-deepth_farther;
		
		
		StringBuilder fartherNumId=new StringBuilder(String.format("%6x", fartherNum).replace(" ", "0"));
		
		fartherNumId.append(String.format("%2d", deepth_farther).replace(" ", "0"));
		 
		fartherNumId.append(childNumId.substring(8, 10));
		
		return fartherNumId.toString();
	}

}
