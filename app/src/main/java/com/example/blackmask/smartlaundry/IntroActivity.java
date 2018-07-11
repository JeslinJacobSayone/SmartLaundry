package com.example.blackmask.smartlaundry;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class IntroActivity extends AppCompatActivity {

    ViewPager mPager;
    @Override
    protected void onCreate(Bundle savedInstanceState   ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        mPager=findViewById(R.id.intro_viewPager);
        mPager.setAdapter(new ViewPagerAdapter());
        mPager.setPageTransformer(true,new TrasformerAdapter());

    }

    class ViewPagerAdapter extends PagerAdapter{


        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view==object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            View view=null;
            switch (position){
                case 0:
                    view=view.inflate(IntroActivity.this,R.layout.intro_one,null);

                    break;
                case 1:
                    view=view.inflate(IntroActivity.this,R.layout.intro_two,null);
//
                    break;
            }
            container.addView(view);
            return view;
        }
    }


    private class TrasformerAdapter implements ViewPager.PageTransformer{

        @Override
        public void transformPage(@NonNull View page, float position) {

            int pageWidth = page.getWidth();
            int pageHeight = page.getHeight();

         switch (page.getId()){
             case R.id.slide_one:
                 ImageView basket=page.findViewById(R.id.ic_intro_one);
//                 basket.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),
//                         R.anim.spring_animation));
                 basket.setTranslationY(-1 * position * pageHeight);
                 basket.setAlpha(1.0f - Math.abs(position));
                 break;
             case R.id.slide_two:
                 ImageView iron=page.findViewById(R.id.ic_intro_two);

                 if (position < -1) {

                 } else if (position < 0) {
                     iron.setTranslationY(-1 * position * pageHeight);
                     iron.setAlpha(1.0f - Math.abs(position));


                 } else if (position <= 1) {

                     iron.setTranslationY((float) (0.3 * position * pageHeight));

                 } else {

                 }
                 break;
         }
        }
    }
}
