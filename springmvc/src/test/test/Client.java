package test.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 
 *
 * socket 编程测试（客户端）
 * Copyright:   Copyright (c)2017  
* Company:     光宝联合   
 *
 * Create at: 2017年2月23日修改测试
 */
public class Client {
	
	public static void main(String[] args) throws Exception {
		
		//1、创建客户端Socket，指定服务器地址和端口
		Socket socket=new Socket("localhost", 6677);
		
		//2、获取输出流，向服务器端发送信息
		OutputStream os=socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bdw = new BufferedWriter(osw);
		
		System.out.println("1213124");
		
		String text="不太正常啊？";
		bdw.write(text, 0, text.length());
		bdw.flush();
		
		//关闭输出流
		socket.shutdownOutput();
		
		//3、获取输入流，并读取服务器端的响应信息
		InputStream is=socket.getInputStream();
		InputStreamReader isr=new InputStreamReader(is);
		BufferedReader br=new BufferedReader(isr);
		
		String info =null;
		while((info=br.readLine())!=null){
			System.out.println("我是客户端，服务器说："+info);
		 }
		
		//关闭输入流
		socket.shutdownInput();
		
		//4、关闭资源
		bdw.close();
		br.close();
		isr.close();
		is.close();
		os.close();
		socket.close();
		
	}

}
