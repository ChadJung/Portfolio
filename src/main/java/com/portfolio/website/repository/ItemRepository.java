package com.portfolio.website.repository;

import com.portfolio.website.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository  extends JpaRepository<Item, Long> {
}
