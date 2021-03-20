package com.eauction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eauction.constant.Constants;
import com.eauction.model.AuctionBiddingValueDetails;
import com.eauction.repo.AuctionBiddingValueDetailsRepo;
import com.eauction.util.Utility;

@Service
public class AuctionBiddingValueDetailServiceImpl implements AuctionBiddingValueDetailService {

	@Autowired
	AuctionBiddingValueDetailsRepo auctionBiddingValueDetailsRepo;

	@Autowired
	private AuctionBiddingValueDetailService biddingValueDetailService;

	@Override
	public long getbidderingPriceAginstAuctionId(Long auctionId) {

		return auctionBiddingValueDetailsRepo.getMaxBidingprice(auctionId);

	}

	@Override
	public String validateBidderInputs(AuctionBiddingValueDetails biddingValueDetails, String err) {

		long existMaxprice = biddingValueDetailService
				.getbidderingPriceAginstAuctionId(biddingValueDetails.getAuctionId());

		if ((err == null) && (Utility.checkBiddingAmount(existMaxprice, biddingValueDetails.getBiddingPrice()))) 
			err = Constants.ERROR_LOWBIDDINGPRICERESTRICTION;
		
		if((err == null) && (!(Utility.isMultipleofIncrementPrice(biddingValueDetails.getBiddingPrice()))))
			err =  Constants.ERROR_PRICEMULTIPLICATION;


		return err;

	}

}
