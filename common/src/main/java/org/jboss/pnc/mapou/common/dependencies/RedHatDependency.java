package org.jboss.pnc.mapou.common.dependencies;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RedHatDependency {

    @Getter
    private PublicDependency dependency;

    @Getter
    private String redhatVersion;
}
