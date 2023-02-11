package com.sotnikoff.secondhand.data.sevices;

import com.sotnikoff.secondhand.data.Listing;
import com.sotnikoff.secondhand.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListingService {

    @Autowired
    private ListingRepository listingRepository;

    public List<Listing> getAllListings() {
        return listingRepository.findAll();
    }

    public Listing getListingById(Long id) {
        return listingRepository.findById(id).orElse(null);
    }

    public Listing createListing(Listing listing) {
        return listingRepository.save(listing);
    }

    public void deleteListing(Long id) {
        listingRepository.deleteById(id);
    }
}