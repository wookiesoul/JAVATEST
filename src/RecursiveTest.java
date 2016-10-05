
public class RecursiveTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fac(5));

	}
	
	public static int fac(int i){
		if(i==1){
		return 1;
		}else{
			return i*fac(i-1);
		}
		
	}
	

}
