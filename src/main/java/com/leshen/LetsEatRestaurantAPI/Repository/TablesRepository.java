package com.leshen.LetsEatRestaurantAPI.Repository;

import com.leshen.LetsEatRestaurantAPI.Model.Restaurant;
import com.leshen.LetsEatRestaurantAPI.Model.Tables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface TablesRepository extends JpaRepository<Tables, Long> {
    List<Tables> findByRestaurant(Restaurant restaurant);
    
    @Transactional
    @Modifying
    @Query("DELETE FROM Tables t WHERE t.restaurant.restaurantId = :restaurantId AND t.tableId = :tableId")
    void deleteTableFromSpecificRestaurant(Long restaurantId, Long tableId);
}
