package com.smile.config;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.server.InProcessServer;
import org.springframework.data.neo4j.server.Neo4jServer;

@Configuration
@EnableNeo4jRepositories(basePackages = "com.smile.repository")
public class NeoConfig extends Neo4jConfiguration {

    @Bean
    public Neo4jServer neo4jServer() {
        return new InProcessServer();
    }

    @Bean
    public SessionFactory getSessionFactory() {
        return new SessionFactory("com.smile.model");
    }

    @Bean
    public Session getSession() throws Exception {
        return super.getSession();
    }

}
