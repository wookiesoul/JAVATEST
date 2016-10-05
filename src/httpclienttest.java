import java.io.InputStream;
import java.sql.Blob;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;


public class httpclienttest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Blob abc = null;
		InputStream in = null;
		long checkAuthenticationStartTime = System.currentTimeMillis();
		
		
		
		
		//String sendUrl = "http://sso.kias.re.kr:8080/" + "db.jsp";
		String sendUrl = "https://sso.sbdc.co.kr/" + "LoginServlet" + "?method=checkLogin" + "&ssid=1";
		try{
			/*
				인증서버에 해당 Web-Agent의 인증방식 및 통합로그인 정보를 요청하기 위해 httpclient를 사용하여 전달 
			*/
		    int conTimeOut = 5000;
			int soTimeOut = 5000;
			MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();
			HttpClient client = new HttpClient(connectionManager);
			client.setConnectionTimeout(conTimeOut);
			client.setTimeout(soTimeOut);
			connectionManager.setMaxTotalConnections(5000);
			PostMethod post = new PostMethod(sendUrl);
			
			//sendUrl = " hahahah";
			int httpResult = client.executeMethod(post);
			
			// sResult는 httpclient를 통하여 결과를 받는 변수
			String sResult = post.getResponseBodyAsString().trim();
			post.releaseConnection();
			
			/*
				인증서버에 해당 Web-Agent의 인증방식 및 통합로그인 정보를 요청하기 위해 httpclient를 사용하여 전달 
			*/
			System.out.println(sResult);

		}catch (Exception e){
			/*
				예외처리
				-> httpclient 도중 통신에 문제가 발생하였을 때 로그인 페이지로 send
			*/
			System.out.println(sendUrl);
e.printStackTrace();
			//return;
			/*
				예외처리
			*/
		}

		
	System.out.println("TIME :  "+(System.currentTimeMillis() - checkAuthenticationStartTime));
	}

}
