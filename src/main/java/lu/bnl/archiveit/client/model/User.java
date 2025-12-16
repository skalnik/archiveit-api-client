package lu.bnl.archiveit.client.model;

import com.google.gson.annotations.SerializedName;

public class User 
{
	@SerializedName("created_by")
    private String createdBy;

    @SerializedName("created_date")
    private String createdDate;

    @SerializedName("last_updated_by")
    private String lastUpdatedBy;

    @SerializedName("last_updated_date")
    private String lastUpdatedDate;

    @SerializedName("email")
    private String email;

    @SerializedName("language")
    private String language;

    @SerializedName("full_name")
    private String fullName;

    @SerializedName("time_zone_abbreviation")
    private String timeZoneAbbreviation;

    @SerializedName("date_joined")
    private String dateJoined;

    @SerializedName("temporary_password")
    private String temporaryPassword;

    @SerializedName("last_login")
    private String lastLogin;

    @SerializedName("id")
    private int id;

    @SerializedName("username")
    private String username;

    @SerializedName("deleted")
    private boolean deleted;

    @SerializedName("beta_opt_in")
    private boolean betaOptIn;

    @SerializedName("require_change_password")
    private boolean requireChangePassword;

    @SerializedName("account")
    private Account account;

    @SerializedName("email_notifications")
    private boolean emailNotifications;

    @SerializedName("role")
    private int role;

    @SerializedName("show_subscription_ui")
    private boolean showSubscriptionUI;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getTimeZoneAbbreviation() {
		return timeZoneAbbreviation;
	}

	public void setTimeZoneAbbreviation(String timeZoneAbbreviation) {
		this.timeZoneAbbreviation = timeZoneAbbreviation;
	}

	public String getDateJoined() {
		return dateJoined;
	}

	public void setDateJoined(String dateJoined) {
		this.dateJoined = dateJoined;
	}

	public String getTemporaryPassword() {
		return temporaryPassword;
	}

	public void setTemporaryPassword(String temporaryPassword) {
		this.temporaryPassword = temporaryPassword;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public boolean isBetaOptIn() {
		return betaOptIn;
	}

	public void setBetaOptIn(boolean betaOptIn) {
		this.betaOptIn = betaOptIn;
	}

	public boolean isRequireChangePassword() {
		return requireChangePassword;
	}

	public void setRequireChangePassword(boolean requireChangePassword) {
		this.requireChangePassword = requireChangePassword;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public boolean isEmailNotifications() {
		return emailNotifications;
	}

	public void setEmailNotifications(boolean emailNotifications) {
		this.emailNotifications = emailNotifications;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public boolean isShowSubscriptionUI() {
		return showSubscriptionUI;
	}

	public void setShowSubscriptionUI(boolean showSubscriptionUI) {
		this.showSubscriptionUI = showSubscriptionUI;
	}

	@Override
	public String toString() {
		return "User [createdBy=" + createdBy + ", createdDate=" + createdDate + ", lastUpdatedBy=" + lastUpdatedBy
				+ ", lastUpdatedDate=" + lastUpdatedDate + ", email=" + email + ", language=" + language + ", fullName="
				+ fullName + ", timeZoneAbbreviation=" + timeZoneAbbreviation + ", dateJoined=" + dateJoined
				+ ", temporaryPassword=" + temporaryPassword + ", lastLogin=" + lastLogin + ", id=" + id + ", username="
				+ username + ", deleted=" + deleted + ", betaOptIn=" + betaOptIn + ", requireChangePassword="
				+ requireChangePassword + ", account=" + account + ", emailNotifications=" + emailNotifications
				+ ", role=" + role + ", showSubscriptionUI=" + showSubscriptionUI + "]";
	}
	
}
