package com.magicauction.upload.controller;

import com.magicauction.upload.configuration.LoadDatabase;
import com.magicauction.upload.controller.interfaces.IUploadController;
import com.magicauction.upload.entity.CardInfo;
import com.magicauction.upload.entity.repositories.CardInfoRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
public class UploadController implements IUploadController {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    private CardInfoRepo cardInfoRepo;

    @Autowired
    public UploadController(CardInfoRepo cardInfoRepo) {
        this.cardInfoRepo = cardInfoRepo;
    }

    @GetMapping("/card/{cardName}")
    @Override
    public ResponseEntity<List<CardInfo>> getCardInfoByName(@PathVariable String cardName) {
        return ResponseEntity.ok(cardInfoRepo.findByCardName(cardName));
    }

    @GetMapping("/card")
    @Override
    public ResponseEntity<List<CardInfo>> getAllCardInfo() {
        return ResponseEntity.ok(cardInfoRepo.findAll());
    }

    @PostMapping("/card")
    @Override
    public ResponseEntity<CardInfo> createCardInfo(@RequestBody CardInfo newCardInfo) {
        return ResponseEntity.ok(cardInfoRepo.save(newCardInfo));
    }

    @PutMapping("/card/{id}")
    @Override
    public ResponseEntity<CardInfo> updateCardInfo(@RequestBody CardInfo cardInfo, @PathVariable Long id) {
        return ResponseEntity.ok(cardInfoRepo.findById(id)
                .map(c -> {
                    c.setCardName(cardInfo.getCardName());
                    c.setImagesMap(cardInfo.getImagesMap());
                    c.setPricesMap(cardInfo.getPricesMap());
                    return cardInfoRepo.save(c);
                })
                .orElseGet(() -> {
                    cardInfo.setId(BigInteger.valueOf(id));
                    return cardInfoRepo.save(cardInfo);
                }));
    }

    @Override
    @DeleteMapping("/card/{id}")
    public ResponseEntity<Boolean> deleteCardInfo(@PathVariable Long id) {
        cardInfoRepo.deleteById(id);
        return ResponseEntity.ok(Boolean.TRUE);
    }
}
