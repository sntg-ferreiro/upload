package com.magicauction.upload.configuration;

import com.magicauction.upload.entity.CardInfo;
import com.magicauction.upload.entity.ImagesMap;
import com.magicauction.upload.entity.PricesMap;
import com.magicauction.upload.entity.enums.Condition;
import com.magicauction.upload.entity.enums.Version;
import com.magicauction.upload.entity.repositories.CardInfoRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CardInfoRepo repository) {

        /*
        return args -> {
            log.info("Preloading " + repository.save(new CardInfo("Bilbo Baggins",new PricesMap(), new ImagesMap(), Version.FULL_ART, Condition.NEAR_MINT, Boolean.FALSE)));
            log.info("Preloading " + repository.save(new CardInfo("Bilbo Baggins",new PricesMap(), new ImagesMap(), Version.STANDARD, Condition.DESTROYED, Boolean.TRUE)));
            log.info("Preloading " + repository.save(new CardInfo("Frodo Baggins",new PricesMap(), new ImagesMap(), Version.FULL_ART, Condition.NEAR_MINT, Boolean.FALSE)));
            log.info("Preloading " + repository.save(new CardInfo("Samwise Gamgee",new PricesMap(), new ImagesMap(), Version.FULL_ART, Condition.NEAR_MINT, Boolean.FALSE)));
        };
        */
        log.info("pre load script run successfully");
        return args -> {};
    }
}
