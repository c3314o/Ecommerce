package ecommerce.service.impl;

import ecommerce.domain.Item;
import ecommerce.form.admin.ItemForm;
import ecommerce.repository.ItemRepository;
import ecommerce.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of item service.
 *
 * @author Jakub Polák
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item getById(Long id) {
        return null;
    }

    @Override
    public List<Item> getAll() {
        return null;
    }

    @Override
    public void save(ItemForm itemForm) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
