package com.eauction.queryImplDto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Data;

@Entity
@Data
@SqlResultSetMapping(name = "map_AuctionDetailsQueryDto", classes = @ConstructorResult(targetClass = AuctionDetailsQueryDto.class, columns = {
		@ColumnResult(name = "auctionId", type = Long.class), @ColumnResult(name = "auctionName", type = String.class),
		@ColumnResult(name = "startdateTime", type = LocalDateTime.class),
		@ColumnResult(name = "endDateTime", type = LocalDateTime.class),
		@ColumnResult(name = "currentBiddingPrice", type = Long.class) }))

public class AuctionDetailsQueryDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private long auctionId;
	private String auctionName;
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MMM-yyyy HH:mm:ss")
	private LocalDateTime startdateTime;
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MMM-yyyy HH:mm:ss")
	private LocalDateTime endDateTime;
	private long currentBiddingPrice;

	public AuctionDetailsQueryDto() {
		super();
	}

	public AuctionDetailsQueryDto(long auctionId, String auctionName, LocalDateTime startdateTime,
			LocalDateTime endDateTime, long currentBiddingPrice) {
		super();
		this.auctionId = auctionId;
		this.auctionName = auctionName;
		this.startdateTime = startdateTime;
		this.endDateTime = endDateTime;
		this.currentBiddingPrice = currentBiddingPrice;
	}

}
