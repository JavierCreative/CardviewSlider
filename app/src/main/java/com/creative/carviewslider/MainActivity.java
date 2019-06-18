package com.creative.carviewslider;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.creative.carviewslider.ediciondatos.FragmentContactoItem;
import com.creative.carviewslider.ediciondatos.FragmentDireccionItem;
import com.creative.carviewslider.ediciondatos.FragmentPersonalesItem;

public class MainActivity extends AppCompatActivity
{

    private ViewPager mViewPager;
    private TabLayout mTabIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = findViewById(R.id.slider_viewpager);
        mTabIndicator = findViewById(R.id.tab_indicator_tablayout);
        createFragments();
    }

    private void createFragments()
    {
        FragmentPersonalesItem personales = new FragmentPersonalesItem();
        Bundle argsPersonales = FragmentPersonalesItem.createBundle("3283283823","Javier Garcia","FSSD32323GRO00C","SJDFHDSHFHJDSHF34234","20/12/1996","Masculino","Mexico","Mexicana");
        personales.setArguments(argsPersonales);

        FragmentDireccionItem direcciones = new FragmentDireccionItem();
        Bundle argsDirecciones = FragmentDireccionItem.createBundle("minita","8","","36990","Zona centro","","Mexico","Huanimaro","Guanajuato");
        direcciones.setArguments(argsDirecciones);

        FragmentContactoItem contacto = new FragmentContactoItem();
        Bundle argsContacto = FragmentContactoItem.createBundle("4291233049","4296910253","","javier.creative.apps@gmail.com","");
        contacto.setArguments(argsContacto);

        CardFragmentAdapter adapter = new CardFragmentAdapter(getSupportFragmentManager());
        adapter.addItem(personales);
        adapter.addItem(direcciones);
        adapter.addItem(contacto);

        Transformer transformer = new Transformer(mViewPager, adapter);
        transformer.enableScaling(true);
        mViewPager.setPageTransformer(false, transformer);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(adapter);
        mTabIndicator.setupWithViewPager(mViewPager);
    }
}
