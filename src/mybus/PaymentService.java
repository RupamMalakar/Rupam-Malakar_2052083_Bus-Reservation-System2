package mybus;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;

public class PaymentService {

    private RazorpayClient client;

    public PaymentService() {
        this.client = PaymentConfig.getClient();
    }

    public Order createOrder(double amount, String currency, String receipt) throws RazorpayException {
        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", (int) (amount * 100)); // amount in the smallest currency unit
        orderRequest.put("currency", currency);
        orderRequest.put("receipt", receipt);
        orderRequest.put("payment_capture", true);

        return client.Orders.create(orderRequest);
    }
}
