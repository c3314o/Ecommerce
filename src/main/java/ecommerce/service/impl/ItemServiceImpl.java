package ecommerce.service.impl;

import ecommerce.domain.Item;
import ecommerce.form.admin.ItemForm;
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
public class ItemServiceImpl extends CrudServiceImpl<Item, ItemForm> implements ItemService {

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        super(itemRepository);
    }
}
