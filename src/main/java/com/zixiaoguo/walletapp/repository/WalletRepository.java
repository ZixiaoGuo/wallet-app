package com.zixiaoguo.walletapp.repository;

import com.zixiaoguo.walletapp.model.Wallet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends CrudRepository<Wallet, Long> {

    Wallet findById(long id);
}
