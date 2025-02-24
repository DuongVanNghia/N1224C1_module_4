package com.n1224C1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Ex2_Controller {
    private final Map<String,String> map = Map.ofEntries(
            Map.entry("Hello","xin chào"),
            Map.entry("apple","quả táo"),
            Map.entry("banana","quả chuối")


    );
    @GetMapping("/dictionary")
    public ResponseEntity<String> dictionary(@RequestParam(defaultValue = "") String word) {
        for (String key : map.keySet()) {
            if(key.equals(word)){
                return ResponseEntity.ok(map.get(key));
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tim thấy");
    }
}
