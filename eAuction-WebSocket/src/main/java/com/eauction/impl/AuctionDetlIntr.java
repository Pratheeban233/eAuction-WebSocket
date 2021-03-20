package com.eauction.impl;

import java.util.List;

import com.eauction.queryImplDto.AuctionDetailsQueryDto;

public interface AuctionDetlIntr {
	
	public List<AuctionDetailsQueryDto> getActionDetailsList();

	public List<AuctionDetailsQueryDto> getActionDetailsForId(Long auctionId);

}
