package com.socialmedia.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="timeline")
public class Timeline {
	
	@Id
	 // @GeneratedValue
	@Column(name="STATUS_ID")
	private long statusId;
	
	@NotEmpty
	@Size(min=1, max=140)
	@Column(name="STATUS_USER")
	private String statusUser;
	
	
	@Size(min=1, max=140)
	@Column(name="STATUS_TEXT")
	private String statusText;
	

	@Min(value=0)
	@Column(name="STATUS_FAV_COUNT")
	private Integer statusFavCount;
	
	@Min(value=0)
	@Column(name="STATUS_REPLY_COUNT")
	private Integer statusReplyCount;
	
	@DateTimeFormat(pattern="dd/MM/YY")
	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(name="STATUS_CREATED_AT")
	private Date statusCreatedAt;
	
	
	@Size(min=1, max=140)
	@Column(name="STATUS_LANGUAGE")
	private String statusLang;
	
	@Size(min=1, max=140)
	@Column(name="STATUS_TYPE")
	private String statusType;
	
	
	public String getStatusType() {
		return statusType;
	}


	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}


	public Integer getStatusFavCount() {
		return statusFavCount;
	}


	public void setStatusFavCount(Integer StatusFavCount) {
		this.statusFavCount = StatusFavCount;
	}


//	private List<String> StatusHashTag;
//	
//	
//	public List<String> getStatusHashTag() {
//		return StatusHashTag;
//	}
//
//
//	public void setStatusHashTag(List<String> StatusHashTag) {
//		this.StatusHashTag = StatusHashTag;
//	}


	public long getStatusId() {
		return statusId;
	}


	public void setStatusId(long StatusId) {
		this.statusId = StatusId;
	}


	public String getStatusUser() {
		return statusUser;
	}


	public void setStatusUser(String StatusUser) {
		this.statusUser = StatusUser;
	}


	public String getStatusText() {
		return statusText;
	}


	public void setStatusText(String StatusText) {
		this.statusText = StatusText;
	}

	public Date getStatusCreatedAt() {
		return statusCreatedAt;
	}


	public void setStatusCreatedAt(Date StatusCreatedAt) {
		this.statusCreatedAt = StatusCreatedAt;
	}


	public String getStatusLang() {
		return statusLang;
	}


	public void setStatusLang(String StatusLang) {
		this.statusLang = StatusLang;
	}

	public Integer getStatusReplyCount() {
		return statusReplyCount;
	}


	public void setStatusReplyCount(Integer statusReplyCount) {
		this.statusReplyCount = statusReplyCount;
	}


}
