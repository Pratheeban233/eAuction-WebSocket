package com.eauction.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eauction.model.AuctionDetails;

public interface AuctionDetailsRepo extends JpaRepository<AuctionDetails, Long> {

	//static final String AUCTION_LIST = "SELECT  auctionId ,auctionName ,startdateTime ,endDateTime ,biddingPrice FROM AuctionDetails ab,AuctionBiddingValueDetails cd"
		//								+ "WHERE isActive IS :isActive AND ab.auctionId = cd.auctionId";
	
	//AND auctionId = auctionId 
	
	//@Query(value = AUCTION_LIST, nativeQuery = true)
	//public List<AuctionDetails> getAuctionListByActive(@Param(value="isActive") boolean isActive);
	
	List<AuctionDetailsRepo> findByIsActiveIsTrue();

}
