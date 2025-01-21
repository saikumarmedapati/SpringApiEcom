package com.sconexsoft.ecom.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sconexsoft.ecom.entity.OfferEntity;

public interface OfferRepository extends JpaRepository<OfferEntity, Long> {
}
