package lu.bnl.archiveit.client.model;

import com.google.gson.annotations.SerializedName;

public class CrawlLog 
{
	@SerializedName("id")
    private int id;

    @SerializedName("timestamp")
    private String timestamp;
    
    @SerializedName("table_name")
    private String tableName;
    
    @SerializedName("row_id")
    private long rowId;
    
    @SerializedName("action")
    private String action;
    
    @SerializedName("notes")
    private String notes;
    
    @SerializedName("user")
    private int userId;
    
    @SerializedName("username")
    private String username;
    
    @SerializedName("table_id")
    private int tableId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public long getRowId() {
		return rowId;
	}

	public void setRowId(long rowId) {
		this.rowId = rowId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	@Override
	public String toString() {
		return "CrawlLog [id=" + id + ", timestamp=" + timestamp + ", tableName=" + tableName + ", rowId=" + rowId
				+ ", action=" + action + ", notes=" + notes + ", userId=" + userId + ", username=" + username
				+ ", tableId=" + tableId + "]";
	}
    
}
