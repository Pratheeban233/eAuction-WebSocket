package com.eauction.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Data;

@Entity
@Table(name = "eap_auction_details")
@Data
public class AuctionDetails implements Serializable {

	private static final long serialVersionUID = -4536722827101484587L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long auctionId;

	@Column(name = "auction_name")
	private String auctionName;

	@Column(name = "auction_desc")
	private String auctionDesc;

	@Column(name = "auction_status")
	private boolean isAuctionStatus;

	@Column(name = "starttime")
	private LocalDateTime startdateTime;

	@Column(name = "endtime")
	private LocalDateTime endDateTime;

	@Column(name = "extended_endtime")
	private LocalDateTime extendedEndDateTime;

	@Column(name = "isactive")
	private boolean isActive;

	@Column(name = "startprice")
	private long startPrice;

	@Column(name = "increment_price")
	private long incrementPrice;

	@Column(name = "reserved_price")
	private long reservedPrice;

	@Column(name = "maxseal_price")
	private long maxSealPrice;

	@Column(name = "createdby")
	private long createdBy;

	@JsonFormat(shape = Shape.STRING, pattern = "dd-MMM-yyyy HH:mm:ss")
	@Column(name = "createddate")
	private LocalDateTime createdDateTime;

	@Column(name = "updatedby")
	private long updatedBy;

	@JsonFormat(shape = Shape.STRING, pattern = "dd-MMM-yyyy HH:mm:ss")
	@Column(name = "updateddate")
	private LocalDateTime updatedDateTime;

}
