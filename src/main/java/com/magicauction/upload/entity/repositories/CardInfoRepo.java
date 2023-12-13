package com.magicauction.upload.entity.repositories;

import com.magicauction.upload.entity.CardInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardInfoRepo extends JpaRepository<CardInfo, Long> {
    public List<CardInfo> findByCardName(String cardName);
}
