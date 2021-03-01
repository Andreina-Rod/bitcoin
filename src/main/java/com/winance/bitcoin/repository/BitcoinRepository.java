package com.winance.bitcoin.repository;

import com.winance.bitcoin.model.Bitcoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;

@Repository
public interface BitcoinRepository extends JpaRepository<Bitcoin, Long> {

    Bitcoin findByModifiedDate(Date modifiedDate);
    Collection<Bitcoin> findAllByModifiedDateBetween(Date date1, Date date2);
}
