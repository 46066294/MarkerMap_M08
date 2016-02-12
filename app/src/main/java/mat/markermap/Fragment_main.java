package mat.markermap;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;


public class Fragment_main extends Fragment {
    public Fragment_main(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_main, container, false);

        NoteMap app = (NoteMap)getActivity().getApplication();
        Firebase ref = app.getRef();

        ref.child("hijo1").setValue("valor_1");

        Nota notaInicial = new Nota("Ecaib", "Institut Poblenou", 41.39834,2.20318);
        Nota notaVacia = new Nota();
        ref.child("prueba").child("Notas").child("nota1").setValue(notaInicial);
        ref.child("prueba").child("Notas").child("nota2").setValue(notaVacia);


        ref.child("hijo1").child("Notas").child("nota2")
                .addValueEventListener(new ValueEventListener() {
                    //@TargetApi(Build.VERSION_CODES.M)
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        System.out.println("XXX:" + snapshot.getValue());
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            msgToast(getContext(), "titulo", snapshot.getValue().toString());
                        }

                        System.out.println(snapshot.getValue().toString());
                    }

                    //@TargetApi(Build.VERSION_CODES.M)
                    @Override
                    public void onCancelled(FirebaseError error) {

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            msgToast(getContext(), "Error", "Listener");
                        }
                    }
                });
        return view;
    }

    public void msgToast (Context context, String tag, String msg){
        Toast.makeText(context, tag + ": " + msg, Toast.LENGTH_LONG).show();
    }

}
