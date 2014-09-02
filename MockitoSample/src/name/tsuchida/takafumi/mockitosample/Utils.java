package name.tsuchida.takafumi.mockitosample;

import org.json.JSONException;
import org.json.JSONObject;

public class Utils {
    public interface ResultListener {
    	  
        void onError();
  
        void onHoge1();
  
        void onHoge2();
    }  
  
    public static void handleJson(String json, ResultListener listener) {
        if (listener == null) {
            return;
        }

        try {
            JSONObject obj = new JSONObject(json);
  
            String status = obj.optString("Status");

            if (status.equals("hoge1")) {
                listener.onHoge1();

            } else if (status.equals("hoge2")) {
                listener.onHoge2();
            }

        } catch (JSONException e) {
            listener.onError();
            e.printStackTrace();
        }
    }
}
