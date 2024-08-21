package com.fsse2309.project_backend.repository;

import com.fsse2309.project_backend.entity.TransactionEntity;
import com.fsse2309.project_backend.entity.TransactionProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends CrudRepository <TransactionEntity, Integer>{
    TransactionEntity findBytid(Integer tid);

    TransactionEntity getByTidAndUserEntity_Uid(Integer tid, Integer id);

}
