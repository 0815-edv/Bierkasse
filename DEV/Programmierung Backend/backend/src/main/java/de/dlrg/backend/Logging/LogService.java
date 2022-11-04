package de.dlrg.backend.Logging;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class LogService {

    public static final Logger logger = LoggerFactory.getLogger(LogService.class);

}