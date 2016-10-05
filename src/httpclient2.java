import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;


public class httpclient2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		while (true) {
			checkhttp(); 
		}
		
		
	}
	
	public static void checkhttp() throws Exception{
		
	long checkAuthenticationStartTime = System.currentTimeMillis();
	String sResult ="";	
	Date dt = new Date();
	//System.out.println(dt.toString());
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd, hh:mm:ss a"); 
	System.out.println(sdf.format(dt).toString()); 
	//FileWriter fw = new FileWriter("/p11/update/checkserver.log",true); // 절대주소 경로 가능
	FileWriter fw = new FileWriter("c:\\ISAPI\\out.txt",true); // 절대주소 경로 가능
    BufferedWriter bw = new BufferedWriter(fw);
    	
		//String sendUrl = "http://sso.kias.re.kr:8080/" + "db.jsp";
		//String sendUrl = "http://sso.ks.ac.kr/" + "LoginServlet" + "?method=checkLogin" + "&ssid=1";
    	String sendUrl = "http://isign.kist.re.kr/HealthCheck_Auth";
    try{
			/*
				인증서버에 해당 Web-Agent의 인증방식 및 통합로그인 정보를 요청하기 위해 httpclient를 사용하여 전달 
			*/
		    int conTimeOut = 20000;
			int soTimeOut = 20000;
			MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();
			HttpClient client = new HttpClient(connectionManager);
			client.setConnectionTimeout(conTimeOut);
			client.setTimeout(soTimeOut);
			connectionManager.setMaxTotalConnections(20000);
			PostMethod post = new PostMethod(sendUrl);
			int httpResult = client.executeMethod(post);
			
			// sResult는 httpclient를 통하여 결과를 받는 변수
			sResult = post.getResponseBodyAsString().trim();
			post.releaseConnection();
			
			/*
				인증서버에 해당 Web-Agent의 인증방식 및 통합로그인 정보를 요청하기 위해 httpclient를 사용하여 전달 
			*/
			//System.out.println(sResult);

		}catch (Exception e){
			/*
				예외처리
				-> httpclient 도중 통신에 문제가 발생하였을 때 로그인 페이지로 send
			*/
e.printStackTrace();
bw.write("TIME  : "+ sdf.format(dt).toString()+"  "+e.toString());
bw.newLine(); // 줄바꿈
 
bw.close();
			return;
			/*
				예외처리
			*/
		}
		
        // BufferedWriter 와 FileWriter를 조합하여 사용 (속도 향상)
        //BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
        String str = "TIME  : "+ sdf.format(dt).toString()+"   Result : "+sResult+"  diff :  "+(System.currentTimeMillis() - checkAuthenticationStartTime);

        bw.write(str);
        bw.newLine(); // 줄바꿈
         
        bw.close();
        
        
        
	System.out.println("TIME  : "+ sdf.format(dt).toString()+"   Result : "+sResult+"  diff :  "+(System.currentTimeMillis() - checkAuthenticationStartTime));
	try {
		Thread.sleep(10000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	}

}
