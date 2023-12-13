package com.magicauction.upload.controller.interfaces;

import com.magicauction.upload.entity.CardInfo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUploadController {
    ResponseEntity<List<CardInfo>> getCardInfoByName(String cardName);
    ResponseEntity<List<CardInfo>> getAllCardInfo();
    ResponseEntity<CardInfo> createCardInfo(CardInfo newCardInfo);
    ResponseEntity<CardInfo> updateCardInfo(CardInfo newCardInfo, Long id);
    ResponseEntity<Boolean> deleteCardInfo(Long id);
}
