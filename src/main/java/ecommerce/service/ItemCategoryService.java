package ecommerce.service;

import ecommerce.domain.ItemCategory;
import ecommerce.form.admin.ItemCategoryForm;

/**
 * Item category service.
 *
 * @author Jakub Polák
 */
public interface ItemCategoryService {
    /**
     * Get item category by it's id.
     *
     * @param id
     * @return item category
     */
    ItemCategory getById(Long id);

    /**
     * Get all item categories.
     *
     * @return item categories
     */
    Iterable<ItemCategory> getAll();

    /**
     * Process item category form and save item category.
     *
     * @param itemCategoryForm item category form
     */
    void save(ItemCategoryForm itemCategoryForm);

    /**
     * Delete item category by it's id.
     *
     * @param id
     */
    void deleteById(Long id);
}
