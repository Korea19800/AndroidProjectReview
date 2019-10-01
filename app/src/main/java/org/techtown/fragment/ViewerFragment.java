package org.techtown.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ViewerFragment extends Fragment {
    // 0. 이 Fragment는 이미지들을 보여주기 위한 fragment
    ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
    // 1. Fragment의 최상위layout인 rootView에 inflate 넣어줌
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_viewer, container, false);
    // 2.imageView를  프래글먼트에서 찾아줌
      imageView=rootView.findViewById(R.id.imageView);
        return rootView;
    }

    // 3. Maind의 콜백메소드가 실행되면 이 메소드가 실행됨
    public void setImage(int resId) {
        imageView.setImageResource(resId);
    }

}
