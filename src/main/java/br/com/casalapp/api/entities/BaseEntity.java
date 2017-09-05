package br.com.casalapp.api.entities;

import java.io.Serializable;

public interface BaseEntity  extends Serializable {

    void setId(Long id);
    Long getId();

}
