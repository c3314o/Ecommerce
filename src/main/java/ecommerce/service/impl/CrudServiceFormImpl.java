package ecommerce.service.impl;

import ecommerce.domain.BaseEntity;
import ecommerce.form.admin.BaseForm;
import ecommerce.service.CrudServiceForm;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.repository.CrudRepository;

/**
 * CRUD service.
 *
 * @author Jakub Polák
 */
public abstract class CrudServiceFormImpl<E extends BaseEntity, F extends BaseForm<E, F>> extends CrudServiceImpl<E, F> implements CrudServiceForm<E, F> {
    private static final Log LOG = LogFactory.getLog(CrudServiceFormImpl.class);
    private CrudRepository<E, Long> crudRepository;
    private final Class<F> classForm;

    CrudServiceFormImpl(CrudRepository<E, Long> crudRepository, Class<F> classForm) {
        super(crudRepository);
        this.crudRepository = crudRepository;
        this.classForm = classForm;
    }

    @Override
    public void save(F form, String... ignoreFormProperties) {
        Long id = form.getId();
        E entity = (id == null) ? form.getNewEntity() : getById(id);

        BeanUtils.copyProperties(form, entity, ignoreFormProperties);

        crudRepository.save(entity);
    }

    @Override
    public F buildForm() {
        try {
            return classForm.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            LOG.error("Could not create a new form.", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public F buildForm(F data) {
        return data;
    }
}
