package com.eauction.service;

import com.eauction.model.AuctionBiddingValueDetails;

public interface AuctionBiddingValueDetailService {

	public long getbidderingPriceAginstAuctionId(Long auctionId);
	
	public String validateBidderInputs(AuctionBiddingValueDetails biddingValueDetails,String err);
}
