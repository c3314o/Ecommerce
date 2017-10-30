package ecommerce.controller.admin;

import ecommerce.domain.ItemCategory;
import ecommerce.form.admin.ItemCategoryForm;
import ecommerce.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Item category controller.
 *
 * @author Jakub Polák
 */
@Controller
public class ItemCategoryController extends CrudController<ItemCategory, ItemCategoryForm> {

    @Autowired
    public ItemCategoryController(CrudService<ItemCategory, ItemCategoryForm> service) {
        super(service, new ItemCategoryForm(ItemCategoryForm.class, ItemCategory.class));
    }
}
