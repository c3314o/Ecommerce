package ecommerce.controller.admin;

import ecommerce.domain.Item;
import ecommerce.form.admin.ItemForm;
import ecommerce.service.ItemService;
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
 * @author Jakub Polák
 */
@Controller
@RequestMapping(ItemController.BASE_URL)
public class ItemController {
    private static final Log LOG = LogFactory.getLog(ItemController.class);
    static final String BASE_URL = "/admin/item/";
    private static final String CREATE_URL = BASE_URL + "create";
    private static final String UPDATE_URL = BASE_URL + "{id}/update";
    private static final String DELETE_URL = BASE_URL + "{id}/delete";

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView index() {
        Iterable<Item> items = itemService.getAll();
        ModelAndView modelAndView = new ModelAndView("admin/item/index");
        modelAndView.addObject("items", items);

        return modelAndView;
    }

    @RequestMapping(value = CREATE_URL, method = RequestMethod.GET)
    public ModelAndView create() {
        ItemForm itemForm = new ItemForm();

        ModelAndView modelAndView = new ModelAndView("admin/item/create");
        modelAndView.addObject("itemForm", itemForm);

        return modelAndView;
    }

    @RequestMapping(value = CREATE_URL, method = RequestMethod.POST)
    public ModelAndView create(
        @Valid ItemForm itemForm,
        BindingResult bindingResult,
        RedirectAttributes redirectAttributes
    ) {
        ModelAndView modelAndView;

        if (bindingResult.hasErrors()) {
            modelAndView = new ModelAndView("admin/item/create");
            modelAndView.addObject("error", true);
        } else {
            try {
                modelAndView = new ModelAndView("redirect:" + BASE_URL);

                redirectAttributes.addFlashAttribute("flashMessage", "admin.category.was-saved");
                redirectAttributes.addFlashAttribute("flashMessageType", "success");

                itemService.save(itemForm);
            } catch (Exception e) {
                LOG.error("Item could not be saved.", e);
                modelAndView = new ModelAndView("admin/item/create");
                modelAndView.addObject("error", true);
            }
        }

        return modelAndView;
    }

    @RequestMapping(value = UPDATE_URL, method = RequestMethod.GET)
    public ModelAndView update(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        Item item = itemService.getById(id);

        if (item == null) {
            redirectAttributes.addFlashAttribute("flashMessage", "admin.item.does-not-exist");
            redirectAttributes.addFlashAttribute("flashMessageType", "danger");
            return new ModelAndView("redirect:" + BASE_URL);
        }

        ItemForm itemForm = new ItemForm();
        BeanUtils.copyProperties(item, itemForm);

        ModelAndView modelAndView = new ModelAndView("admin/item/update");
        modelAndView.addObject("itemCategoryForm", itemForm);

        return modelAndView;
    }

    @RequestMapping(value = UPDATE_URL, method = RequestMethod.POST)
    public ModelAndView update(
        @PathVariable("id") Long id,
        @Valid ItemForm itemForm,
        BindingResult bindingResult,
        RedirectAttributes redirectAttributes
    ) {
        Item item = itemService.getById(id);

        if (item == null) {
            redirectAttributes.addFlashAttribute("flashMessage", "admin.item.does-not-exist");
            redirectAttributes.addFlashAttribute("flashMessageType", "danger");
            return new ModelAndView("redirect:" + BASE_URL);
        }

        ModelAndView modelAndView;

        if (bindingResult.hasErrors()) {
            modelAndView = new ModelAndView("admin/item/update");
            modelAndView.addObject("error", true);
        } else {
            try {
                itemService.save(itemForm);
                modelAndView = new ModelAndView("redirect:" + BASE_URL);
                redirectAttributes.addFlashAttribute("flashMessage", "admin.item.was-saved");
                redirectAttributes.addFlashAttribute("flashMessageType", "success");
            } catch (Exception e) {
                LOG.error(e);
                modelAndView = new ModelAndView("admin/item/update");
                modelAndView.addObject("error", true);
            }
        }

        return modelAndView;
    }

    @RequestMapping(value = DELETE_URL, method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            itemService.deleteById(id);
        } catch (Exception e) {
            LOG.error("Item could not be deleted.", e);
            redirectAttributes.addFlashAttribute("flashMessage", "admin.item.could-not-be-saved");
            redirectAttributes.addFlashAttribute("flashMessageType", "danger");
        }

        return new ModelAndView("redirect:" + BASE_URL);
    }
}
