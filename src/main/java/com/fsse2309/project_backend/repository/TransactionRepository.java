package com.fsse2309.project_backend.repository;

import com.fsse2309.project_backend.entity.TransactionEntity;
import com.fsse2309.project_backend.entity.TransactionProductEntity;
import com.fsse2309.project_backend.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends CrudRepository <TransactionEntity, Integer>{
    List<TransactionEntity> findAllByUserEntity(UserEntity userEntity);

    TransactionEntity getByTidAndUserEntity_Uid(Integer tid, Integer id);

    TransactionEntity getByStripeSessionIdAndUserEntity_Uid(String ssid, Integer id);

}
