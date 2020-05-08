package com.atmecs.ep.repository;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

public interface EPOperations<T extends Serializable> {

    T findOne(@NotNull final long v);

    Set<T> findAll();

    T create(final T entity);

    T update(final T entity);

    void delete(final T entity);

    void deleteById(final long entityId);
}
