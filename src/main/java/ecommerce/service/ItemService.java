package ecommerce.service;

import ecommerce.domain.Item;
import ecommerce.form.admin.ItemForm;

/**
 * Item service.
 *
 * @author Jakub Polák
 */
public interface ItemService {
    /**
     * Get item by it's id.
     *
     * @param id
     * @return item
     */
    Item getById(Long id);

    /**
     * Get all items.
     *
     * @return items
     */
    Iterable<Item> getAll();

    /**
     * Process item form and save item.
     *
     * @param itemForm item form
     */
    void save(ItemForm itemForm);

    /**
     * Delete item by it's id.
     *
     * @param id
     */
    void deleteById(Long id);
}
