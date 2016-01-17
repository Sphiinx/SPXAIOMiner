package scripts.SPXAIOMiner.data;

import org.tribot.api2007.types.RSArea;

/**
 * Created by Sphiinx on 1/16/2016.
 */
public class Location {

    private final RSArea area;

    Location(RSArea area) {
        this.area = area;
    }

    public RSArea getArea() {
        return area;
    }

}

