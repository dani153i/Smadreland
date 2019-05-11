package dk.smadreland.repository;

import dk.smadreland.model.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuestionnaireRepository extends JpaRepository<Questionnaire, Long> {

}
