package com.workintech.fswebs18challengemaven.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Card", schema = "Casino")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer value;
    @Enumerated(EnumType.STRING)
    private Color color;
    @Enumerated(EnumType.STRING)
    private Type type;

    public void setType(Type type) {
        if (type == Type.JOKER) {
            value = null;
            color = null;
        }
        if (type != null) {
            this.type = type;
            this.value = null;
        } else {
            this.type = null;
        }
    }

    public void setValue(Integer value) {
        if (value != null) {
            this.type = null;
            this.value = value;
        }
    }
}
