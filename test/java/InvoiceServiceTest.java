import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {

    InvoiceService invoiceService = null;

    @Before
    public void setUp() throws Exception {
        invoiceService = new InvoiceService();
    }

    @Test
    public void givenDisAndTime_shouldReturn_totalFare() {
        double fare = invoiceService.CalculateFare(10.0 , 30.1);
        Assert.assertEquals(130.1 , fare,0.0);
    }

    @Test
    public void givenMultipleDisAndTime_shouldReturn_InvoiceSummary() {
        Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1)};
        InvoiceGenerator summary = invoiceService.CalculateFare(rides);
        InvoiceGenerator expectedInvoiceSummary =new InvoiceGenerator(2,30.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);

    }

    @Test

    public void givenUserID_shouldReturn_invoiceList() {
        int rideId= 2;
        InvoiceGeneratorID summary = invoiceService.invoiceList(rideId);
        InvoiceGeneratorID expectedInvoiceSummary = new InvoiceGeneratorID(1,30.2,2);
        Assert.assertEquals(expectedInvoiceSummary,summary);
    }
}