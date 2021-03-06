package org.jboss.pnc.mapou.common.dependencies;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Map;

@EqualsAndHashCode
@ToString
public class PublicDependency {

    @Getter
    private final String name;

    @Getter
    private final String publicVersion;

    /**
     * Extra attributes can be used to store buildtool specific information
     */
    @Getter
    private Map<String, String> extraAttributes;

    public PublicDependency(String name, String publicVersion) {
        this.name = name;
        this.publicVersion = publicVersion;
    }

    public void addExtraAttribute(String key, String value) {
        this.extraAttributes.put(key, value);
    }
}

