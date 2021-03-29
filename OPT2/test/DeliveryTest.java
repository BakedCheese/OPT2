import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryTest {

    @Test
    void getTotalPriceDelivery() {
        double sum = Delivery.getTotalPriceDelivery(1.5 ,1.6 ,1.0);
        assertEquals(4.1, sum, 0.01);
    }
}