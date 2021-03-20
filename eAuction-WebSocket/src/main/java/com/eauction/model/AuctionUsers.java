package com.eauction.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "eap_auction_users")
@Data
public class AuctionUsers implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7682699677675663171L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long auctionUserId;
	
	@Column(columnDefinition = "user_id")
	private long userID;
	
	@Column(name = "user_name")
	private String userName;

}
