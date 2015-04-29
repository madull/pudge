package com.pudge.handler;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class HelloWorldServerHandler extends IoHandlerAdapter
{

		    //接收来自客户端的数据
		    @Override
		    public void messageReceived( IoSession session, Object message ) throws Exception
		    {
			        String str = message.toString();
			        System.out.println("Received Msg:"+str);
			        String helloWorld = "Hello,I am Server!万万没想到";   
			        session.write(helloWorld);
		    }
		
		 
		    //创建新的连接
		    @Override
		    public void sessionOpened(IoSession session) throws Exception {
		       			System.out.println("Open Session:"+session.getId());
		    }
		    
		    //关闭连接
		    @Override
		    public void sessionClosed(IoSession session) throws Exception {
		    	System.out.println("Close Session:"+session.getId());
		    }
		    
		    
			//输出错误的堆栈信息并关闭会话
		    @Override
		    public void exceptionCaught( IoSession session, Throwable cause ) throws Exception
		    {
		    		//打印异常信息
		            cause.printStackTrace();
		    	     System.out.println("Session id  >> "+session.getId()+" <<    " +cause.getMessage());
		    }
		    
		    //会话空闲的时间达到设定的时间时被调用
		    @Override
		    public void sessionIdle( IoSession session, IdleStatus status ) throws Exception
		    {
		    		//System.out.println( "IDLE " + session.getIdleCount( status ));
		    }
}
