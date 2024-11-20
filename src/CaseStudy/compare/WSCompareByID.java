package CaseStudy.compare;
import CaseStudy.entity.WaterSalesman;
import java.util.Comparator;

public class WSCompareByID implements Comparator<WaterSalesman> {

    @Override
    public int compare(WaterSalesman o1, WaterSalesman o2) {
        if (o1.getId()>o2.getId()){
            return 1;
        } else if (o1.getId()==o2.getId()) {
            return 0;
        }else {
            return -1;
        }
    }

}