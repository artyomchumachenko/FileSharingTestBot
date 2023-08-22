/*
 * Copyright (c) 2023, TopS BI LLC. All rights reserved.
 * http://www.topsbi.ru
 */

package person.chumachenko.service.impl;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import lombok.extern.log4j.Log4j;
import person.chumachenko.dao.RawDataDAO;
import person.chumachenko.entity.RawData;
import person.chumachenko.service.MainService;
import person.chumachenko.service.ProducerService;

@Service
@Log4j
public class MainServiceImpl implements MainService {
    private final RawDataDAO rawDataDAO;
    private final ProducerService producerService;

    public MainServiceImpl(RawDataDAO rawDataDAO, ProducerService producerService) {
        this.rawDataDAO = rawDataDAO;
        this.producerService = producerService;
    }

    @Override
    public void processTextMessage(Update update) {
        saveRawData(update);

        var message = update.getMessage();
        var sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText("Hello from Node");
        producerService.produceAnswer(sendMessage);
    }

    /**
     * Сохранение raw_data объекта через ORM.
     * @param update
     */
    private void saveRawData(Update update) {
        RawData rawData = RawData.builder()
                .event(update)
                .build();
        rawDataDAO.save(rawData);
    }
}
