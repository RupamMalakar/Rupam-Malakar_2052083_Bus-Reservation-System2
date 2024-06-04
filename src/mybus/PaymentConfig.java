package mybus;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

public class PaymentConfig {
    private static final String API_KEY = "************";
    private static final String API_SECRET = "***********";

    private static RazorpayClient razorpayClient;

    static {
        try {
            razorpayClient = new RazorpayClient(API_KEY, API_SECRET);
        } catch (RazorpayException e) {
            e.printStackTrace();
        }
    }

    public static RazorpayClient getClient() {
        return razorpayClient;
    }
}
