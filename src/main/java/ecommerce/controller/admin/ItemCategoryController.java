package ecommerce.controller.admin;

import ecommerce.controller.admin.mapping.Mapping;
import ecommerce.domain.ItemCategory;
import ecommerce.form.admin.ItemCategoryForm;
import ecommerce.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Item category controller.
 *
 * @author Jakub Polák
 */
@Controller
@RequestMapping(CrudController.BASE_URL + "/item-category")
public class ItemCategoryController extends CrudController<ItemCategory, ItemCategoryForm> {

    @Autowired
    public ItemCategoryController(CrudService<ItemCategory, ItemCategoryForm> service) {
        super(service, new ItemCategoryForm(ItemCategoryForm.class, ItemCategory.class), Mapping.ITEM_CATEGORY);
    }
}
