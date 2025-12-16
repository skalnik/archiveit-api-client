package lu.bnl.archiveit.client.model;

import com.google.gson.annotations.SerializedName;

public class Checksums  
{
	@SerializedName("sha1")
    private String sha1;
    
	@SerializedName("md5")
    private String md5;

	public String getSha1() {
		return sha1;
	}

	public void setSha1(String sha1) {
		this.sha1 = sha1;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	@Override
	public String toString() {
		return "Checksums [sha1=" + sha1 + ", md5=" + md5 + "]";
	}

}