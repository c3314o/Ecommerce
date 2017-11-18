package ecommerce.controller.admin;

import ecommerce.controller.admin.mapping.Mapping;
import ecommerce.domain.BaseEntity;
import ecommerce.form.admin.BaseForm;
import ecommerce.service.CrudServiceForm;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
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
public abstract class CrudController<E extends BaseEntity, F extends BaseForm<E, F>> {
    private static final Log LOG = LogFactory.getLog(CrudController.class);
    private static final String CREATE_URL = "create";
    private static final String UPDATE_URL = "{id}/update";
    private static final String DELETE_URL = "{id}/delete";

    private final CrudServiceForm<E, F> crudService;
    private Mapping mapping;

    public CrudController(CrudServiceForm<E, F> crudService, Mapping mapping) {
        this.crudService = crudService;
        this.mapping = mapping;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        Iterable<E> entities = crudService.getAll();
        ModelAndView modelAndView = new ModelAndView("admin/" + mapping.getEntityNameInFileSystem() + "/index");
        modelAndView.addObject(mapping.getEntityNameMultiple(), entities);

        return modelAndView;
    }

    @RequestMapping(value = CREATE_URL, method = RequestMethod.GET)
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("admin/" + mapping.getEntityNameInFileSystem() + "/create");
        modelAndView.addObject(mapping.getFormName(), crudService.buildForm());

        return modelAndView;
    }

    @RequestMapping(value = CREATE_URL, method = RequestMethod.POST)
    public ModelAndView create(
        @Valid F form,
        BindingResult bindingResult,
        RedirectAttributes redirectAttributes
    ) {
        ModelAndView modelAndView;

        if (bindingResult.hasErrors()) {
            modelAndView = new ModelAndView("admin/" + mapping.getEntityNameInFileSystem() + "/create");
            modelAndView.addObject("error", true);
            modelAndView.addObject(mapping.getFormName(), crudService.buildForm(form));
        } else {
            try {
                modelAndView = new ModelAndView("redirect:" + "/admin/" + mapping.getEntityNameInUrl() + "/");
                redirectAttributes.addFlashAttribute("flashMessage", "admin." + mapping.getEntityKeyTranslation() + ".was-saved");
                redirectAttributes.addFlashAttribute("flashMessageType", "success");

                crudService.save(form);
            } catch (RuntimeException e) {
                LOG.error("Entity could not be saved.", e);
                modelAndView = new ModelAndView("admin/" + mapping.getEntityNameInFileSystem() + "/create");
                modelAndView.addObject("error", true);
                modelAndView.addObject(mapping.getFormName(), crudService.buildForm(form));
            }
        }

        return modelAndView;
    }

    @RequestMapping(value = UPDATE_URL, method = RequestMethod.GET)
    public ModelAndView update(
        @PathVariable Long id,
        RedirectAttributes redirectAttributes
    ) {
        E entity = crudService.getById(id);

        if (entity == null) {
            redirectAttributes.addFlashAttribute("flashMessage", "admin." + mapping.getEntityKeyTranslation() + ".does-not-exist");
            redirectAttributes.addFlashAttribute("flashMessageType", "danger");
            return new ModelAndView("redirect:" + "/admin/" + mapping.getEntityNameInUrl() + "/");
        }

        F form = crudService.buildForm();

        BeanUtils.copyProperties(entity, form);

        ModelAndView modelAndView = new ModelAndView("admin/" + mapping.getEntityNameInFileSystem() + "/update");
        modelAndView.addObject(mapping.getFormName(), form);

        return modelAndView;
    }

    @RequestMapping(value = UPDATE_URL, method = RequestMethod.POST)
    public ModelAndView update(
        @PathVariable("id") Long id,
        @Valid F form,
        BindingResult bindingResult,
        RedirectAttributes redirectAttributes
    ) {
        E entity = crudService.getById(id);

        if (entity == null) {
            redirectAttributes.addFlashAttribute("flashMessage", "admin." + mapping.getEntityKeyTranslation() + ".does-not-exist");
            redirectAttributes.addFlashAttribute("flashMessageType", "danger");
            return new ModelAndView("redirect:" + "/admin/" + mapping.getEntityNameInUrl() + "/");
        }

        ModelAndView modelAndView;

        if (bindingResult.hasErrors()) {
            modelAndView = new ModelAndView("admin/" + mapping.getEntityNameInUrl() + "/update");
            modelAndView.addObject("error", true);
        } else {
            try {
                crudService.save(form);
                modelAndView = new ModelAndView("redirect:" + "/admin/" + mapping.getEntityNameInUrl() + "/");
                redirectAttributes.addFlashAttribute("flashMessage", "admin." + mapping.getEntityKeyTranslation() + ".was-saved");
                redirectAttributes.addFlashAttribute("flashMessageType", "success");
            } catch (RuntimeException e) {
                LOG.error("Entity could not be updated.", e);
                modelAndView = new ModelAndView("admin/" + mapping.getEntityNameInFileSystem() + "/update");
                modelAndView.addObject("error", true);
            }
        }

        return modelAndView;
    }

    @RequestMapping(value = DELETE_URL, method = RequestMethod.GET)
    public ModelAndView delete(
        @PathVariable("id") Long id,
        RedirectAttributes redirectAttributes
    ) {
        try {
            crudService.deleteById(id);
        } catch (RuntimeException e) {
            LOG.error("Entity could not be deleted.", e);
            redirectAttributes.addFlashAttribute("flashMessage", "admin." + mapping.getEntityKeyTranslation() + ".could-not-be-saved");
            redirectAttributes.addFlashAttribute("flashMessageType", "danger");
        }

        return new ModelAndView("redirect:" + "/admin/" + mapping.getEntityNameInUrl() + "/");
    }
}
