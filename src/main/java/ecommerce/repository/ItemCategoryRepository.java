package ecommerce.repository;

import ecommerce.domain.ItemCategory;
import org.springframework.data.repository.CrudRepository;

/**
 * Item category repository.
 *
 * @author Jakub Polák
 */
public interface ItemCategoryRepository extends CrudRepository<ItemCategory, Long> {
}
