package com.sotnikoff.secondhand.repository;

import com.sotnikoff.secondhand.data.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListingRepository extends JpaRepository<Listing, Long> {
}