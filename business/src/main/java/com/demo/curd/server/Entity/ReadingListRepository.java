package com.demo.curd.server.Entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Version
 * @Title: ReadingListRepository
 * @Package: package com.example.demo.server.Entity
 * @Description:
 * @Author: WenJie
 * @Date: 2017/8/11
 */
public interface ReadingListRepository extends JpaRepository<Book,Long> {
    List<Book> findByReader(String reader);
}
