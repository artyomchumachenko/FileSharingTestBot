/*
 * Copyright (c) 2023, TopS BI LLC. All rights reserved.
 * http://www.topsbi.ru
 */

package person.chumachenko.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import person.chumachenko.entity.RawData;

/**
 * Слой для работы с базой данных.
 */
public interface RawDataDAO extends JpaRepository<RawData, Long> {
}
