package net.slipp.web;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
	//springframework will make it's implemented instance
}
