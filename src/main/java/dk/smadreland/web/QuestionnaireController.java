package dk.smadreland.web;

import dk.smadreland.model.Questionnaire;
import dk.smadreland.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/questionnaire")
public class QuestionnaireController {
    @Autowired
    QuestionnaireService questionnaireService;

    @GetMapping("/{id}")
    public String root(Model model, @PathVariable String id) {

        Questionnaire questionnaire = questionnaireService.find(Long.valueOf(id));

        model.addAttribute("questionnaire", questionnaire);
        return "questionnaire/index";
    }

    @GetMapping("/{id}/{questionId}")
    public String root(Model model, @PathVariable String id, @PathVariable String questionId) {

        Questionnaire questionnaire = questionnaireService.find(Long.valueOf(id));

        model.addAttribute("questionnaire", questionnaire);
        model.addAttribute("questionId", Long.valueOf(questionId));

        return "questionnaire/question";
    }
}
