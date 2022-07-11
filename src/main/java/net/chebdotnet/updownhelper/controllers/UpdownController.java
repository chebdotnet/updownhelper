package net.chebdotnet.updownhelper.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.chebdotnet.updownhelper.api.UpdownBean;
import net.chebdotnet.updownhelper.services.UpdownService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/statuses")
@RequiredArgsConstructor
public class UpdownController {

    private final UpdownService service;

    @GetMapping
    public List<UpdownBean> findCustomers() {
        log.info("Getting statuses for Updown checks");
        List<UpdownBean> data = service.fetchUpdownChecks();
        return data;
    }
}
