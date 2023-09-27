package it.ctinnovation.tdcKc.model.scenario.entitiy;

import it.ctinnovation.tdcKc.model.abstractEntities.AbstractEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
public class ScenarioEntity extends AbstractEntity {
    String name;
    @Column(length = 4096)
    String Description;


    //region Accessors
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription(){
        return Description;
    }

    public void setDescription(String description){
        this.Description = description;
    }

    @Override
    public String toString() {
        return "ScenarioEntity{" +
            "name='" + name + '\'' +
            ", Description='" + Description + '\'' +
            '}';
    }


//endregion
}
