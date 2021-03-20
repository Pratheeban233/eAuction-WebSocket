package com.eauction.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.eauction.model.AuctionDetails;
import com.eauction.queryImplDto.AuctionDetailsQueryDto;

@Service
public class AuctionDetlIntrImpl implements AuctionDetlIntr {

	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<AuctionDetailsQueryDto> getActionDetailsList() {

		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append(
				"SELECT ead.id as auctionId ,ead.auction_name as auctionName ,ead.starttime as startdateTime, ");
		sqlQuery.append("ead.endtime as endDateTime, eabv.bidding_value as currentBiddingPrice ");
		sqlQuery.append("FROM eap_auction_details ead , eap_auction_bidding_values eabv ");
		sqlQuery.append("WHERE ead.isactive IS true AND ead.id = eabv.auction_id ");

		Query queryResult = entityManager.createNativeQuery(sqlQuery.toString(), "map_AuctionDetailsQueryDto");

		return queryResult.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AuctionDetailsQueryDto> getActionDetailsForId(Long auctionId) {

		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append(
				"SELECT ead.id as auctionId ,ead.auction_name as auctionName ,ead.starttime as startdateTime, ");
		sqlQuery.append("ead.endtime as endDateTime, eabv.bidding_value as currentBiddingPrice ");
		sqlQuery.append("FROM eap_auction_details ead , eap_auction_bidding_values eabv ");
		sqlQuery.append("WHERE ead.isactive IS true AND ead.id = eabv.auction_id AND ead.id=:id");

		Query queryResult = entityManager.createNativeQuery(sqlQuery.toString(), "map_AuctionDetailsQueryDto");
		queryResult.setParameter("id", auctionId);
		return (List<AuctionDetailsQueryDto>) queryResult.getResultList();
	}

}
