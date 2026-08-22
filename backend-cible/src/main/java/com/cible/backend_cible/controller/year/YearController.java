package com.cible.backend_cible.controller.year;

import com.cible.backend_cible.mapper.year.YearMapper;
import com.cible.backend_cible.model.dtos.year.YearDTO;
import com.cible.backend_cible.model.user.User;
import com.cible.backend_cible.model.user.UserAuth;
import com.cible.backend_cible.model.year.Year;
import com.cible.backend_cible.service.year.YearSERVICE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/years")
public class YearController {

    @Autowired
    private YearSERVICE yearSERVICE;

    @Autowired
    private YearMapper yearMapper;

    @GetMapping
    public List<Year> getAllYearsByUserId(@AuthenticationPrincipal UserAuth userAuth){
        User user = userAuth.getUser();
        return yearSERVICE.getAllYearsByUserId(user);
    }

    @PostMapping("/add")
    public ResponseEntity<YearDTO> saveYear(@RequestBody YearDTO yearDTO, @AuthenticationPrincipal UserAuth userAuth) {
        User user = userAuth.getUser();
        System.out.println(user);
        Year saved = yearSERVICE.saveYear(yearDTO,user);
        return ResponseEntity.ok(yearMapper.toDTO(saved));
    }

}
