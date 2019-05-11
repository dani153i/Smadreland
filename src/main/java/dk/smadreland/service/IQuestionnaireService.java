package dk.smadreland.service;

import dk.smadreland.constraint.AccountRegistrationDto;
import dk.smadreland.model.Account;
import dk.smadreland.model.Questionnaire;
import dk.smadreland.repository.IQuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IQuestionnaireService {
    public Questionnaire find(Long id);
    public List<Questionnaire> list();
    public Questionnaire save(Questionnaire questionnaire);
    public void remove(Long id);
}
