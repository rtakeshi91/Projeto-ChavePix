package com.project.ApiPix.Validador;

import com.project.ApiPix.Entities.ChavePixJpa;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ChavePixValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return ChavePixJpa.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ChavePixJpa chavePix = (ChavePixJpa) target;
        switch (chavePix.getTipoChave()) {
            case celular:
                validateCelular(chavePix.getValorChave(), errors);
                break;
            case email:
                validateEmail(chavePix.getValorChave(), errors);
                break;
            case cpf:
                validateCpf(chavePix.getValorChave(), errors);
                break;
            default:
                errors.rejectValue("tipoChave", "TipoChaveInvalido", "Tipo de chave inválido");
        }
    }

    private void validateCelular(String valorChave, Errors errors) {
        // Implementar validação do celular
    }

    private void validateEmail(String valorChave, Errors errors) {
        // Implementar validação do e-mail
    }

    private void validateCpf(String valorChave, Errors errors) {
        // Implementar validação do CPF
    }
}
