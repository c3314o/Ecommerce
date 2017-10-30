package ecommerce.form.admin;

import ecommerce.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Jakub Polák
 */
@Data
public abstract class BaseForm<E extends BaseEntity, F extends BaseForm<E, F>> {
    private static final Log LOG = LogFactory.getLog(BaseForm.class);
    private Long id;
    private final Class<F> classForm;
    private final Class<E> classEntity;

    public BaseForm(Class<F> classForm, Class<E> classEntity) {
        this.classForm = classForm;
        this.classEntity = classEntity;
    }

    public E getNewEntity() {
        try {
            return classEntity.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            LOG.error("Could not create a new entity.", e);
            throw new RuntimeException(e);
        }
    }

    public F getNewForm() {
        try {
            return classForm.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            LOG.error("Could not create a new form.", e);
            throw new RuntimeException(e);
        }
    }
}
