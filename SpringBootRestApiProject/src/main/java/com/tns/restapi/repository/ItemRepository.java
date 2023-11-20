package com.tns.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tns.restapi.entity.Item;

public interface ItemRepository extends JpaRepository<Item,Integer>{

	Item findById(long id);

	List<Item> findByCategory(String category);

}
