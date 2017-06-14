package test.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 *
 * socket编程测试
 * Copyright:   Copyright (c)2017  
* Company:     光宝联合   
 *
 * Create at: 2017年2月23日
 */
public class Server {
	
	public static void main(String[] args) throws IOException {
		
		//在指定端口创建服务端socket，
		ServerSocket server=new ServerSocket(6666);
		
		System.out.println("server started..."+server.getLocalPort());
		
		
		
		//监听服务端的端口，等待客户端连接
		Socket socket=server.accept();
		
		System.out.println("正在连接中。。。");
		
		InputStream is=socket.getInputStream();
		
		InputStreamReader isr=new InputStreamReader(is);
		
		BufferedReader br=new BufferedReader(isr);
		
		String info =null;
		while((info=br.readLine())!=null){
			System.out.println("我是服务器，客户端说："+info);
		 }
		
		
		socket.shutdownInput();
		
		OutputStream os=socket.getOutputStream();
		
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bdw = new BufferedWriter(osw);
		//
		String text="hello cainiao";
		bdw.write(text, 0, text.length());
		
		System.out.println("已发送响应信息");
		bdw.flush();
		
		socket.shutdownOutput();
		
		bdw.close();
		
		os.close();
		br.close();
		isr.close();
		is.close();
		socket.close();
		server.close();
		
		
		
		
		
	}

}
