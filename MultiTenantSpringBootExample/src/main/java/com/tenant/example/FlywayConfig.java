/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenant.example;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author DiazOspina
 */
@Configuration
@Slf4j
public class FlywayConfig {

    /**
     * esquema por defecto.
     */
    public static final String DEFAULT_SCHEMA = "public";

    /**
     * propiedades de FlywayLocation.
     */
    @Autowired
    private AppProperties appProperties;

    /**
     * metodo que ejecuta lo sql de db.migration en el esquema por defecto.
     *
     * @param dataSource datasource
     * @return Flyway
     */
    @Bean
    public Flyway flyway(DataSource dataSource) {
        log.info("Migrando esquema por defecto");
        Flyway flyway = Flyway.configure()
                .locations(appProperties.getFlywayLocation().getMaster())
                .dataSource(dataSource)
                .schemas(DEFAULT_SCHEMA)
                .load();
        flyway.migrate();
        return flyway;
    }

    /**
     * metodo que ejecuta lo sql de db.migration en los esquemas asignados, si
     * no estan creados los esquemas en la base de datos primero los crea antes
     * de ejecutar todos los sql.
     *
     * @param dataSource dataSource
     * @return boolean indicando que todo se ejecuto correctamente
     */
    @Bean
    public Boolean tenantsFlyway(DataSource dataSource) {
        List<String> tenants = new ArrayList<>();
        tenants.add("esquema1");
        tenants.add("esquema2");
        // List<TenantsDTO> tenants = tenantClient.listarUsuarios();
        tenants.forEach(tenant -> {
            log.info(tenant);
            Flyway flyway = Flyway.configure()
                    .locations(appProperties.getFlywayLocation().getMaster())
                    .dataSource(dataSource)
                    .schemas(tenant)
                    .load();
            flyway.migrate();
        });
        return true;
    }
}
