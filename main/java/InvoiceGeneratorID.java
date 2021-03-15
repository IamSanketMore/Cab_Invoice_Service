public class InvoiceGeneratorID
{
    public final int rides;
    public final double fare;
    public final double avgFare;
    public final int id;

    public InvoiceGeneratorID(int rides, double fare, int id) {
        this.rides = rides;
        this.fare = fare;
        this.avgFare = this.fare/this.rides;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
       InvoiceGeneratorID summary = (InvoiceGeneratorID) o;
        return Double.compare(summary.avgFare, avgFare) == 0
                && rides == summary.rides
                && Double.compare(summary.fare, fare) == 0
                && id == summary.id;
    }
}
