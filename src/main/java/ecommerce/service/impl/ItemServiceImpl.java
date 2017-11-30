package ecommerce.service.impl;

import ecommerce.domain.Item;
import ecommerce.form.admin.ItemForm;
import ecommerce.repository.ItemCategoryRepository;
import ecommerce.repository.ItemRepository;
import ecommerce.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of item service.
 *
 * @author Jakub Polák
 */
@Service("itemService")
public class ItemServiceImpl extends CrudServiceFormImpl<Item, ItemForm> implements ItemService {
    private ItemCategoryRepository itemCategoryRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, ItemCategoryRepository itemCategoryRepository) {
        super(itemRepository, ItemForm.class);
        this.itemCategoryRepository = itemCategoryRepository;
    }

    @Override
    public ItemForm buildForm() {
        ItemForm itemForm = new ItemForm();
        itemForm.setItemCategories(itemCategoryRepository.findAll());

        return itemForm;
    }

    @Override
    public ItemForm buildForm(ItemForm data) {
        data.setItemCategories(itemCategoryRepository.findAll());

        return data;
    }
}
