package com.hsnam.validation.web;

import com.hsnam.validation.model.DataModel;
import com.hsnam.validation.model.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class ValidationController {

    @PostMapping("/valid")
    public ResponseEntity<ResponseMessage> validation(@Valid @RequestBody DataModel dataModel){
        log.info("data = {}", dataModel.toString());
        ResponseMessage res = ResponseMessage.builder().build();
        res.setMessage("success");

        return ResponseEntity.ok(res);
    }//end of validation
}
