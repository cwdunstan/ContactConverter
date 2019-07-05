import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class converter {
	private String source;
	private String dest;
	private String output;
	
	public converter(String Source, String Dest) {
		source=Source;
		dest = Dest;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}
	
	public int convert() {
		if((source.endsWith(".csv") || source.endsWith("*vcf")) && dest.length()>0){
			File file = new File(source);
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String currLine;
				switch(source.substring(source.length()-3, source.length())) {
					case "csv":
						  while ((currLine = br.readLine()) != null) {
							    System.out.println(currLine); 
							  } 
						break;
					case "vcf":
						  while ((currLine = br.readLine()) != null) {
							    System.out.println(currLine); 
							  } 
						break;
					}
				} catch (FileNotFoundException e) {
				//couldn't open source file
				return -1;
			} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			return 0;
		} else {
			return -1;
		}

	}
	
	
}
