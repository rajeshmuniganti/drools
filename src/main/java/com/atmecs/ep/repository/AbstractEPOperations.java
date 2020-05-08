package com.atmecs.ep.repository;

import com.google.common.collect.Sets;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Transactional(value = "userTransactionManager")
public abstract class AbstractEPOperations<T extends Serializable> implements EPOperations<T> {

    protected abstract CrudRepository<T, Serializable> getDao();

    @Override
    public T findOne(@NotNull long v) {
        return getDao().findById(v).orElse(null);
    }

    @Override
    public Set<T> findAll() {
        return Sets.newHashSet(getDao().findAll());
    }

    @Override
    public T create(T entity) {
        return getDao().save(entity);
    }

    @Override
    public T update(T entity) {
        return getDao().save(entity);
    }

    @Override
    public void delete(T entity) {
        getDao().delete(entity);
    }

    @Override
    public void deleteById(long entityId) {
        getDao().deleteById(entityId);
    }

}
