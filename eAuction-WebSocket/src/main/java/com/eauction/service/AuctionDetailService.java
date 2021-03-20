package com.eauction.service;

import java.util.List;

import com.eauction.model.AuctionBiddingValueDetails;
import com.eauction.queryImplDto.AuctionDetailsQueryDto;

public interface AuctionDetailService {
	
	
	public List<AuctionDetailsQueryDto> getAuctionDetails();
	
	public void saveOrUpdateBidderDetails(AuctionBiddingValueDetails biddingValueDetails);
	
	public void saveBidderDetailsInHist(AuctionBiddingValueDetails auctionBiddingValueDetails);

	public List<AuctionDetailsQueryDto> getAuctionDetailsForId(Long auctionId);

}
