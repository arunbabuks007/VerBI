package com.Aurelsdev.VerBI.verbi.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Verb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String v1;
    private String v2;
    private String v3;
    private String v4;
    private String v5;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getV1() { return v1; }
    public void setV1(String v1) { this.v1 = v1; }
    public String getV2() { return v2; }
    public void setV2(String v2) { this.v2 = v2; }
    public String getV3() { return v3; }
    public void setV3(String v3) { this.v3 = v3; }
    public String getV4() { return v4; }
    public void setV4(String v4) { this.v4 = v4; }
    public String getV5() { return v5; }
    public void setV5(String v5) { this.v5 = v5; }
}