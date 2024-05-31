package com.leshen.LetsEatRestaurantAPI.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.leshen.LetsEatRestaurantAPI.Model.Reservation;
import com.leshen.LetsEatRestaurantAPI.Model.Restaurant;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{
    List<Reservation> findByRestaurant(Restaurant restaurant);
}
