package ecommerce.service;

import ecommerce.domain.BaseEntity;
import ecommerce.form.admin.BaseForm;

/**
 * @author Jakub Polák
 */
public interface CrudServiceForm<E extends BaseEntity, F extends BaseForm<E, F>> extends CrudService<E, F> {
    /**
     * Save entity with ignored form properties.
     *
     * @param form entity form
     * @param ignoreFormProperties form properties to be ignored when copying form attributes to entity attributes.
     */
    void save(F form, String... ignoreFormProperties);

    /**
     * Build form for creating a new entity.
     *
     * @return form
     */
    F buildForm();

    /**
     * Build form creating a new entity or updating an existing entity.
     *
     * @param data default form data
     * @return form
     */
    F buildForm(F data);
}
