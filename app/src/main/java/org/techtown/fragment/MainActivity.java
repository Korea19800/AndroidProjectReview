package org.techtown.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

                                                                // 0. 콜백메소드를 사용하기 위해 ListFragment클래스의 인터페이스를 구현!
public class MainActivity extends AppCompatActivity implements ListFragment.ImageSelectionCallback {

    ListFragment listFragment;
    ViewerFragment viewerFragment;
    // 1. Image들을 array에 넣어둠
    int[] images = {R.drawable.justice, R.drawable.messigod, R.drawable.coding};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2.FragmentMangaer중 getSuport~를 변수안에 넣는다
        FragmentManager manager = getSupportFragmentManager();

        // 3. manager.를 통해 xml에 존재하는 onCreate에서 프래그먼트들을 찾아줌
        listFragment = (ListFragment) manager.findFragmentById(R.id.listFragment);
        viewerFragment = (ViewerFragment) manager.findFragmentById(R.id.viewerFragment);
    }
    @Override
    public void onImageSelected(int position) {
        // 4. 이 메소드가 실행되면 viewerFragment에 setImage메소드를 실행!
        viewerFragment.setImage(images[position]);
    }
}
