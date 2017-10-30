package ecommerce.repository;

import ecommerce.domain.Item;
import org.springframework.data.repository.CrudRepository;

/**
 * Item repository.
 *
 * @author Jakub Polák
 */
public interface ItemRepository extends CrudRepository<Item, Long> {
}
