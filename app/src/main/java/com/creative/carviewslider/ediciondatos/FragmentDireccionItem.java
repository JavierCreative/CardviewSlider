package com.creative.carviewslider.ediciondatos;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.creative.carviewslider.R;

public class FragmentDireccionItem extends Fragment implements FragmentListener
{
    private TextView mCalle;
    private TextView mNoExt;
    private TextView mNoInt;
    private TextView mCodigoPost;
    private TextView mColonia;
    private TextView mAlcaldia;
    private TextView mCiudad;
    private TextView mEstado;
    private TextView mPais;
    private CardView mCard;

    private static String CALLE_KEY = "some.package.CALLE_KEY";
    private static String NO_EXT_KEY = "some.package.NO_EXT_KEY";
    private static String NO_INT_KEY = "some.package.NO_INT_KEY";
    private static String CODIGO_POST_KEY = "some.package.CODIGO_POST_KEY";
    private static String COLONIA_KEY = "some.package.COLONIA_KEY";
    private static String ALCALDIA_KEY = "some.package.ALCALDIA_KEY";
    private static String PAIS_KEY = "some.package.PAIS_KEY";
    private static String CIUDAD_KEY = "some.package.CIUDAD_KEY";
    private static String ESTADO_KEY = "some.package.ESTADO_KEY";

    private Context mContext;


    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        if (context instanceof Activity)
            mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = LayoutInflater.from(mContext).inflate(R.layout.direccion_item_card,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        init(view);
        dataSetup();
    }

    private void init(View v)
    {
        mCalle = v.findViewById(R.id.calle_textview);
        mNoExt = v.findViewById(R.id.noExt_textview);
        mNoInt = v.findViewById(R.id.noInt_textview);
        mCodigoPost = v.findViewById(R.id.codigoPost_textview);
        mColonia = v.findViewById(R.id.colonia_textview);
        mAlcaldia = v.findViewById(R.id.alcaldia_textview);
        mCiudad = v.findViewById(R.id.ciudad_textview);
        mEstado = v.findViewById(R.id.estado_textview);
        mPais = v.findViewById(R.id.pais_textview);
        mCard = v.findViewById(R.id.direccion_cardview);
    }

    private void dataSetup()
    {
        Bundle args = getArguments();
        String calle  = args.getString(CALLE_KEY);
        String noExt = args.getString(NO_EXT_KEY);
        String noInt  = args.getString(NO_INT_KEY);
        String codigoPost  = args.getString(CODIGO_POST_KEY);
        String colonia  = args.getString(COLONIA_KEY);
        String alcaldia  = args.getString(ALCALDIA_KEY);
        String pais  = args.getString(PAIS_KEY);
        String ciudad  = args.getString(CIUDAD_KEY);
        String estado  = args.getString(ESTADO_KEY);

        mCalle.setText(calle);
        mNoExt.setText(noExt);
        mNoInt.setText(noInt);
        mCodigoPost.setText(codigoPost);
        mColonia.setText(colonia);
        mAlcaldia.setText(alcaldia);
        mPais.setText(pais);
        mCiudad.setText(ciudad);
        mEstado.setText(estado);

    }

    public static Bundle createBundle(String calle, String noExt, String noInt, String codigoPost,
                                      String colonia, String alcaldia, String pais, String ciudad, String estado)
    {
        Bundle args = new Bundle();
        args.putString(CALLE_KEY,calle);
        args.putString(NO_EXT_KEY,noExt);
        args.putString(NO_INT_KEY,noInt);
        args.putString(CODIGO_POST_KEY,codigoPost);
        args.putString(COLONIA_KEY,colonia);
        args.putString(ALCALDIA_KEY,alcaldia);
        args.putString(PAIS_KEY,pais);
        args.putString(CIUDAD_KEY,ciudad);
        args.putString(ESTADO_KEY,estado);
        return args;
    }

    @Override
    public CardView getCard() {
        return mCard;
    }
}
