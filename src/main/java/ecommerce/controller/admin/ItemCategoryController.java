package ecommerce.controller.admin;

import ecommerce.domain.ItemCategory;
import ecommerce.form.admin.ItemCategoryForm;
import ecommerce.service.ItemCategoryService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
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
    private static final Log log = LogFactory.getLog(ItemCategoryController.class);

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
    public ModelAndView create(
        @Valid  ItemCategoryForm itemCategoryForm,
        BindingResult bindingResult,
        RedirectAttributes redirectAttributes
    ) {
        ModelAndView modelAndView;

        if (bindingResult.hasErrors()) {
            modelAndView = new ModelAndView("admin/item-category/create");
            modelAndView.addObject("error", true);
        } else {
            try {
                modelAndView = new ModelAndView("redirect:/admin/item-category/index");
                redirectAttributes.addFlashAttribute("flashMessage", "admin.category.was-saved");
                redirectAttributes.addFlashAttribute("flashMessageType", "success");

                itemCategoryService.save(itemCategoryForm);
            } catch (Exception e) {
                log.error("Item category could not be saved.", e);
                modelAndView = new ModelAndView("admin/item-category/create");
                modelAndView.addObject("error", true);
            }
        }

        return modelAndView;
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        ItemCategory itemCategory = itemCategoryService.getById(id);

        if (itemCategory == null) {
            redirectAttributes.addFlashAttribute("flashMessage", "admin.category.does-not-exist");
            redirectAttributes.addFlashAttribute("flashMessageType", "danger");
            return new ModelAndView("redirect:/admin/item-category/index");
        }

        ItemCategoryForm itemCategoryForm = new ItemCategoryForm();
        BeanUtils.copyProperties(itemCategory, itemCategoryForm);

        ModelAndView modelAndView = new ModelAndView("admin/item-category/update");
        modelAndView.addObject("itemCategoryForm", itemCategoryForm);

        return modelAndView;
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public ModelAndView update(
        @PathVariable("id") Long id,
        @Valid ItemCategoryForm itemCategoryForm,
        BindingResult bindingResult,
        RedirectAttributes redirectAttributes
    ) {
        ItemCategory itemCategory = itemCategoryService.getById(id);

        if (itemCategory == null) {
            redirectAttributes.addFlashAttribute("flashMessage", "admin.category.does-not-exist");
            redirectAttributes.addFlashAttribute("flashMessageType", "danger");
            return new ModelAndView("redirect:/admin/item-category/index");
        }

        ModelAndView modelAndView;

        if (bindingResult.hasErrors()) {
            modelAndView = new ModelAndView("admin/item-category/update");
            modelAndView.addObject("error", true);
        } else {
            try {
                itemCategoryService.save(itemCategoryForm);
                modelAndView = new ModelAndView("redirect:/admin/item-category/index");
                redirectAttributes.addFlashAttribute("flashMessage", "admin.category.was-saved");
                redirectAttributes.addFlashAttribute("flashMessageType", "success");
            } catch (Exception e) {
                log.error(e);
                modelAndView = new ModelAndView("admin/item-category/update");
                modelAndView.addObject("error", true);
            }
        }

        return modelAndView;
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            itemCategoryService.deleteById(id);
        } catch (Exception e) {
            log.error("Item category could not be deleted.", e);
            redirectAttributes.addFlashAttribute("flashMessage", "admin.category.could-not-be-saved");
            redirectAttributes.addFlashAttribute("flashMessageType", "danger");
        }

        return new ModelAndView("redirect:/admin/item-category/index");
    }
}
