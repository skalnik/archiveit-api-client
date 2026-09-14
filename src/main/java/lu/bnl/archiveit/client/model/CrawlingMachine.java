package lu.bnl.archiveit.client.model;

import com.google.gson.annotations.SerializedName;

public class CrawlingMachine 
{
	@SerializedName("id")
    private int id;

    @SerializedName("ait_build_id")
    private String buildId;

    @SerializedName("active")
    private boolean isActive;

    @SerializedName("last_update")
    private String lastUpdated;
    
    @SerializedName("total_physical_memory_size")
    private long totalPhysicalMemoryBytes;

    @SerializedName("free_physical_memory_size")
    private long freePhysicalMemoryBytes;

    @SerializedName("hostname")
    private String hostname;
    
    @SerializedName("num_cores")
    private int numCores;
    
    @SerializedName("loadavg1")
    private double loadAverage1;
    
    @SerializedName("loadavg5")
    private double loadAverage5;
    
    @SerializedName("loadavg15")
    private double loadAverage15;
    
    @SerializedName("active_crawl_jobs")
    private int numActiveCrawlJobs;
    
    @SerializedName("active_toe_threads")
    private int numActiveToeThreads;
    
    @SerializedName("output_queue")
    private int outputQueue;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBuildId() {
		return buildId;
	}

	public void setBuildId(String buildId) {
		this.buildId = buildId;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public long getTotalPhysicalMemoryBytes() {
		return totalPhysicalMemoryBytes;
	}

	public void setTotalPhysicalMemoryBytes(long totalPhysicalMemoryBytes) {
		this.totalPhysicalMemoryBytes = totalPhysicalMemoryBytes;
	}

	public long getFreePhysicalMemoryBytes() {
		return freePhysicalMemoryBytes;
	}

	public void setFreePhysicalMemoryBytes(long freePhysicalMemoryBytes) {
		this.freePhysicalMemoryBytes = freePhysicalMemoryBytes;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public int getNumCores() {
		return numCores;
	}

	public void setNumCores(int numCores) {
		this.numCores = numCores;
	}

	public double getLoadAverage1() {
		return loadAverage1;
	}

	public void setLoadAverage1(double loadAverage1) {
		this.loadAverage1 = loadAverage1;
	}

	public double getLoadAverage5() {
		return loadAverage5;
	}

	public void setLoadAverage5(double loadAverage5) {
		this.loadAverage5 = loadAverage5;
	}

	public double getLoadAverage15() {
		return loadAverage15;
	}

	public void setLoadAverage15(double loadAverage15) {
		this.loadAverage15 = loadAverage15;
	}

	public int getNumActiveCrawlJobs() {
		return numActiveCrawlJobs;
	}

	public void setNumActiveCrawlJobs(int numActiveCrawlJobs) {
		this.numActiveCrawlJobs = numActiveCrawlJobs;
	}

	public int getNumActiveToeThreads() {
		return numActiveToeThreads;
	}

	public void setNumActiveToeThreads(int numActiveToeThreads) {
		this.numActiveToeThreads = numActiveToeThreads;
	}

	public int getOutputQueue() {
		return outputQueue;
	}

	public void setOutputQueue(int outputQueue) {
		this.outputQueue = outputQueue;
	}

	@Override
	public String toString() {
		return "CrawlingMachine [id=" + id + ", buildId=" + buildId + ", isActive=" + isActive + ", lastUpdated="
				+ lastUpdated + ", totalPhysicalMemoryBytes=" + totalPhysicalMemoryBytes + ", freePhysicalMemoryBytes="
				+ freePhysicalMemoryBytes + ", hostname=" + hostname + ", numCores=" + numCores + ", loadAverage1="
				+ loadAverage1 + ", loadAverage5=" + loadAverage5 + ", loadAverage15=" + loadAverage15
				+ ", numActiveCrawlJobs=" + numActiveCrawlJobs + ", numActiveToeThreads=" + numActiveToeThreads
				+ ", outputQueue=" + outputQueue + "]";
	}
	
}
