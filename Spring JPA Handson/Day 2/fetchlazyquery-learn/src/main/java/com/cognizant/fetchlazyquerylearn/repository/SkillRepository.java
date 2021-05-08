package com.cognizant.fetchlazyquerylearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.fetchlazyquerylearn.model.Skill;

public interface SkillRepository extends JpaRepository<Skill,Integer> {

}
