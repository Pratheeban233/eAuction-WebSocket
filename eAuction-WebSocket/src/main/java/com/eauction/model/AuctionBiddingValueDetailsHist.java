package com.eauction.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Data;
import lombok.Getter;

@Entity
@Table(name = "eap_auction_bidding_values_hist")
@Data
public class AuctionBiddingValueDetailsHist implements Serializable {


	private static final long serialVersionUID = 7357970083122456422L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUCTION_BIDDING_VALUES_HIST")
	@SequenceGenerator(sequenceName = "seq_eapauctionbiddingvalues_hist", allocationSize = 1, name = "AUCTION_BIDDING_VALUES_HIST")
	@Column(name = "id")
	private Long biddingValueId;
	
	@Column(name = "auction_id")
	private Long auctionId;
	
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "bidding_value")
	private Long biddingPrice;
	
	@Column(name = "createdby")
	private Long createdBy;

	@JsonFormat(shape = Shape.STRING, pattern = "dd-MMM-yyyy HH:mm:ss")
	@Column(name = "createddate")
	private LocalDateTime createdDateTime;

	@Column(name = "updatedby")
	private Long updatedBy;

	@JsonFormat(shape = Shape.STRING, pattern = "dd-MMM-yyyy HH:mm:ss")
	@Column(name = "updateddate")
	private LocalDateTime updatedDateTime;
	
	

}
