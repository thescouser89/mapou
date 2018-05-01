package org.jboss.pnc.mapou.npm.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.Map;

@ToString
public class PackageLock {

    @Getter
    private String name;

    @Getter
    private String version;

    @Getter
    private String lockfileVersion;

    @Getter
    private Boolean requires;

    @Getter
    private Map<String, NpmDependency> dependencies;
}
