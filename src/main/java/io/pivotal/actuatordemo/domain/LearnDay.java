package io.pivotal.actuatordemo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class LearnDay {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String topic;
    private String speaker;
}
