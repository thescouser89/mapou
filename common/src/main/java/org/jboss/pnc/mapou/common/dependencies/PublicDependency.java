package org.jboss.pnc.mapou.common.dependencies;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class PublicDependency {

    @Getter
    private String name;

    @Getter
    private String publicVersion;
}

