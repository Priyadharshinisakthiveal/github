package testpack;

public class Sum {
	public int  sum(int a,int b) {
		if (a>= 10) {
			throw new IllegalArgumentException("value be less than 10");
		}
			
			return a+b;
		
	}

}
