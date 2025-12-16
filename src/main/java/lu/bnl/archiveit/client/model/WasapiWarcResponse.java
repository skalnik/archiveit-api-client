package lu.bnl.archiveit.client.model;

import com.google.gson.annotations.SerializedName;

/**
 * Encapsulates a WASAPI compliant response object.
 *
 */
public class WasapiWarcResponse 
{
	@SerializedName("count")
    private int count;
    
	@SerializedName("next")
	private String next;
    
	@SerializedName("previous")
	private String previous;
    
	@SerializedName("files")
	private Warc[] files;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public Warc[] getFiles() {
		return files;
	}

	public void setFiles(Warc[] files) {
		this.files = files;
	}

}