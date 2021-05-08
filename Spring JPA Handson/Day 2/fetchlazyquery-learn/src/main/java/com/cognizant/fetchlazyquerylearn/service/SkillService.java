package com.cognizant.fetchlazyquerylearn.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.fetchlazyquerylearn.model.Skill;
import com.cognizant.fetchlazyquerylearn.repository.SkillRepository;

import org.slf4j.Logger;


@Service
public class SkillService {
	private static final Logger LOGGER = LoggerFactory.getLogger(SkillService.class);
	@Autowired
	private SkillRepository skillRepository;
	
	@Transactional
	public Skill get(int id)
	{
		LOGGER.info("Start");
		return skillRepository.findById(id).get();
	}
	
	@Transactional
	public void save(Skill skill) {
		LOGGER.info("Start");
		skillRepository.save(skill);
		LOGGER.info("End");
	}
}