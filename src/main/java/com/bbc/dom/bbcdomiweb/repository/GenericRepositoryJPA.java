/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.repository;

import com.bbc.dom.bbcdomiweb.dto.RespuestaDTO;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Set;
import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import javax.persistence.EntityManager;
import javax.persistence.TransactionRequiredException;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

/**
 *
 * @author Christian Gutierrez
 */
public class GenericRepositoryJPA<T> implements GenericRepository<T> {

    protected EntityManager entityManager;
    private Class<T> type;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public GenericRepositoryJPA() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    public T create(final T t) {

        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.getTransaction().commit();
        return t;
    }

    /**
     * Registra un objeto a nivel de persistencia e incluye un manejador de
     * errores
     *
     * @param entity
     * @return RespuestaDTO
     */
    public RespuestaDTO crearPJ(final T entity) {
        RespuestaDTO rdto = new RespuestaDTO();
        try {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            javax.validation.Validator validator = factory.getValidator();
            Set<ConstraintViolation<T>> constraintViolations = validator.validate(entity);
            if (constraintViolations.size() > 0) {
                rdto.setCodigo("JPA004");
                Iterator<ConstraintViolation<T>> iterator = constraintViolations.iterator();
                while (iterator.hasNext()) {
                    ConstraintViolation<T> cv = iterator.next();
                    System.err.println(cv.getRootBeanClass().getName() + "." + cv.getPropertyPath() + " " + cv.getMessage());
                    //JsfUtil.addErrorMessage(cv.getRootBeanClass().getSimpleName() + "." + cv.getPropertyPath() + " " + cv.getMessage());
                }
            } else {

                entityManager.getTransaction().begin();
                entityManager.persist(entity);
                entityManager.getTransaction().commit();
                rdto.setObjet(entity);
            }
        } catch (IllegalArgumentException | EntityExistsException | TransactionRequiredException e) {
            rdto.setCodigo("JPA004");
        } catch (Exception e) {
            throw e;
        }
        return rdto;
    }

    public void delete(final Object objeto) {
        entityManager.remove(entityManager.merge(objeto));
    }

    public T find(final Object id) {
        return (T) entityManager.find(type, id);
    }

    public T persist(final T t) {
        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.getTransaction().commit();
        return t;
    }

    public Iterable<T> findAll() {
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = cb.createQuery(type);
        Root<T> root = criteriaQuery.from(type);
        criteriaQuery.select(root);
        TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
