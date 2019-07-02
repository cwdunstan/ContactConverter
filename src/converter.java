
public class converter {
	private String source;
	private String dest;
	private String output;
	
	public converter(String Source, String Dest, String Output) {
		source=Source;
		dest = Dest;
		output = Output;
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
		switch(source.substring(source.length()-3, source.length())) {
		case "csv":
			break;
		case "vcf":
		default:
			return -1;
		}
		return 0;
	}
	
	
}
