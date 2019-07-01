package com.novikov.carrental.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.domain.Persistable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Абстрактный базовый класс для сущностей с id и генератором значений id в виде последовательности.
 */
@MappedSuperclass
public abstract class AbstractSequenceIdEntity<PK extends Serializable> implements Persistable<PK> {
    @Id
    @Getter
    @Setter
    @GeneratedValue(generator = "SequencePerEntityGenerator")
    @GenericGenerator(
            name = "SequencePerEntityGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "prefer_sequence_per_entity", value = "true"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    protected PK id;

    @JsonIgnore
    @Override
    public boolean isNew() {
        return null == getId();
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!getClass().isAssignableFrom(Hibernate.getClass(obj))) {
            return false;
        }

        AbstractSequenceIdEntity<?> that = (AbstractSequenceIdEntity<?>) obj;
        return null != this.getId() && this.getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        hashCode += null == getId() ? 0 : getId().hashCode() * 31;
        return hashCode;
    }
}

