package com.socialmedia.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.socialmedia.model.SocialMediaHub;

@Repository("socialMediaHubRepository")
public interface SocailMediaHubRepository extends JpaRepository<SocialMediaHub, Long> {

	  @Query("select s from SocialMediaHub s where s.socialFeedId = :socialFeedId")
	  SocialMediaHub findBySocialFeedId(@Param("socialFeedId") String socialFeedId);
}
