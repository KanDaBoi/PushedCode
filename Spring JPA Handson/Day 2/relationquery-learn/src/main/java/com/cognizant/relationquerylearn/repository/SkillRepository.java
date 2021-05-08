package com.cognizant.relationquerylearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.relationquerylearn.model.Skill;

public interface SkillRepository extends JpaRepository<Skill,Integer> {

}
