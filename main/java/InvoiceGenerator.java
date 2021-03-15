public class InvoiceGenerator
{

    public final int rides;
    public final double fare;
    public final double avgFare;

    public InvoiceGenerator(int rides, double fare) {
        this.rides = rides;
        this.fare = fare;
        this.avgFare = this.fare/this.rides;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceGenerator summary = (InvoiceGenerator) o;
        return Double.compare(summary.avgFare, avgFare) == 0 && rides == summary.rides && Double.compare(summary.fare, fare) == 0;
    }

}
