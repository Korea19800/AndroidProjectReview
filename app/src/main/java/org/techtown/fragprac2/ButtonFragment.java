package org.techtown.fragprac2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ButtonFragment extends Fragment {
    public interface ImageSelectionCallback {
        public void onImageSelected();
    }

    ImageSelectionCallback callback;

    public ButtonFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof ImageSelectionCallback) {
            callback = (ImageSelectionCallback) context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_button, container, false);
        Button button1 = rootView.findViewById(R.id.button1);
        Button button2 = rootView.findViewById(R.id.button1);
        Button button3 = rootView.findViewById(R.id.button1);


        return rootView;
    }


}
