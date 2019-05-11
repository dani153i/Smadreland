package dk.smadreland.service;

import dk.smadreland.model.Questionnaire;
import dk.smadreland.repository.IQuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionnaireService implements IQuestionnaireService {
    @Autowired
    IQuestionnaireRepository questionnaireRepository;

    @Override
    public Questionnaire find(Long id) {
        return questionnaireRepository.findById(id).get();
    }

    @Override
    public List<Questionnaire> list() {
        return questionnaireRepository.findAll();
    }

    @Override
    public Questionnaire save(Questionnaire questionnaire) {
        return questionnaireRepository.save(questionnaire);
    }

    @Override
    public void remove(Long id) {
        questionnaireRepository.deleteById(id);
    }
}
