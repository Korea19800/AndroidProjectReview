package org.techtown.fragprac2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;


public class ImageFragment extends Fragment {
    ImageView imageView;

    public interface ImageSelectionCallback {
        public void onImageSelected();
    }

    ImageSelectionCallback callback;

    public ImageFragment() {
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
        imageView = (ImageView) rootView.findViewById(R.id.imageView1);

        return rootView;
    }

}
