package ecommerce.service.impl;

import ecommerce.domain.ItemCategory;
import ecommerce.form.admin.ItemCategoryForm;
import ecommerce.repository.ItemCategoryRepository;
import ecommerce.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Item category service.
 *
 * @author Jakub Polák
 */
@Service("itemCategoryService")
public class ItemCategoryServiceImpl extends CrudServiceImpl<ItemCategory, ItemCategoryForm> implements ItemCategoryService {

    @Autowired
    public ItemCategoryServiceImpl(ItemCategoryRepository itemCategoryRepository) {
        super(itemCategoryRepository);
    }
}
