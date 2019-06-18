package com.creative.carviewslider;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.ViewGroup;

import com.creative.carviewslider.ediciondatos.FragmentContactoItem;
import com.creative.carviewslider.ediciondatos.FragmentDireccionItem;
import com.creative.carviewslider.ediciondatos.FragmentPersonalesItem;

import java.util.ArrayList;
import java.util.List;

public class CardFragmentAdapter extends FragmentStatePagerAdapter implements CardAdapter
{
    private List<Fragment> mFragments;
    public CardFragmentAdapter(FragmentManager fm)
    {
        super(fm);
        mFragments = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int i)
    {
        return mFragments.get(i);
    }

    @Override
    public CardView getCardViewAt(int position)
    {
        Log.wtf("A","A");
        if (mFragments.get(position) instanceof FragmentPersonalesItem)
            return ((FragmentPersonalesItem) mFragments.get(position)).getCard();
        if (mFragments.get(position) instanceof FragmentContactoItem)
            return ((FragmentContactoItem) mFragments.get(position)).getCard();
        if (mFragments.get(position) instanceof FragmentDireccionItem)
            return ((FragmentDireccionItem) mFragments.get(position)).getCard();
        return null;
    }

    public void addItem(Fragment fragment)
    {
        mFragments.add(fragment);
    }

    @Override
    public int getCount()
    {
        return mFragments.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Object fragment =  super.instantiateItem(container, position);
        mFragments.set(position, (Fragment) fragment);
        return fragment;
    }
}
