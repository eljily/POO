package org.eljily.sidibrahim.ws;

import jakarta.xml.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
@XmlRootElement(name = "compte")
@XmlAccessorType(XmlAccessType.FIELD)
public class Compte {
    private int code;
    private Double solde;
    @XmlTransient
    private Date createDate;

    public Compte() {
    }

    public Compte(int code, Double solde, Date createDate) {
        this.code = code;
        this.createDate = createDate;
        this.solde = solde;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }
}
