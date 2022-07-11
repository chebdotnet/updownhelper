package net.chebdotnet.updownhelper.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
class DumpService {
    void restartService(String url, String alias) {
        log.info("Force to handle it -- for example to restart the service with url {} and alias", url, alias);
    }
}
