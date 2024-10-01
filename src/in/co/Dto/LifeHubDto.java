package in.co.Dto;

import java.util.Date;

public class LifeHubDto {
	
	 private String userId;
	    private String groupId;
	    private String eventType;
	    private Long eventId;
	    private String activeIndicator;
	    private String eventStartDateString;
	    private String eventEndDateString;
	    private String eventStatusIndicator;
	    private String createdBy;
	    private Date createdDate;
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
			System.out.println("sumit");
		}
		public String getGroupId() {
			return groupId;
		}
		public void setGroupId(String groupId) {
			this.groupId = groupId;
		}
		public String getEventType() {
			return eventType;
		}
		public void setEventType(String eventType) {
			this.eventType = eventType;
		}
		public Long getEventId() {
			return eventId;
		}
		public void setEventId(Long eventId) {
			this.eventId = eventId;
		}
		public String getActiveIndicator() {
			return activeIndicator;
		}
		public void setActiveIndicator(String activeIndicator) {
			this.activeIndicator = activeIndicator;
		}
		public String getEventStartDateString() {
			return eventStartDateString;
		}
		public void setEventStartDateString(String eventStartDateString) {
			this.eventStartDateString = eventStartDateString;
		}
		public String getEventEndDate() {
			return eventEndDateString;
		}
		public void setEventEndDate(Date eventEndDate) {
			this.eventEndDateString = eventEndDateString;
		}
		public String getEventStatusIndicator() {
			return eventStatusIndicator;
		}
		public void setEventStatusIndicator(String eventStatusIndicator) {
			this.eventStatusIndicator = eventStatusIndicator;
		}
		public String getCreatedBy() {
			return createdBy;
		}
		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}
		public Date getCreatedDate() {
			return createdDate;
		}
		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}

}
