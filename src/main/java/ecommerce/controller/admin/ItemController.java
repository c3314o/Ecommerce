package ecommerce.controller.admin;

import ecommerce.controller.admin.mapping.Mapping;
import ecommerce.domain.Item;
import ecommerce.form.admin.ItemForm;
import ecommerce.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Item controller.
 *
 * @author Jakub Polák
 */
@Controller
@RequestMapping(CrudController.BASE_URL + "/item")
public class ItemController extends CrudController<Item, ItemForm> {
    @Autowired
    public ItemController(ItemService itemService) {
        super(itemService, Mapping.ITEM);
    }
}
