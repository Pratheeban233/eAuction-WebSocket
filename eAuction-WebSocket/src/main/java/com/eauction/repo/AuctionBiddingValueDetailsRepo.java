package com.eauction.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.eauction.model.AuctionBiddingValueDetails;

public interface AuctionBiddingValueDetailsRepo extends JpaRepository<AuctionBiddingValueDetails, Long> {

	String UPDATE_BIDDERDETAILS = "UPDATE AuctionBiddingValueDetails SET biddingPrice =:biddingPrice,"
			+ "updatedBy =:updatedBy,updatedDateTime =:updatedDateTime WHERE auctionId =:auctionId and userId =:userId";

	@Modifying
	@Transactional
	@Query(value = UPDATE_BIDDERDETAILS, nativeQuery = true)
	public void updateBidderDetails(@Param(value = "biddingPrice") long biddingPrice,
			@Param(value = "updatedBy") long updatedBy, @Param(value = "updatedDateTime") LocalDateTime updatedDateTime,
			@Param(value = "auctionId") long auctionId, @Param(value = "userId") long userId);
	
	
	String GET_MAX_BID_PRICE = "SELECT max(bidding_value)  FROM eap_auction_bidding_values WHERE auction_id =:auctionId";
	
	@Query(value = GET_MAX_BID_PRICE, nativeQuery = true)
	public Long getMaxBidingprice(@Param(value = "auctionId") Long auctionId);
	
}
