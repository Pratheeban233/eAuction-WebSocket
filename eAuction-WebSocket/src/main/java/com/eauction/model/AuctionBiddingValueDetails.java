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
import org.hibernate.boot.model.relational.Sequence;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;

import lombok.Data;

@Entity
@Table(name = "eap_auction_bidding_values")
@Data
public class AuctionBiddingValueDetails implements Serializable {

	private static final long serialVersionUID = -6742833492839242557L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

//	@UpdateTimestamp
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MMM-yyyy HH:mm:ss")
	@Column(name = "createddate")
	private LocalDateTime createdDateTime;

	@Column(name = "updatedby")
	private Long updatedBy;

//	@UpdateTimestamp
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MMM-yyyy HH:mm:ss")
	@Column(name = "updateddate")
	private LocalDateTime updatedDateTime;

}
