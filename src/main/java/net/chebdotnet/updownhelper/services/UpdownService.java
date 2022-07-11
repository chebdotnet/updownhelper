package net.chebdotnet.updownhelper.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.chebdotnet.updownhelper.api.UpdownBean;
import net.chebdotnet.updownhelper.api.UpdownRestApi;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UpdownService {

    private final UpdownRestApi api;
    private final DumpService dumpService;

    public List<UpdownBean> fetchUpdownChecks() {
        List<UpdownBean> data = api.fetchStatuses();

        data
                .stream()
                .filter(UpdownBean::getDown)
                .forEach(item -> {
                    log.error("A service with the url {} has been failed with error {}", item.getUrl(), item.getDown());
                    dumpService.restartService(item.getUrl(), item.getAlias());
                });
        return data;
    }
}
