package api.mall.domain.item;

import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("A")
@Getter
public class Album extends Item{

    private String artist;

    private String etc;

}
