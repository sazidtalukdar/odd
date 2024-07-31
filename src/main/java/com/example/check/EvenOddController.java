package com.example.check;


import org.springframework.web.bind.annotation.*;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "*")
public class EvenOddController {

    private  ApiKeyDao apiKeyDao;

    public EvenOddController(ApiKeyDao apiKeyDao) { // use final to variable use constructor
        this.apiKeyDao = apiKeyDao;
    }

    @PostMapping("/check")
    public String checkEvenOdd(@RequestBody NumberRequest numberRequest, @RequestHeader("api_key") String key) {
        if (apiKeyDao.isApiKeyValid(key)) {
            return check(numberRequest.getNumber());
        } else {
            return "Invalid API key.";
        }
    }

    public String check(long number) {
        if (number % 2 == 0) {
            return number + " is even.";
        } else {
            return number + " is odd.";
        }
    }

    public static class NumberRequest {
        private long number;

        public long getNumber() {
            return number;
        }

        public void setNumber(long number) {
            this.number = number;
        }
    }
}

