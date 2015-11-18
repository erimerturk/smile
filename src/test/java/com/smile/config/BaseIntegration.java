package com.smile.config;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@ComponentScan(basePackages = "com.smile")
@SpringApplicationConfiguration(classes = NeoConfig.class)
@EnableAutoConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class BaseIntegration {

    @Autowired
    protected Neo4jOperations neo4jOperations;

    public Neo4jOperations getNeo4jTemplate() {
        return neo4jOperations;
    }

}
