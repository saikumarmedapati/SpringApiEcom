package com.sconexsoft.ecom.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sconexsoft.ecom.model.Offer;
import com.sconexsoft.ecom.entity.OfferEntity;
import com.sconexsoft.ecom.repo.OfferRepository;

@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    private OfferRepository offerRepo;

    @Override
    public List<Offer> getAllOffers() {
        return offerRepo.findAll().stream()
                .map(this::convertEntityToModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Offer> getOfferById(Long id) {
        return offerRepo.findById(id).map(this::convertEntityToModel);
    }

    @Override
    public Offer addOffer(Offer offer) {
        OfferEntity entity = convertModelToEntity(offer);
        OfferEntity savedEntity = offerRepo.save(entity);
        return convertEntityToModel(savedEntity);
    }

    @Override
    public Offer updateOffer(Offer offer) {
        OfferEntity entity = convertModelToEntity(offer);
        OfferEntity updatedEntity = offerRepo.save(entity);
        return convertEntityToModel(updatedEntity);
    }

    @Override
    public boolean deleteOffer(Long id) {
        if (offerRepo.existsById(id)) {
            offerRepo.deleteById(id);
            return true;
        }
        return false;
    }

    // Convert OfferEntity to Offer
    private Offer convertEntityToModel(OfferEntity offerEntity) {
        Offer offer = new Offer();
        offer.setId(offerEntity.getId());
        offer.setName(offerEntity.getName());
        offer.setDescription(offerEntity.getDescription());
        offer.setDiscountPercentage(offerEntity.getDiscountPercentage());
        return offer;
    }

    // Convert Offer to OfferEntity
    private OfferEntity convertModelToEntity(Offer offer) {
        OfferEntity offerEntity = new OfferEntity();
        offerEntity.setId(offer.getId());
        offerEntity.setName(offer.getName());
        offerEntity.setDescription(offer.getDescription());
        offerEntity.setDiscountPercentage(offer.getDiscountPercentage());
        return offerEntity;
    }
}
