package com.magicauction.upload.entity;




import com.magicauction.upload.entity.enums.Condition;
import com.magicauction.upload.entity.enums.Version;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigInteger;
import java.util.Objects;

@Entity
public class CardInfo {
    /**
     * ESTA CLASE DEBERIA DEFINIR TODA LA DATA NECESARIA PARA CERRRRRRAR UNA VENTA/TRADE DE CUALQUIER CARTA
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private BigInteger id;

    @Column(name = "card_name")
    private String cardName;
    @Column(name = "prices_map")
    private PricesMap pricesMap;
    @Column(name = "images_map")
    private ImagesMap imagesMap;
    //ENUMS PODRIAN SER TABLAS A FUTURO
    @Column(name = "card_version")
    private Version card_version;
    @Column(name = "card_condition")
    private Condition card_condition;
    @Column(name = "is_foil")
    private boolean isFoil;

    public CardInfo() {
    }

    public CardInfo(String cardName, PricesMap pricesMap, ImagesMap imagesMap, Version version, Condition condition, Boolean isFoil) {
        this.cardName = cardName;
        this.pricesMap = pricesMap;
        this.imagesMap = imagesMap;
        this.card_version = version;
        this.card_condition = condition;
        this.isFoil = isFoil;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public PricesMap getPricesMap() {
        return pricesMap;
    }

    public void setPricesMap(PricesMap pricesMap) {
        this.pricesMap = pricesMap;
    }

    public ImagesMap getImagesMap() {
        return imagesMap;
    }

    public void setImagesMap(ImagesMap imagesMap) {
        this.imagesMap = imagesMap;
    }

    public Version getCard_version() {
        return card_version;
    }

    public void setCard_version(Version card_version) {
        this.card_version = card_version;
    }

    public Condition getCard_condition() {
        return card_condition;
    }

    public void setCard_condition(Condition card_condition) {
        this.card_condition = card_condition;
    }

    public Boolean getFoil() {
        return isFoil;
    }

    public void setFoil(Boolean foil) {
        isFoil = foil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardInfo cardInfo = (CardInfo) o;
        return Objects.equals(cardName, cardInfo.cardName) && Objects.equals(pricesMap, cardInfo.pricesMap) && Objects.equals(imagesMap, cardInfo.imagesMap) && card_version == cardInfo.card_version && card_condition == cardInfo.card_condition && Objects.equals(isFoil, cardInfo.isFoil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardName, pricesMap, imagesMap, card_version, card_condition, isFoil);
    }

    @Override
    public String toString() {
        return "CardInfo{" +
                "id=" + id +
                ", cardName='" + cardName + '\'' +
                ", pricesMap=" + pricesMap +
                ", imagesMap=" + imagesMap +
                ", version=" + card_version +
                ", condition=" + card_condition +
                ", isFoil=" + isFoil +
                '}';
    }
}
