package com.eauction.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eauction.dto.AuctionDetailsDto;
import com.eauction.queryImplDto.AuctionDetailsQueryDto;
import com.eauction.service.AuctionDetailService;

@CrossOrigin
@RestController
@RequestMapping("/autionbidding")
public class AuctionBiddingController {

	@Autowired
	private AuctionDetailService auctionDetlService;

	
	@SuppressWarnings("unchecked")
	@GetMapping("getauctiondetails")
	public List<AuctionDetailsQueryDto> getAuctionDetails(@RequestParam("auctionId") Long auctionId) {
		/*
		 * List<AuctionDetailsDto> auctionList = new ArrayList<>();
		 * auctionDetlService.getAuctionDetails().forEach(auctionDetails -> {
		 * AuctionDetailsDto auctionDetailsDto = new AuctionDetailsDto();
		 * BeanUtils.copyProperties(auctionDetails, auctionDetailsDto);
		 * auctionList.add(auctionDetailsDto); });
		 */
		
		
		if(auctionId != 0)
			return (List<AuctionDetailsQueryDto>) auctionDetlService.getAuctionDetailsForId(auctionId);
		
		return auctionDetlService.getAuctionDetails();
		

	}
	
	@GetMapping("getauctiondetailsforid")
	public List<AuctionDetailsQueryDto> getAuctionDetailsForID(@RequestParam("auctionId") Long auctionId) {

		return auctionDetlService.getAuctionDetailsForId(auctionId);
		

	}

}
