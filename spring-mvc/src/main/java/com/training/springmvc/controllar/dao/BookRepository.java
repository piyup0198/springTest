
package com.training.springmvc.controllar.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.springmvc.controllar.model.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
