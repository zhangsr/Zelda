package me.zsr.zelda;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @description:
 * @author: Match
 * @date: 10/02/2018
 */

@Entity
public class Material {
    @Id
    private Long id;

    private String name;

    private String image;

    private String desc;

    @Generated(hash = 1758092786)
    public Material(Long id, String name, String image, String desc) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.desc = desc;
    }

    @Generated(hash = 1176792654)
    public Material() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
