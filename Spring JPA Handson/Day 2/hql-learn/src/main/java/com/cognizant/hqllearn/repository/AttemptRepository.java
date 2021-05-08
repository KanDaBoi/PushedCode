package com.cognizant.hqllearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.hqllearn.model.Attempt;

public interface AttemptRepository extends JpaRepository<Attempt,Integer>{
	@Query("select u.a from User u left join fetch u.attemptList a left join fetch a.attemptQuestionList aq left join fetch aq.questionFromAQ qaq left join fetch aq.attemptOptionList aol left join fetch qaq.options where u.id=?1 and a.id=?2 ")
	public Attempt getAttempt(int userId,int attemptId);
}
