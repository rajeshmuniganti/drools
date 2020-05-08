package com.atmecs.ep.util;

import org.drools.core.spi.KnowledgeHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utility {
    private static final Logger LOG = LoggerFactory.getLogger(Utility.class);

    public static void helper(final KnowledgeHelper drools) {
        LOG.info("rule triggered: " + drools.getRule().getName());
    }
}
