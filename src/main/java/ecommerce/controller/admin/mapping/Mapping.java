package ecommerce.controller.admin.mapping;

/**
 * @author Jakub Polák
 */
public enum Mapping {
    ITEM_CATEGORY("itemCategory", "itemCategories", "item-category", "item-category", "itemCategoryForm", "category"),
    ITEM("item", "items", "item", "item", "itemForm", "item");

    private String entityName;
    private String entityNameMultiple;
    private String entityNameInUrl;
    private String entityNameInFileSystem;
    private String formName;
    private String entityKeyTranslation;

    Mapping(String entityName, String entityNameMultiple, String entityNameInUrl, String entityNameInFileSystem, String formName, String entityKeyTranslation) {
        this.entityName = entityName;
        this.entityNameMultiple = entityNameMultiple;
        this.entityNameInUrl = entityNameInUrl;
        this.entityNameInFileSystem = entityNameInFileSystem;
        this.formName = formName;
        this.entityKeyTranslation = entityKeyTranslation;
    }

    public String getEntityName() {
        return entityName;
    }

    public String getEntityNameInUrl() {
        return entityNameInUrl;
    }

    public String getEntityNameInFileSystem() {
        return entityNameInFileSystem;
    }

    public String getEntityNameMultiple() {
        return entityNameMultiple;
    }

    public String getFormName() {
        return formName;
    }

    public String getEntityKeyTranslation() {
        return entityKeyTranslation;
    }

    public static Mapping getMapping(String entityNameInUrl) {
        switch (entityNameInUrl) {
            case "item-category":
                return ITEM_CATEGORY;
            case "item":
                return ITEM;
            default:
                throw new IllegalArgumentException("Entity '" + entityNameInUrl + "' does not exist.");
        }
    }
}
