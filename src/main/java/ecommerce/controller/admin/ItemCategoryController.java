package ecommerce.controller.admin;

import ecommerce.domain.ItemCategory;
import ecommerce.form.admin.ItemCategoryForm;
import ecommerce.service.ItemCategoryService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Item category controller.
 *
 * @author Jakub Polák
 */
@Controller
@RequestMapping("/admin/item-category")
public class ItemCategoryController {
    private static final Log logger = LogFactory.getLog(ItemCategoryController.class);

    @Autowired
    private ItemCategoryService itemCategoryService;

    @RequestMapping("/index")
    public ModelAndView index() {
        Iterable<ItemCategory> itemCategories = itemCategoryService.getAll();
        ModelAndView modelAndView = new ModelAndView("admin/item-category/index");
        modelAndView.addObject("itemCategories", itemCategories);

        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create() {
        ItemCategoryForm itemCategoryForm = new ItemCategoryForm();

        ModelAndView modelAndView = new ModelAndView("admin/item-category/create");
        modelAndView.addObject("itemCategoryForm", itemCategoryForm);

        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@Valid  ItemCategoryForm itemCategoryForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView;

        if (bindingResult.hasErrors()) {
            modelAndView = new ModelAndView("admin/item-category/create");
            modelAndView.addObject("error", Boolean.TRUE);
        } else {
            try {
                modelAndView = new ModelAndView("redirect:/admin/item-category/index");
                redirectAttributes.addFlashAttribute("flashMessage", "admin.category.was-saved");
                redirectAttributes.addFlashAttribute("flashMessageType", "success");

                itemCategoryService.save(itemCategoryForm);
            } catch (Exception e) {
                logger.error(e);

                modelAndView = new ModelAndView("admin/item-category/create");
                modelAndView.addObject("error", Boolean.TRUE);
            }
        }

        return modelAndView;
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView update() {
        return null;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(@Valid ItemCategoryForm itemCategoryForm) {
        return null;
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable Long id) {
        return null;
    }
}
