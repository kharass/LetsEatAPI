package com.leshen.LetsEatRestaurantAPI.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.leshen.LetsEatRestaurantAPI.Model.ReservedTables;
import com.leshen.LetsEatRestaurantAPI.Model.Restaurant;

public interface ReservedTablesRepository extends JpaRepository<ReservedTables, Long>{
    List<ReservedTables> findByRestaurant(Restaurant restaurant);
}
