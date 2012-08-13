package com.gueck.javaee6;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="examples")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
public @Data class Example implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @XmlElement
    private Long id;

    @Basic
    @XmlElement
    private String name;

    public Example(final String name) {
        this.name = name;
    }
    
}
