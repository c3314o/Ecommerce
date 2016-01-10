package ecommerce.service.impl;

import ecommerce.domain.ItemCategory;
import ecommerce.form.admin.ItemCategoryForm;
import ecommerce.repository.ItemCategoryRepository;
import ecommerce.service.ItemCategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of item category service.
 *
 * @author Jakub Polák
 */
@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {
    @Autowired
    ItemCategoryRepository itemCategoryRepository;

    @Override
    public ItemCategory getById(Long id) {
        return itemCategoryRepository.findOne(id);
    }

    @Override
    public Iterable<ItemCategory> getAll() {
        return itemCategoryRepository.findAll();
    }

    @Override
    public void save(ItemCategoryForm itemCategoryForm) {
        Long id = itemCategoryForm.getId();
        ItemCategory itemCategory = (id == null) ? new ItemCategory() : getById(id);
        BeanUtils.copyProperties(itemCategoryForm, itemCategory);
        itemCategoryRepository.save(itemCategory);
    }

    @Override
    public void deleteById(Long id) {
        itemCategoryRepository.delete(id);
    }
}
