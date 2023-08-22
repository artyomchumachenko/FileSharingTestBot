/*
 * Copyright (c) 2023, TopS BI LLC. All rights reserved.
 * http://www.topsbi.ru
 */

package person.chumachenko.service.impl;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import lombok.extern.log4j.Log4j;
import person.chumachenko.controller.UpdateController;
import person.chumachenko.service.AnswerConsumer;

import static person.chumachenko.model.RabbitQueue.ANSWER_MESSAGE;

@Service
@Log4j
public class AnswerConsumerImpl implements AnswerConsumer {

    private final UpdateController updateController;

    public AnswerConsumerImpl(UpdateController updateController) {
        this.updateController = updateController;
    }

    @Override
    @RabbitListener(queues = ANSWER_MESSAGE)
    public void consume(SendMessage sendMessage) {
        updateController.setView(sendMessage);
    }
}
