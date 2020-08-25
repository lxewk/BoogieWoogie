package nl.Eindopdracht.BoogieWoogie.Domain;

import nl.Eindopdracht.BoogieWoogie.Domain.PositionOnStage;

import javax.persistence.*;

@Entity
public class Decor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long decorId;

    @Enumerated(EnumType.STRING)
    private PositionOnStage positionDecor;

    private String decorUser;
    private boolean automated;
    private String preset;

    public Decor() {}

    public long getDecorId() {
        return decorId;
    }

    public void setDecorId(long decorId) {
        this.decorId = decorId;
    }

    public PositionOnStage getPositionDecor() {
        return positionDecor;
    }

    public void setPositionDecor(PositionOnStage positionDecor) {
        this.positionDecor = positionDecor;
    }

    public String getDecorUser() {
        return decorUser;
    }

    public void setDecorUser(String decorUser) {
        this.decorUser = decorUser;
    }

    public boolean isAutomated() {
        return automated;
    }

    public void setAutomated(boolean automated) {
        this.automated = automated;
    }

    public String getPreset() {
        return preset;
    }

    public void setPreset(String preset) {
        this.preset = preset;
    }
}
