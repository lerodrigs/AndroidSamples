package pushnotification.sample.com.samplepushnotification;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService
{
    public static String token = null;

    @Override
    public void onTokenRefresh()
    {
        token = FirebaseInstanceId.getInstance().getToken();
        Log.d("TOKEN: ", token);

        System.out.println("TOKEN => " + token);
    }
}
