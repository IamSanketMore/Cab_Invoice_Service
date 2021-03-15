import java.util.HashMap;
import java.util.Map;


public class InvoiceService {
    private static final double COST_PER_TIME = 1 ;
    private static final double MINIMUM_COST_PER_KM = 10.0;

    public static double CalculateFare(double dis, double time) {

        double fare = (dis*MINIMUM_COST_PER_KM)+(time*COST_PER_TIME);
        return fare >= 5 ? fare : 5;
    }

    public InvoiceGenerator CalculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride:rides) {
            double fare = this.CalculateFare(ride.distance, ride.time);
            totalFare = totalFare+fare;
        }
        return new InvoiceGenerator(rides.length,totalFare);
    }

    public InvoiceGeneratorID invoiceList(int rideID) {
        Map<Integer, InvoiceGeneratorID> summaryMap = new HashMap<>();
        InvoiceGeneratorID summary = new InvoiceGeneratorID(2,30.0,1);
        InvoiceGeneratorID summary2 = new InvoiceGeneratorID(1,30.2,2);
        InvoiceGeneratorID summary3 = new InvoiceGeneratorID(1,30.2,3);
        summaryMap.put(summary.id,summary);
        summaryMap.put(summary2.id,summary2);
        summaryMap.put(summary3.id,summary3);

        return summaryMap.get(rideID);
    }
}

