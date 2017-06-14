package test.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 *
 * 多线程下的socket编程测试
 * Copyright:   Copyright (c)2017  
* Company:     光宝联合   
 *
 * Create at: 2017年2月24日
 */
public class Server2 {
	
	ServerSocket serverSocket=null;
	
	public void service(){
		try {
			this.serverSocket=new ServerSocket(6677);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while (true) {
			Socket socket=null;
			
			if (serverSocket!=null) {
				
				try {
					socket=this.serverSocket.accept();
					
					Thread socketThread=new Thread(new Handler(socket));
					
					socketThread.start();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
		}
		
	}
	
	public static void main(String[] args) {
		Server2 server=new Server2();
		
		server.service();
	}

}
