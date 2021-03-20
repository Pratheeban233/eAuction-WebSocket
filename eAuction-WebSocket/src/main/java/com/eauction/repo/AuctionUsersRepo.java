package com.eauction.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eauction.model.AuctionUsers;

public interface AuctionUsersRepo extends JpaRepository<AuctionUsers, Long> {

}
