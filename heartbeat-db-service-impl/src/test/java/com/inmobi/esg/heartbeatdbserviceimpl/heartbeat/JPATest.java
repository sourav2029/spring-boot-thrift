package com.inmobi.esg.heartbeatdbserviceimpl.heartbeat;

import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.inmobi.esg.heartbeatdbserviceimpl.entity.CountryMeta;
import com.inmobi.esg.heartbeatdbserviceimpl.repository.AdvertiserRepository;
import com.inmobi.esg.heartbeatdbserviceimpl.repository.ChannelMetaRepository;
import com.inmobi.esg.heartbeatdbserviceimpl.repository.CountryMetaRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class JPATest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CountryMetaRepository countryMetaRepository;


    @Test
    public void findByCountryIdTest() {
        CountryMeta countryMeta = new CountryMeta();
        countryMeta.setCountryId(40);
        countryMeta.setCode("BAN");
        countryMeta.setName("BANGLADESH");
        entityManager.persist(countryMeta);
        entityManager.flush();
        CountryMeta found = countryMetaRepository.findByCountryId(countryMeta.getCountryId());

        assert(found.getCountryId() == countryMeta.getCountryId());
    }
}
