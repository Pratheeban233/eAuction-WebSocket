package com.eauction.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AuctionDetailsDto {

	private Long auctionId;

	private String auctionName;

	private String auctionDesc;

	private boolean isAuctionStatus;

	private LocalDateTime startdateTime;

	private LocalDateTime endDateTime;

	private LocalDateTime extendedEndDateTime;

	private boolean isActive;

	private long startPrice;

	private int incrementPrice;

	private long reservedPrice;

	private long maxSealPrice;

	private long createdBy;

	private LocalDateTime createdDateTime;

	private long updatedBy;

	private LocalDateTime updatedDateTime;

}

