package at.spengergasse.spring_thymeleaf.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Mobs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public String mobName;
    public float mobHealth;
    public float mobSpeed;

    public String getMobName() {
        return mobName;
    }

    public void setMobName(String mobname) {
        this.mobName = mobname;
    }

    public float getMobHealth() {
        return mobHealth;
    }

    public void setMobHealth(float mobhealth) {
        this.mobHealth = mobhealth;
    }

    public float getMobSpeed() {
        return mobSpeed;
    }

    public void setMobSpeed(float mobspeed) {
        this.mobSpeed = mobspeed;
    }
}
