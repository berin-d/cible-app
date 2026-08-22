package com.cible.backend_cible.service.year;

import com.cible.backend_cible.db.year.YearRepository;
import com.cible.backend_cible.mapper.year.YearMapper;
import com.cible.backend_cible.model.dtos.year.YearDTO;
import com.cible.backend_cible.model.user.User;
import com.cible.backend_cible.model.year.Year;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YearSERVICE {

    @Autowired
    private YearRepository  yearRepository;

    @Autowired
    private YearMapper yearMapper;


    public List<Year> getAllYearsByUserId(User user){
        return yearRepository.getYearsByUser_Id(user.getId());
    }

    public Year saveYear(YearDTO yearDTO, User user){
        Year year = yearMapper.toEntity(yearDTO);
        year.setUser(user);
        return yearRepository.save(year);
    }
}
