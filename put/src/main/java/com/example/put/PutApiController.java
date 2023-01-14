package com.example.put;

import com.example.put.dto.PutRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutApiController {

    /*
       {
            "name" : "steve",
            "age" : 20,
            "car_list" : [
                {
                    "name" : "BMW",
                    "car_number" : "11가1234"
                },
                {
                    "name" : "Audi",
                    "car_number" : "22가3456"
                }
            ]
       }
     */

    @PutMapping("/put/{userId}")
    public PutRequestDto put(@RequestBody PutRequestDto dto, @PathVariable(name="userId") Long id){
        System.out.println(id);
        System.out.println(dto);

        return dto;
    }
}
