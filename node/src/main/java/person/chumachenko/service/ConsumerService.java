/*
 * Copyright (c) 2023, TopS BI LLC. All rights reserved.
 * http://www.topsbi.ru
 */

package person.chumachenko.service;

import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Интерфейс для считывания сообщений из брокера сообщений.
 * Под каждую очередь брокера будет свой метод.
 */
public interface ConsumerService {
    void consumeTextMessageUpdates(Update update);
    void consumeDocMessageUpdates(Update update);
    void consumePhotoMessageUpdates(Update update);

}
