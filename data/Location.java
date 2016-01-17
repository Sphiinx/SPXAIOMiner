package scripts.SPXAIOMiner.data;

import org.tribot.api2007.types.RSTile;

/**
 * Created by Sphiinx on 1/16/2016.
 */
public enum Location {

    VARROCKWEST(new RSTile(3181, 3372, 0));

    private final RSTile area;

    Location(RSTile area) {
        this.area = area;
    }

    public RSTile getArea() {
        return area;
    }

}

