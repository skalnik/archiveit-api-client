package lu.bnl.archiveit.client.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Warc 
{
	@SerializedName("size")
    private String size;

    @SerializedName("crawl-start")
    private String crawlStart;

    @SerializedName("crawl")
    private String crawl;

    @SerializedName("account")
    private String account;

    @SerializedName("checksums")
    private Checksums checksums;

    @SerializedName("filetype")
    private String filetype;

    @SerializedName("locations")
    private List<String> locations;

    @SerializedName("collection")
    private String collection;

    @SerializedName("filename")
    private String filename;

    @SerializedName("crawl-time")
    private String crawlTime;

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getCrawlStart() {
		return crawlStart;
	}

	public void setCrawlStart(String crawlStart) {
		this.crawlStart = crawlStart;
	}

	public String getCrawl() {
		return crawl;
	}

	public void setCrawl(String crawl) {
		this.crawl = crawl;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Checksums getChecksums() {
		return checksums;
	}

	public void setChecksums(Checksums checksums) {
		this.checksums = checksums;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public List<String> getLocations() {
		return locations;
	}

	public void setLocations(List<String> locations) {
		this.locations = locations;
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getCrawlTime() {
		return crawlTime;
	}

	public void setCrawlTime(String crawlTime) {
		this.crawlTime = crawlTime;
	}

	@Override
	public String toString() {
		return "Warc [size=" + size + ", crawlStart=" + crawlStart + ", crawl=" + crawl + ", account=" + account
				+ ", checksums=" + checksums + ", filetype=" + filetype + ", locations=" + locations + ", collection="
				+ collection + ", filename=" + filename + ", crawlTime=" + crawlTime + "]";
	}

}
