import java.util.*;
import java.io.*;
import java.net.*;
public class TXHttpJava {
	public static void main(String[] args)
	{
		Scanner scanner=new Scanner(System.in);
		System.out.print("请输入操作:S(发送短信),Q(查询余额),C(修改密码),X(退出).");
		System.out.print("提示:输入后按“回车键”响应事件.");
		String cmd=scanner.next();
		if(cmd.trim().toUpperCase().equals("S"))
		{
			SendSmsDemo();
		}
		else if(cmd.trim().toUpperCase().equals("Q"))
		{
			QueryDemo();
		}
		else if(cmd.trim().toUpperCase().equals("C"))
		{
			ChgPwdDemo();
		}
		else if(cmd.trim().toUpperCase().equals("X"))
		{
			System.exit(0);
		}
	}
	
	/*
	 * 发送短信的演示代码
	 */
	static void SendSmsDemo()
	{
		Scanner scanner=new Scanner(System.in);
		System.out.print("请输入您的用户名：");
		String UserName=scanner.next();
		System.out.print("请输入您的密码：");
		String Password=scanner.next();
		System.out.print("请输入接收短信的手机号码：");
		String Mobiles=scanner.next();
		System.out.print("请输入短信内容：");
		String Content=scanner.next();
		URL url = null;
		try
		{
		  String strUrl = "http://api.sms1086.com/api/Send.aspx?username="+URLEncoder.encode(UserName,"GB2312")+"&password="+java.net.URLEncoder.encode(Password,"GB2312")+"&mobiles="+java.net.URLEncoder.encode(Mobiles,"GB2312")+"&content="+java.net.URLEncoder.encode(Content,"GB2312");
		  url = new URL(strUrl);
		  URLConnection UConn = url.openConnection();  
		  BufferedReader breader = new BufferedReader(new InputStreamReader(UConn.getInputStream()));
		  String str=breader.readLine(); 
		  while(str != null){   
		   str = URLDecoder.decode(str,"GB2312");
		   String[] strs=str.split("&");
		   if(strs[0].replace("result=","").trim().equals("0"))
		   {
		   	str = "恭喜，短信发送成功。";
		   }
		   else
		   {
		   str = "短信发送失败。失败原因："+strs[1].replace("description=","");
		   }
		   System.out.print(str);
		   str=breader.readLine();   
		  }
		 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * 查询余额的演示代码
	 */
	static void QueryDemo()
	{
		Scanner scanner=new Scanner(System.in);
		System.out.print("请输入您的用户名：");
		String UserName=scanner.next();
		System.out.print("请输入您的密码：");
		String Password=scanner.next();
		URL url = null;
		try
		{
		  String strUrl = "http://api.sms1086.com/api/Query.aspx?username="+URLEncoder.encode(UserName,"GB2312")+"&password="+java.net.URLEncoder.encode(Password,"GB2312");
		  url = new URL(strUrl);
		  URLConnection UConn = url.openConnection();  
		  BufferedReader breader = new BufferedReader(new InputStreamReader(UConn.getInputStream()));
		  String str=breader.readLine(); 
		  while(str != null){   
		   str = URLDecoder.decode(str,"GB2312");
		   String[] strs=str.split("&");
		   if(strs[0].replace("result=","").trim().equals("0"))
		   {
		   		str = "您的余额为："+strs[1].replace("balance=","")+"条。";
		   }
		   else
		   {
			   str = "查询失败。失败原因："+strs[1].replace("description=","");
		   }
		   System.out.print(str);
		   str=breader.readLine();   
		  }
		 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * 查询余额的演示代码
	 */
	static void ChgPwdDemo()
	{
		Scanner scanner=new Scanner(System.in);
		System.out.print("请输入您的用户名：");
		String UserName=scanner.next();
		System.out.print("请输入您的原密码：");
		String OldPassword=scanner.next();
		System.out.print("请输入您的新密码：");
		String NewPassword=scanner.next();
		URL url = null;
		try
		{
		  String strUrl = "http://api.sms1086.com/api/ChgPwd.aspx?username="+URLEncoder.encode(UserName,"GB2312")+"&password="+java.net.URLEncoder.encode(OldPassword,"GB2312")+"&newpwd="+java.net.URLEncoder.encode(NewPassword,"GB2312");
		  url = new URL(strUrl);
		  URLConnection UConn = url.openConnection();  
		  BufferedReader breader = new BufferedReader(new InputStreamReader(UConn.getInputStream()));
		  String str=breader.readLine(); 
		  while(str != null){   
		   str = URLDecoder.decode(str,"GB2312");
		   String[] strs=str.split("&");
		   if(strs[0].replace("result=","").trim().equals("0"))
		   {
		   		str = "恭喜，密码修改成功。";
		   }
		   else
		   {
			   str = "密码修改失败。失败原因："+strs[1].replace("description=","");
		   }
		   System.out.print(str);
		   str=breader.readLine();   
		  }
		 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
}
