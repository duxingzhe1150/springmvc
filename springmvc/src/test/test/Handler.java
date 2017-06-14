package test.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * 
 *
 * socket线程类
 * Copyright:   Copyright (c)2017  
* Company:     光宝联合   
 *
 * Create at: 2017年2月24日
 */
public class Handler implements Runnable {
	
	private Socket socket;
	
	public Handler(Socket socket) {
		this.socket=socket;
	}

	@Override
	public void run() {
		try{
            System.out.println("新连接:"+socket.getInetAddress()+":"+socket.getPort());
            
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
            
            Thread.sleep(10000);
        }catch(Exception e){e.printStackTrace();}finally{
            try{
                System.out.println("关闭连接:"+socket.getInetAddress()+":"+socket.getPort());
                if(socket!=null)socket.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
		
	}

}
