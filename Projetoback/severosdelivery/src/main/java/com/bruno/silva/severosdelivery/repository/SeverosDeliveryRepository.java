package com.bruno.silva.severosdelivery.repository;

import com.bruno.silva.severosdelivery.model.SeverosDeliveryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SeverosDeliveryRepository extends CrudRepository<SeverosDeliveryEntity, Long> { // retorno long


}