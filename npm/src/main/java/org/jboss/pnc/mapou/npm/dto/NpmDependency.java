package org.jboss.pnc.mapou.npm.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.Map;

@ToString
public class NpmDependency {

    @Getter
    private String version;

    @Getter
    private String resolved;

    @Getter
    private String integrity;

    @Getter
    private Boolean dev;

    @Getter
    private Map<String, String> requires;

    @Getter
    private Map<String, NpmDependency> dependencies;
}
