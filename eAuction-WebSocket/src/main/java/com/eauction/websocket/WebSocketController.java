package com.eauction.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eauction.constant.Constants;
import com.eauction.model.AuctionBiddingValueDetails;
import com.eauction.service.AuctionBiddingValueDetailService;
import com.eauction.service.AuctionDetailService;

@CrossOrigin
@RestController
@RequestMapping("ws")
public class WebSocketController {

	@Autowired
	private AuctionDetailService auctionDetailservice;

	@Autowired
	AuctionBiddingValueDetailService auctionBiddingValueDetailService;

	/*
	 * @MessageMapping("/hello")
	 * 
	 * @SendTo("/topic/greetings") public Greeting
	 * greeting(AuctionBiddingValueDetails biddingValueDetails) {
	 * 
	 * // auctionDetailservice.saveOrUpdateBidderDetails(biddingValueDetails); //
	 * auctionDetailservice.saveBidderDetailsInHist(biddingValueDetails);
	 * 
	 * return new Greeting(biddingValueDetails.getAuctionId() + " | " +
	 * biddingValueDetails.getUserId() + " | " +
	 * biddingValueDetails.getBiddingPrice()); }
	 * 
	 */
	private SimpMessagingTemplate template;

	@Autowired
	public WebSocketController(SimpMessagingTemplate template) {
		this.template = template;
	}

	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public Object performBidding(@RequestBody AuctionBiddingValueDetails biddingValueDetails) throws Exception {

		String err = null;
		if ((err = auctionBiddingValueDetailService.validateBidderInputs(biddingValueDetails, err)) != null)
			return err;

		auctionDetailservice.saveOrUpdateBidderDetails(biddingValueDetails);
		auctionDetailservice.saveBidderDetailsInHist(biddingValueDetails);

		MessageChannel messageChannel = template.getMessageChannel();
		System.out.println(messageChannel.toString());

		this.template.convertAndSend("/topic/greetings", biddingValueDetails);
		return biddingValueDetails;

	}
}
