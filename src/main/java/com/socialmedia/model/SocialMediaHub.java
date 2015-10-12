package com.socialmedia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="socialmediahub")
public class SocialMediaHub {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String socialFeedId;
	
	@NotEmpty
	@Size(min=1, max=140)
	private String socialFeed;
	
	@NotEmpty
	@Size(min=1, max=140)
	private String programId;
	
	@NotEmpty
	@Size(min=1, max=140)
	private String target;
	
	
	public String getSocialFeedId() {
		return socialFeedId;
	}

	public void setSocialFeedId(String socialFeedId) {
		this.socialFeedId = socialFeedId;
	}

	public String getSocialFeed() {
		return socialFeed;
	}

	public void setSocialFeed(String socialFeed) {
		this.socialFeed = socialFeed;
	}

	public String getProgramId() {
		return programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}
	
}


	