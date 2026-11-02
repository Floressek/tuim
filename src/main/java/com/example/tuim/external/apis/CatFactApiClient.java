package com.example.tuim.external.apis;

import com.example.tuim.data.dtos.FactResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "jplaceholder", url = "https://catfact.ninja")
public interface CatFactApiClient {

    @RequestMapping(method = RequestMethod.GET, value = "/fact")
    FactResponse getFact();
}
