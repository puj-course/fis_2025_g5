package g5.ROPA;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SMS {
	public static final String ACCOUNT_SID = "AC5a4f4547d8b815b7c8e70c8b964c9bbf"/*System.getenv("TWILIO_ACCOUNT_SID")*/;
	public static final String AUTH_TOKEN = "309224a1dc1d6ae6b66b2e195817de99"/*System.getenv("TWILIO_AUTH_TOKEN")*/;
	
	private static SMS instance;

    // Constructor privado para evitar instanciación externa
    private SMS() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    // Método de acceso global a la instancia única
    public static SMS getInstance() {
        if (instance == null) {
            synchronized (SMS.class) {
                if (instance == null) {
                    instance = new SMS();
                }
            }
        }
        return instance;
    }

    public void enviarSMS(String mensaje) {
        Message message = Message.creator(
                new PhoneNumber("+573028464712"),
                new PhoneNumber("+14845724592"),
                mensaje
        ).create();
    }
}
