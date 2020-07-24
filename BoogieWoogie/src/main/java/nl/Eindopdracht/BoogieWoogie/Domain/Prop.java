package nl.Eindopdracht.BoogieWoogie.Domain;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import nl.Eindopdracht.BoogieWoogie.Domain.PositionOnStage;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Prop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long propId;

    @Enumerated(EnumType.STRING)
    private PositionOnStage position;

    private String propUser;
    private String presetBy;

    public Prop(){}

    public String getPresetBy() {
        return presetBy;
    }

    public void setPresetBy(String preset) {
        this.presetBy = preset;
    }

    public long getPropId() {
        return propId;
    }

    public void setPropId(long propId) {
        this.propId = propId;
    }

    public PositionOnStage getPosition() {
        return position;
    }

    public void setPosition(PositionOnStage position) {
        this.position = position;
    }

    public String getPropUser() {
        return propUser;
    }

    public void setPropUser(String propUser) {
        this.propUser = propUser;
    }
}
