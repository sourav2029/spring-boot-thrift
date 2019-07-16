package com.inmobi.esg.heartbeatdbservice.impl.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inmobi.esg.heartbeatdbservice.impl.entity.IODetails;


@Repository
@Transactional
public interface IODetailsRepository extends JpaRepository<IODetails, Integer> {
    List<IODetails> findByAdvertiserId(final int advertiserId);

    IODetails findByIoDetailId(final int ioDetailId);

    IODetails findByIoId(final String ioId);
}
