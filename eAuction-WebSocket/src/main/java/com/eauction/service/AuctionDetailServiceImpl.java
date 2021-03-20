package com.eauction.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eauction.impl.AuctionDetlIntr;
import com.eauction.model.AuctionBiddingValueDetails;
import com.eauction.model.AuctionBiddingValueDetailsHist;
import com.eauction.queryImplDto.AuctionDetailsQueryDto;
import com.eauction.repo.AuctionBiddingValueDetailsHistRepo;
import com.eauction.repo.AuctionBiddingValueDetailsRepo;

@Service
public class AuctionDetailServiceImpl implements AuctionDetailService {

	@Autowired
	AuctionDetlIntr auctionDetlIntr;

	@Autowired
	AuctionBiddingValueDetailsRepo auctionBiddingValueRepo;

	@Autowired
	AuctionBiddingValueDetailsHistRepo auctionBiddingValueDetailsHistRepo;

	@Override
	public List<AuctionDetailsQueryDto> getAuctionDetails() {

		return auctionDetlIntr.getActionDetailsList();
	}

	@Override
	public void saveOrUpdateBidderDetails(AuctionBiddingValueDetails biddingValueDetails) {

	//	auctionBiddingValueRepo.updateBidderDetails(biddingValueDetails.getBiddingPrice(),
	//			biddingValueDetails.getUpdatedBy(), biddingValueDetails.getUpdatedDateTime(),
	//			biddingValueDetails.getAuctionId(), biddingValueDetails.getUserId());

		auctionBiddingValueRepo.save(biddingValueDetails);

	}

	@Override
	public void saveBidderDetailsInHist(AuctionBiddingValueDetails auctionBiddingValueDetails) {

		AuctionBiddingValueDetailsHist auctionBiddingValueDetailsHist = new AuctionBiddingValueDetailsHist();
		BeanUtils.copyProperties(auctionBiddingValueDetails, auctionBiddingValueDetailsHist);
		//to maintain the hist table id as sequence_increment
		auctionBiddingValueDetailsHist.setBiddingValueId(null);
		auctionBiddingValueDetailsHistRepo.save(auctionBiddingValueDetailsHist);
	}

	@Override
	public List<AuctionDetailsQueryDto> getAuctionDetailsForId(Long auctionId) {
		
		return auctionDetlIntr.getActionDetailsForId(auctionId);
	}

}
