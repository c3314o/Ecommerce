package ecommerce.service.impl;

import ecommerce.domain.BaseEntity;
import ecommerce.form.admin.BaseForm;
import ecommerce.service.CrudService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Jakub Polák
 */
public abstract class CrudServiceImpl<E extends BaseEntity, F extends BaseForm<E, F>>  implements CrudService<E, F> {
    private static final Log LOG = LogFactory.getLog(CrudServiceImpl.class);
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
    public void deleteById(Long id) {
        crudRepository.delete(id);
    }
}
