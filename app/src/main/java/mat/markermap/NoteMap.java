package mat.markermap;

/**
 * Created by Mat on 12/02/2016.
 */
import android.app.Application;

import com.firebase.client.Firebase;

public class NoteMap extends Application{

    private Firebase ref;

    public Firebase getRef() {
        return ref;
    }

    public void setRef(Firebase ref) {
        this.ref = ref;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
        // other setup code
        ref = new Firebase("https://incandescent-inferno-592.firebaseio.com");

        /*ref.authWithPassword("Mim@firebase.com", "Mim", new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticated(AuthData authData) {
                System.out.println("User ID: " + authData.getUid() + ", Provider: " + authData.getProvider());
            }
            @Override
            public void onAuthenticationError(FirebaseError firebaseError) {
                // there was an error
            }
        });*/

    }
}