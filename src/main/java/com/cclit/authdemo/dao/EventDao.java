package com.cclit.authdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cclit.authdemo.bean.EventEntity;

/**
 *  Event Entity Repository
 *  
 *  @author GalenLin
 */
public interface EventDao extends JpaRepository<EventEntity, String> {

}
