package org.example.bookorder.repository;

import org.example.bookorder.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrdersRepository  extends JpaRepository<Orders, UUID> {
}
