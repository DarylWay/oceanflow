package com.wei.oceanflow.support.dao;


import com.wei.oceanflow.support.domain.MessageTemplate;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * 消息模板Dao
 * @author 3y
 */
public interface MessageTemplateDao extends JpaRepository<MessageTemplate, Long> {

}
