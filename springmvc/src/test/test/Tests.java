package test.test;


public class Tests {
	
	public static void main(String[] args) {
		
		for (int i = 0; i <100000; i++) {
			Thread1 ta=new Thread1("A"+i);
			
			ta.start();
		}
		
		
		
		
	}
	
	

}

class Thread1 extends Thread{
	
	private String name;
	
	public Thread1(String name){
		
		this.name=name;
	}
	
	public void run(){
		
//		for (int i = 0; i < 10; i++) {
			
			System.out.println(name+"运行：");
			
			try {
				sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
//		}
		
	}
	
}
