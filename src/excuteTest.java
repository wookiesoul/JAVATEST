
public class excuteTest {

	
public static void main(String[] args) throws Exception {	

Runtime rt = Runtime.getRuntime();

String exeFile = "C://Windows//System32//calc.exe";

System.out.println("exeFile: " + exeFile);

Process p;

             

try {

    p = rt.exec(exeFile);

    p.waitFor();

} catch (Exception e) {

    e.printStackTrace();

}
		
}
	
}


