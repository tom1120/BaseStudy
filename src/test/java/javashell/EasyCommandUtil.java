package javashell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;


public class EasyCommandUtil {

	
	/**
	 * 执行操作系统命令
	 * @param command 执行命令
	 * @return
	 */
	public static List<String> execute(String command){
		String charset = "GBK";
		String osName = System.getProperty("os.name");
		if(osName.trim().toUpperCase().contains("WINDOWS")){
			if(!command.startsWith("cmd /c")){
				command = "cmd /c "+command;
			}
		}
		if(osName.trim().toUpperCase().contains("LINUX")){
			charset = "UTF-8";
		}
		return execute(command,charset);
	}

	/**
	 * 执行操作系统命令
	 * @param command 执行命令
	 * @param charset	执行后返回信息的编码
	 * @return
	 */
	public static List<String> execute(String command,String charset){
		try {
			Process process = Runtime.getRuntime().exec(command);
			process.waitFor();
			InputStream in = process.getInputStream();
			List<String> buff = new ArrayList<String>();
			byte[] but = new byte[10240000];
			int length = 0;
			while ((length = in.read(but))!=-1) {
				if(charset == null){
					charset = "utf-8";
				}
				String str = new String(but,0,length,charset);
				buff.add(str);
			}
			System.out.println("执行操作系统命令【"+command+"】成功");
			return buff;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 执行操作系统命令
	 * @param ip 目标服务器ip
	 * @param username 目标服务器登陆用户名
	 * @param password 目标服务器登陆密码
	 * @param command 要执行的命令
	 * @param charset 返回结果的编码集
	 * @return
	 */
	public static List<String> execute(String ip,String username,String password,String command,String charset){
		Connection conn = null;
		try{  
            //构造一个连接器，传入一个需要登陆的ip地址，连接服务  
            conn = new Connection(ip);  
            conn.connect();  
            //用户验证，传入用户名和密码  
            boolean isAuthenticated = conn.authenticateWithPassword(username, password);  
            if (isAuthenticated == false){
				System.out.println("服务器【"+ip+"】连接异常");
				throw new IOException("服务器连接异常");
            }
            return exString(conn, command, charset);
        }catch (IOException e){
        	System.out.println("执行操作系统命令【"+command+"】失败");
        	e.printStackTrace();
            throw new RuntimeException(e);
        }  
	}
	
	/**
	 * 执行命令
	 * @param conn 远程连接
	 * @param command 要执行的命令
	 * @param charset	返回结果的编码集
	 * @return
	 */
	private static List<String> exString(Connection conn,String command,String charset){
		List<String> list = new ArrayList<String>();
		try{  
			//打开一个会话session，执行linux命令  
	        Session sess = conn.openSession();  
	        sess.execCommand(command);  
	        //接收目标服务器上的控制台返回结果,输出结果。  
	        InputStream stdout = new StreamGobbler(sess.getStdout());
	        BufferedReader br = new BufferedReader(new InputStreamReader(stdout));  
	        while (true){  
	            String line = br.readLine();
	            if (line == null){
	            	break;  
	            }
	            list.add(new String(line.getBytes(),charset));
	        }  
	        //关闭session和connection 
	        br.close();
	        sess.close();
			System.out.println("执行操作系统命令【"+command+"】成功");
	        return list;
        }catch (IOException e){
			System.out.println("执行操作系统命令【"+command+"】失败");
        	e.printStackTrace();
            throw new RuntimeException(e);
        }
	}
}
