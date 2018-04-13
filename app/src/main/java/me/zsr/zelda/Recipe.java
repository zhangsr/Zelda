package me.zsr.zelda;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import org.greenrobot.greendao.annotation.Generated;

/**
 * @description:
 * @author: Match
 * @date: 11/02/2018
 */

@Entity
public class Recipe {
    @Id
    private Long id;

    private String name;
    
    private String image;

    private int price;

    private int heartRecovery;

    private int heartMax;

    private int speedTime;

    private int staminaRecovery;

    private int sneakTime;

    private int snowflakeTime;

    private int hotTime;

    private int boltTime;

    private int atkTime;

    private int defTime;

    private String materialList;

    @Generated(hash = 1710097689)
    public Recipe(Long id, String name, String image, int price, int heartRecovery,
            int heartMax, int speedTime, int staminaRecovery, int sneakTime,
            int snowflakeTime, int hotTime, int boltTime, int atkTime, int defTime,
            String materialList) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.heartRecovery = heartRecovery;
        this.heartMax = heartMax;
        this.speedTime = speedTime;
        this.staminaRecovery = staminaRecovery;
        this.sneakTime = sneakTime;
        this.snowflakeTime = snowflakeTime;
        this.hotTime = hotTime;
        this.boltTime = boltTime;
        this.atkTime = atkTime;
        this.defTime = defTime;
        this.materialList = materialList;
    }

    @Generated(hash = 829032493)
    public Recipe() {
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

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getHeartRecovery() {
        return this.heartRecovery;
    }

    public void setHeartRecovery(int heartRecovery) {
        this.heartRecovery = heartRecovery;
    }

    public int getHeartMax() {
        return this.heartMax;
    }

    public void setHeartMax(int heartMax) {
        this.heartMax = heartMax;
    }

    public int getSpeedTime() {
        return this.speedTime;
    }

    public void setSpeedTime(int speedTime) {
        this.speedTime = speedTime;
    }

    public int getStaminaRecovery() {
        return this.staminaRecovery;
    }

    public void setStaminaRecovery(int staminaRecovery) {
        this.staminaRecovery = staminaRecovery;
    }

    public int getSneakTime() {
        return this.sneakTime;
    }

    public void setSneakTime(int sneakTime) {
        this.sneakTime = sneakTime;
    }

    public int getSnowflakeTime() {
        return this.snowflakeTime;
    }

    public void setSnowflakeTime(int snowflakeTime) {
        this.snowflakeTime = snowflakeTime;
    }

    public int getHotTime() {
        return this.hotTime;
    }

    public void setHotTime(int hotTime) {
        this.hotTime = hotTime;
    }

    public int getBoltTime() {
        return this.boltTime;
    }

    public void setBoltTime(int boltTime) {
        this.boltTime = boltTime;
    }

    public int getAtkTime() {
        return this.atkTime;
    }

    public void setAtkTime(int atkTime) {
        this.atkTime = atkTime;
    }

    public int getDefTime() {
        return this.defTime;
    }

    public void setDefTime(int defTime) {
        this.defTime = defTime;
    }

    public String getMaterialList() {
        return this.materialList;
    }

    public void setMaterialList(String materialList) {
        this.materialList = materialList;
    }
}
