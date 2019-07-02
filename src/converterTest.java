import static org.junit.Assert.*;

import org.junit.Test;

public class converterTest {

	@Test
	public void test() {
		converter tempConv = new converter("test.csv","/dest","VCF");
		int res = tempConv.convert();
		if(res==1){
			System.out.println("hit");
		}
	}

}
