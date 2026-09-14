package lu.bnl.archiveit.client.model;

import com.google.gson.annotations.SerializedName;

public class SeedReport 
{
	@SerializedName("id")
    private int id;
	
	@SerializedName("redirect")
    private String redirectedTo;
	
	@SerializedName("status")
    private String status;
	
	@SerializedName("url")
    private String url;
	
	@SerializedName("http_code")
    private int httpStatusCode;
	
	@SerializedName("crawl_job")
    private long crawlJobId;

	@SerializedName("seed")
    private long seedId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRedirectedTo() {
		return redirectedTo;
	}

	public void setRedirectedTo(String redirectedTo) {
		this.redirectedTo = redirectedTo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(int httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

	public long getCrawlJobId() {
		return crawlJobId;
	}

	public void setCrawlJobId(long crawlJobId) {
		this.crawlJobId = crawlJobId;
	}

	public long getSeedId() {
		return seedId;
	}

	public void setSeedId(long seedId) {
		this.seedId = seedId;
	}

	@Override
	public String toString() {
		return "SeedReport [id=" + id + ", redirectedTo=" + redirectedTo + ", status=" + status + ", url=" + url
				+ ", httpStatusCode=" + httpStatusCode + ", crawlJobId=" + crawlJobId + ", seedId=" + seedId + "]";
	}
	    
}
