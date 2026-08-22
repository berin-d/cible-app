package com.cible.backend_cible.db.year;

import com.cible.backend_cible.model.year.Year;
import org.springframework.data.domain.Limit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YearRepository extends CrudRepository<Year, Integer> {

    List<Year> getYearsByUser_Id(Integer userId);
}
