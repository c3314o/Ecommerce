package ecommerce.controller.admin;

import ecommerce.domain.Item;
import ecommerce.form.admin.ItemForm;
import ecommerce.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author Jakub Polák
 */
@Controller
public class ItemController extends CrudController<Item, ItemForm> {

    @Autowired
    public ItemController(CrudService<Item, ItemForm> service) {
        super(service, new ItemForm(ItemForm.class, Item.class));
    }
}
