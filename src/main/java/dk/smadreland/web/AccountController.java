package dk.smadreland.web;

import dk.smadreland.constraint.AccountRegistrationDto;
import dk.smadreland.model.Account;
import dk.smadreland.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @GetMapping("/list")
    public String userIndex() {
        return "/account/index";
    }

    @ModelAttribute("accountRegistrationDto")
    public AccountRegistrationDto accountRegistrationDto() {
        return new AccountRegistrationDto();
    }

    @GetMapping("/registration")
    public String displayAccountRegistration(Model model) {
        return "/account/registration";
    }

    @PostMapping("/registration")
    public String registerAccount(@ModelAttribute("accountRegistrationDto") @Valid AccountRegistrationDto accountDto, BindingResult result) {
        Account account = accountService.findByEmail(accountDto.getEmail());

        if(account != null) {
            result.rejectValue("email", null, "There is already an account registered using email: " + accountDto.getEmail());
        }

        if(result.hasErrors()) {
            return "/account//registration";
        }

        accountService.save(accountDto);
        return "redirect:/account/registration?success";
    }
}
