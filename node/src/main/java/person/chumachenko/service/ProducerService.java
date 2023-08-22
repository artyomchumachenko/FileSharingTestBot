/*
 * Copyright (c) 2023, TopS BI LLC. All rights reserved.
 * http://www.topsbi.ru
 */

package person.chumachenko.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

/**
 * Интерфейс для отправки ответов с node в брокер сообщений.
 */
public interface ProducerService {
    void produceAnswer(SendMessage sendMessage);
}
