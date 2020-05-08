package com.atmecs.ep.controller;

import com.atmecs.ep.model.AddressVo;
import com.atmecs.ep.model.EmployeeVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping(value = "/",produces = "application/json")
    public ResponseEntity<EmployeeVo> getEmployees(){
        EmployeeVo employee = new EmployeeVo("Rajesh","Muniganti","001", new AddressVo());
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
}
