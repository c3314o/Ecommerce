package ecommerce.service.impl;

import ecommerce.domain.BaseEntity;
import ecommerce.form.admin.BaseForm;
import ecommerce.service.CrudService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.repository.CrudRepository;

/**
 * CRUD service.
 *
 * @author Jakub Polák
 */
public abstract class CrudServiceImpl<E extends BaseEntity, F extends BaseForm<E, F>> implements CrudService<E, F> {
    private CrudRepository<E, Long> crudRepository;

    CrudServiceImpl(CrudRepository<E, Long> crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    public E getById(Long id) {
        return crudRepository.findOne(id);
    }

    @Override
    public Iterable getAll() {
        return crudRepository.findAll();
    }

    @Override
    public void save(F form) {
        save(form);
    }

    @Override
    public void save(F form, String... ignoreFormProperties) {
        Long id = form.getId();
        E entity = (id == null) ? form.getNewEntity() : getById(id);

        BeanUtils.copyProperties(form, entity, ignoreFormProperties);

        crudRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        crudRepository.delete(id);
    }
}
