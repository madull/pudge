package pudge;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import com.pudge.handler.TimeServerHandler;

public class MinaTimeClient {
    
    public static void main(String[] args){
        // 创建客户端连接器.
        NioSocketConnector connector = new NioSocketConnector();
        connector.getFilterChain().addLast("logger", new LoggingFilter());
        connector.getFilterChain().addLast("codec", 
                new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));
        
        // 设置连接超时检查时间
        connector.setConnectTimeoutCheckInterval(30);
        connector.setHandler(new IoHandler() {
			
			@Override
			public void sessionOpened(IoSession arg0) throws Exception {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void sessionIdle(IoSession arg0, IdleStatus arg1) throws Exception {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void sessionCreated(IoSession arg0) throws Exception {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void sessionClosed(IoSession arg0) throws Exception {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void messageSent(IoSession arg0, Object arg1) throws Exception {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void messageReceived(IoSession arg0, Object arg1) throws Exception {
				System.out.println(arg1.toString());
				
			}
			
			@Override
			public void exceptionCaught(IoSession arg0, Throwable arg1)
					throws Exception {
				// TODO Auto-generated method stub
				
			}
		});
        
        // 建立连接
        ConnectFuture cf = connector.connect(new InetSocketAddress("127.0.0.1", 6488));
        // 等待连接创建完成
        cf.awaitUninterruptibly();
        
        cf.getSession().write("Hi Server!");
        //cf.getSession().write("quit");
        
        // 等待连接断开
        cf.getSession().getCloseFuture().awaitUninterruptibly();
        // 释放连接
        connector.dispose();
    }
}