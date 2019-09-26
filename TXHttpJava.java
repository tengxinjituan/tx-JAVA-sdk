import java.util.*;
import java.io.*;
import java.net.*;
public class TXHttpJava {
	public static void main(String[] args)
	{
		Scanner scanner=new Scanner(System.in);
		System.out.print("���������:S(���Ͷ���),Q(��ѯ���),C(�޸�����),X(�˳�).");
		System.out.print("��ʾ:����󰴡��س�������Ӧ�¼�.");
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
	 * ���Ͷ��ŵ���ʾ����
	 */
	static void SendSmsDemo()
	{
		Scanner scanner=new Scanner(System.in);
		System.out.print("�����������û�����");
		String UserName=scanner.next();
		System.out.print("�������������룺");
		String Password=scanner.next();
		System.out.print("��������ն��ŵ��ֻ����룺");
		String Mobiles=scanner.next();
		System.out.print("������������ݣ�");
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
		   	str = "��ϲ�����ŷ��ͳɹ���";
		   }
		   else
		   {
		   str = "���ŷ���ʧ�ܡ�ʧ��ԭ��"+strs[1].replace("description=","");
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
	 * ��ѯ������ʾ����
	 */
	static void QueryDemo()
	{
		Scanner scanner=new Scanner(System.in);
		System.out.print("�����������û�����");
		String UserName=scanner.next();
		System.out.print("�������������룺");
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
		   		str = "�������Ϊ��"+strs[1].replace("balance=","")+"����";
		   }
		   else
		   {
			   str = "��ѯʧ�ܡ�ʧ��ԭ��"+strs[1].replace("description=","");
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
	 * ��ѯ������ʾ����
	 */
	static void ChgPwdDemo()
	{
		Scanner scanner=new Scanner(System.in);
		System.out.print("�����������û�����");
		String UserName=scanner.next();
		System.out.print("����������ԭ���룺");
		String OldPassword=scanner.next();
		System.out.print("���������������룺");
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
		   		str = "��ϲ�������޸ĳɹ���";
		   }
		   else
		   {
			   str = "�����޸�ʧ�ܡ�ʧ��ԭ��"+strs[1].replace("description=","");
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
