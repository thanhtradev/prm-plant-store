package com.prmplantstore.repositories;

import com.prmplantstore.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem getByCartIdAndPlantId(Long cartId, Long plantId);

    Boolean existsByCartIdAndPlantId(Long cartId, Long plantId);

    void deleteAllByCartId(Long cartId);
}
