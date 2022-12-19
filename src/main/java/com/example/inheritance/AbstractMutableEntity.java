package com.example.inheritance;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.time.ZonedDateTime;

@MappedSuperclass
public abstract class AbstractMutableEntity extends AbstractImmutableEntity {
    private Long version;
    private ZonedDateTime lastUpdated;

    @Version
    public Long getVersion() {
        return version;
    }

    @UpdateTimestamp
    public ZonedDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public void setLastUpdated(ZonedDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
