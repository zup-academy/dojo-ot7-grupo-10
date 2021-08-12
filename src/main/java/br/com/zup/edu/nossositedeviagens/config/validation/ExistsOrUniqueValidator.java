package br.com.zup.edu.nossositedeviagens.config.validation;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistsOrUniqueValidator implements ConstraintValidator<ExistsOrUnique, Object> {

    private String field;
    private Class<?> entity;
    private boolean unique;

    private EntityManager em;

    public ExistsOrUniqueValidator(EntityManager em) {
        this.em = em;
    }

    @Override
    public void initialize(ExistsOrUnique constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.entity = constraintAnnotation.entity();
        this.unique = constraintAnnotation.unique();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        String jpql = "SELECT c FROM " +entity.getName()+ " c WHERE " +field+ "= :pValue";
        Query query = em.createQuery(jpql);
        query.setParameter("pValue", value);
        List<?> resultList = query.getResultList();

        if(unique)
            return resultList.isEmpty();

        return !resultList.isEmpty();
    }
}
