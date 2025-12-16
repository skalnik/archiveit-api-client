package lu.bnl.archiveit.client.model;

import com.google.gson.annotations.SerializedName;

public class Collection 
{
	@SerializedName("account")
    private int account;

    @SerializedName("created_by")
    private String createdBy;

    @SerializedName("created_date")
    private String createdDate;

    @SerializedName("deleted")
    private boolean deleted;

    @SerializedName("id")
    private int id;

    @SerializedName("image")
    private Object image;

    @SerializedName("last_updated_by")
    private String lastUpdatedBy;

    @SerializedName("last_updated_date")
    private String lastUpdatedDate;

    @SerializedName("name")
    private String name;

    @SerializedName("oai_exported")
    private boolean oaiExported;

    @SerializedName("publicly_visible")
    private boolean publiclyVisible;

    @SerializedName("state")
    private String state;

    @SerializedName("topics")
    private String topics;

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getImage() {
        return image;
    }

    public void setImage(Object image) {
        this.image = image;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(String lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOaiExported() {
        return oaiExported;
    }

    public void setOaiExported(boolean oaiExported) {
        this.oaiExported = oaiExported;
    }

    public boolean isPubliclyVisible() {
        return publiclyVisible;
    }

    public void setPubliclyVisible(boolean publiclyVisible) {
        this.publiclyVisible = publiclyVisible;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }

    @Override
    public String toString() {
        return "Collection [" +
                "account=" + account +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", deleted=" + deleted +
                ", id=" + id +
                ", image=" + image +
                ", lastUpdatedBy='" + lastUpdatedBy + '\'' +
                ", lastUpdatedDate='" + lastUpdatedDate + '\'' +
                ", name='" + name + '\'' +
                ", oaiExported=" + oaiExported +
                ", publiclyVisible=" + publiclyVisible +
                ", state='" + state + '\'' +
                ", topics='" + topics + '\'' +
                ']';
    }
}
