package ecommerce.service;

import ecommerce.domain.BaseEntity;
import ecommerce.form.admin.BaseForm;

/**
 * @author Jakub Polák
 */
public interface CrudService<E extends BaseEntity, F extends BaseForm<E, F>> {
    /**
     * Get entity by id
     *
     * @param id entity id
     * @return entity
     */
    E getById(Long id);

    /**
     * Get all entities
     *
     * @return entities
     */
    Iterable<E> getAll();

    /**
     * Delete entity by id
     *
     * @param id entity id
     */
    void deleteById(Long id);
}
