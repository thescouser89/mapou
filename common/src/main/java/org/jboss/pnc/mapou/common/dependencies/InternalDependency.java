package org.jboss.pnc.mapou.common.dependencies;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode
@ToString
public class InternalDependency {

    @Getter
    private final PublicDependency dependency;

    @Getter
    private final String redhatVersion;

    /**
     * Extra attributes can be used to store buildtool specific information
     */
    @Getter
    private Map<String, String> extraAttributes;

    public InternalDependency(PublicDependency dependency, String redhatVersion) {
        this.dependency = dependency;
        this.redhatVersion = redhatVersion;

        this.extraAttributes = new HashMap<>();
    }

    public void addExtraAttribute(String key, String value) {
        this.extraAttributes.put(key, value);
    }

}
