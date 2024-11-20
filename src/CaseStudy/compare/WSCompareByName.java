package CaseStudy.compare;

import CaseStudy.entity.WaterSalesman;
import java.util.Comparator;

public class WSCompareByName implements Comparator<WaterSalesman> {

    @Override
    public int compare(WaterSalesman o1, WaterSalesman o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
