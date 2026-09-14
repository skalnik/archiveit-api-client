package lu.bnl.archiveit.client.model;

import com.google.gson.annotations.SerializedName;

public class CrawlJob 
{
	@SerializedName("id")
    private int id;

    @SerializedName("type")
    private String type;
    
    @SerializedName("brozzler")
    private String isBrozzler;
    
    @SerializedName("original_start_date")
    private String startDate;
    
    @SerializedName("end_date")
    private String endDate;
    
    @SerializedName("test_crawl_save_date")
    private String testCrawlSaveDate;
    
    @SerializedName("test_crawl_state")
    private String testCrawlState;
    
    @SerializedName("test_crawl_state_changed_at")
    private String testCrawlStateChangedDate;
    
    @SerializedName("elapsed_ms")
    private long elapsed_ms;
    
    @SerializedName("downloaded_count")
    private long donwloadedCount;
    
    @SerializedName("total_data_in_kbs")
    private long totalDataKbs;
    
    @SerializedName("novel_count")
    private long novelCount;
    
    @SerializedName("novel_bytes")
    private long novelBytes;
    
    @SerializedName("duplicate_count")
    private long duplicateCount;
    
    @SerializedName("duplicate_bytes")
    private long duplicateBytes;
    
    @SerializedName("warc_url_count")
    private long warcUrlCount;
    
    @SerializedName("warc_content_bytes")
    private long warcContentBytes;
    
    @SerializedName("status")
    private String status;
    
    @SerializedName("doc_rate")
    private String documentRate;
    
    @SerializedName("account")
    private int accountId;
        
    @SerializedName("collection")
    private int collectionId;
    
    @SerializedName("crawl_definition")
    private long crawlDefinition;
    
    @SerializedName("test_crawl_state_changed_by")
    private String testCrawlStateChangedByUserId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIsBrozzler() {
		return isBrozzler;
	}

	public void setIsBrozzler(String isBrozzler) {
		this.isBrozzler = isBrozzler;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getTestCrawlSaveDate() {
		return testCrawlSaveDate;
	}

	public void setTestCrawlSaveDate(String testCrawlSaveDate) {
		this.testCrawlSaveDate = testCrawlSaveDate;
	}

	public String getTestCrawlState() {
		return testCrawlState;
	}

	public void setTestCrawlState(String testCrawlState) {
		this.testCrawlState = testCrawlState;
	}

	public String getTestCrawlStateChangedDate() {
		return testCrawlStateChangedDate;
	}

	public void setTestCrawlStateChangedDate(String testCrawlStateChangedDate) {
		this.testCrawlStateChangedDate = testCrawlStateChangedDate;
	}

	public long getElapsed_ms() {
		return elapsed_ms;
	}

	public void setElapsed_ms(long elapsed_ms) {
		this.elapsed_ms = elapsed_ms;
	}

	public long getDonwloadedCount() {
		return donwloadedCount;
	}

	public void setDonwloadedCount(long donwloadedCount) {
		this.donwloadedCount = donwloadedCount;
	}

	public long getTotalDataKbs() {
		return totalDataKbs;
	}

	public void setTotalDataKbs(long totalDataKbs) {
		this.totalDataKbs = totalDataKbs;
	}

	public long getNovelCount() {
		return novelCount;
	}

	public void setNovelCount(long novelCount) {
		this.novelCount = novelCount;
	}

	public long getNovelBytes() {
		return novelBytes;
	}

	public void setNovelBytes(long novelBytes) {
		this.novelBytes = novelBytes;
	}

	public long getDuplicateCount() {
		return duplicateCount;
	}

	public void setDuplicateCount(long duplicateCount) {
		this.duplicateCount = duplicateCount;
	}

	public long getDuplicateBytes() {
		return duplicateBytes;
	}

	public void setDuplicateBytes(long duplicateBytes) {
		this.duplicateBytes = duplicateBytes;
	}

	public long getWarcUrlCount() {
		return warcUrlCount;
	}

	public void setWarcUrlCount(long warcUrlCount) {
		this.warcUrlCount = warcUrlCount;
	}

	public long getWarcContentBytes() {
		return warcContentBytes;
	}

	public void setWarcContentBytes(long warcContentBytes) {
		this.warcContentBytes = warcContentBytes;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDocumentRate() {
		return documentRate;
	}

	public void setDocumentRate(String documentRate) {
		this.documentRate = documentRate;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getCollectionId() {
		return collectionId;
	}

	public void setCollectionId(int collectionId) {
		this.collectionId = collectionId;
	}

	public long getCrawlDefinition() {
		return crawlDefinition;
	}

	public void setCrawlDefinition(long crawlDefinition) {
		this.crawlDefinition = crawlDefinition;
	}

	public String getTestCrawlStateChangedByUserId() {
		return testCrawlStateChangedByUserId;
	}

	public void setTestCrawlStateChangedByUserId(String testCrawlStateChangedByUserId) {
		this.testCrawlStateChangedByUserId = testCrawlStateChangedByUserId;
	}

	@Override
	public String toString() {
		return "CrawlJob [id=" + id + ", type=" + type + ", isBrozzler=" + isBrozzler + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", testCrawlSaveDate=" + testCrawlSaveDate + ", testCrawlState="
				+ testCrawlState + ", testCrawlStateChangedDate=" + testCrawlStateChangedDate + ", elapsed_ms="
				+ elapsed_ms + ", donwloadedCount=" + donwloadedCount + ", totalDataKbs=" + totalDataKbs
				+ ", novelCount=" + novelCount + ", novelBytes=" + novelBytes + ", duplicateCount=" + duplicateCount
				+ ", duplicateBytes=" + duplicateBytes + ", warcUrlCount=" + warcUrlCount + ", warcContentBytes="
				+ warcContentBytes + ", status=" + status + ", documentRate=" + documentRate + ", accountId="
				+ accountId + ", collectionId=" + collectionId + ", crawlDefinition=" + crawlDefinition
				+ ", testCrawlStateChangedByUserId=" + testCrawlStateChangedByUserId + "]";
	}
    
}
