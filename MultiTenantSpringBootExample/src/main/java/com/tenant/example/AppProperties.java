/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenant.example;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 * @author UTP
 */
@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "app")
public class AppProperties {

    /**
     * version.
     */
    private String version;
    /**
     * apiPath.
     */
    private String apiPath;
    /**
     * flywayLocation.
     */
    private FlywayLocation flywayLocation = new FlywayLocation();

    /**
     * clase FlywayLocation.
     */
    @Setter
    @Getter
    public class FlywayLocation {

        /**
         * master.
         */
        private String master;
        /**
         * tenant.
         */
        private String tenant;
    }
}
