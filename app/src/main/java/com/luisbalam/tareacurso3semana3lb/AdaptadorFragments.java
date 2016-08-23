package com.luisbalam.tareacurso3semana3lb;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by luisbalam on 14/08/16.
 */
public class AdaptadorFragments extends FragmentPagerAdapter {
    ArrayList<Fragment> fragmentsMainActivity;

    public AdaptadorFragments(FragmentManager fm, ArrayList<Fragment> fragmentsMainActivity) {
        super(fm);
        this.fragmentsMainActivity=fragmentsMainActivity;
    }
    @Override
    public Fragment getItem(int position) {
        return fragmentsMainActivity.get(position);
    }

    @Override
    public int getCount() {
        return fragmentsMainActivity.size();
    }
}
