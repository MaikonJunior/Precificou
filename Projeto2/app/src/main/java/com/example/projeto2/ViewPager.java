package com.example.projeto2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import org.jetbrains.annotations.NotNull;

public class ViewPager extends FragmentActivity {

    private static final int Num_Pages=2;
    private FragmentStateAdapter pagerAdapter;
    private ViewPager2 vpgViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        vpgViewPager = findViewById(R.id.vpgViewPager);
        pagerAdapter = new ViewPager.ScreenSliderPageAdapter(this);
        vpgViewPager.setAdapter(pagerAdapter);
        System.out.println(" teste");
    }

    private class ScreenSliderPageAdapter extends FragmentStateAdapter {

        public ScreenSliderPageAdapter(ViewPager viewPager) {
            super(viewPager);

        }

        @NonNull
        @NotNull
        @Override
        public Fragment createFragment(int position) {
            int op = 0;
            switch(position){

                case 0:
                    op = 0;
                    break;
                case 1:
                    op = 1;
                    break;
                default:
                    return null;
            }
            if(op == 0){
                System.out.println("TESTE1");
                return new FragmentoProduto();
            }else{
                System.out.println("TESTE2");
                return new FragmentoPerfil();
            }
        }

        @Override
        public int getItemCount() {
            return Num_Pages;
        }
    }
}