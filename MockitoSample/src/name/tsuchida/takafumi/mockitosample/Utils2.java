package name.tsuchida.takafumi.mockitosample;

import org.json.JSONException;
import org.json.JSONObject;

public class Utils2 {
    public interface ResultListener {
  	  
        void onError();
        
        void handleStatus(String status, long time);
    }  
  
    public static void handleJson(String json, ResultListener listener) {
        if (listener == null) {
            return;
        }

        try {
            JSONObject obj = new JSONObject(json);
  
            String status = obj.optString("Status");
            listener.handleStatus(status, System.currentTimeMillis());
        } catch (JSONException e) {
            listener.onError();
            e.printStackTrace();
        }
    }
}
