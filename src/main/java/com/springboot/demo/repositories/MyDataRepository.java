package com.springboot.demo.repositories;

import com.springboot.demo.MyData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MyDataRepository extends JpaRepository<MyData, Long> {

    public MyData findById(long name);

    public List<MyData> findByNameLike(String name);

    public List<MyData> findByIdIsNotNullOOrderByIdDesc();

    public List<MyData> findByAgeGreaterThan(Integer age);

    public List<MyData> findByAgeBetween(Integer age1, Integer age2);
}
