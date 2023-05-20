package it.ctinnovation.tdcKc.model.placemark;

import it.ctinnovation.tdcKc.model.attribute.Level;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class Levels {
    @Embedded
    private Level warning;
    @Embedded
    private Level danger;
    @Embedded
    private Level success;

    public Level getWarning() {
        return warning;
    }

    public void setWarning(Level warning) {
        this.warning = warning;
    }

    public Level getDanger() {
        return danger;
    }

    public void setDanger(Level danger) {
        this.danger = danger;
    }

    public Level getSuccess() {
        return success;
    }

    public void setSuccess(Level success) {
        this.success = success;
    }
}
