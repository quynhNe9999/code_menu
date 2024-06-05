package com.quynhtd.source_code_final.validator;

import java.util.Locale;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.quynhtd.source_code_final.dao.AppUserDAO;
import com.quynhtd.source_code_final.entity.AppUser;
import com.quynhtd.source_code_final.form.AppUserForm;
 
@Component
public class AppUserValidator implements Validator {
 
    // common-validator library.
    private EmailValidator emailValidator = EmailValidator.getInstance();
 
    
    private final MessageSource messageSource;

    public AppUserValidator(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    @Autowired
    private AppUserDAO appUserDAO;
 
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == AppUserForm.class;
    }
 
    @Override
    public void validate(Object target, Errors errors) {
        
        AppUserForm form = (AppUserForm) target;
          
        Locale locale = LocaleContextHolder.getLocale();

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.required",
                messageSource.getMessage("email.required", null, locale));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "userName.required",
                messageSource.getMessage("userName.required", null, locale));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.required",
                messageSource.getMessage("firstName.required", null, locale));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName.required",
                messageSource.getMessage("lastName.required", null, locale));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required",
                messageSource.getMessage("password.required", null, locale));
    
 
        if (errors.hasErrors()) {
            return;
        }
 
        if (!emailValidator.isValid(form.getEmail())) {
              
            errors.rejectValue("email", "", "Email is not valid");
            return;
        }
 
        AppUser userAccount = appUserDAO.findAppUserByUserName( form.getUserName());
        if (userAccount != null) {
            if (form.getUserId() == null) {
            	errors.rejectValue("userName", "", messageSource.getMessage("user.name.not.available", null, locale));
                return;
            } else if (!form.getUserId().equals(userAccount.getUserId() )) {
            	errors.rejectValue("userName", "", messageSource.getMessage("user.name.not.available", null, locale));
                return;
            }
        }
 
        userAccount = appUserDAO.findByEmail(form.getEmail());
        if (userAccount != null) {
            if (form.getUserId() == null) {
            	errors.rejectValue("email", "", messageSource.getMessage("email.not.available", null, locale));
                return;
            } else if (!form.getUserId().equals(userAccount.getUserId() )) {
            	errors.rejectValue("email", "", messageSource.getMessage("email.not.available", null, locale));
                return;
            }
        }
    }
 
}