
public class subStringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dn = "cn=김영국_20100901,ou=kores,o=kores";
		int i = dn.indexOf("_");
		int j = dn.indexOf(",");
		String sabun = dn.substring(i+1, j);
	/*	System.out.println(sabun);
		System.out.println(i);
System.out.println(j);
*/
		String token = "test^KOR";
		String rcv[] = token.split("\\^");
		String id = rcv[0];
		String code = rcv[1];
		System.out.println(id);
		System.out.println(code);
	
	}

}
