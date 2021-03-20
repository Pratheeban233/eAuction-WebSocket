package com.eauction.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eauction.model.AuctionBiddingValueDetails;
import com.eauction.model.AuctionBiddingValueDetailsHist;

public interface AuctionBiddingValueDetailsHistRepo extends JpaRepository<AuctionBiddingValueDetailsHist, Long> {

}
