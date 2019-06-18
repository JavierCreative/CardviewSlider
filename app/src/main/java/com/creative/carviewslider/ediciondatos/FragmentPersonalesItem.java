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

public class FragmentPersonalesItem extends Fragment implements FragmentListener
{
    private TextView mNss;
    private TextView mNombre;
    private TextView mCurp;
    private TextView mRfc;
    private TextView mFecha;
    private TextView mSexo;
    private TextView mPais;
    private TextView mNacionalidad;
    private CardView mCard;

    private static String NSS_KEY = "some.package.NSS_KEY";
    private static String NOMBRE_KEY = "some.package.NOMBRE_KEY";
    private static String CURP_KEY = "some.package.CURP_KEY";
    private static String RFC_KEY = "some.package.RFC_KEY";
    private static String FECHA_KEY = "some.package.FECHA_KEY";
    private static String SEXO_KEY = "some.package.SEXO_KEY";
    private static String PAIS_KEY = "some.package.PAIS_KEY";
    private static String NACIONALIDAD_KEY = "some.package.NACIONALIDAD_KEY";

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
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.personales_item_card,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        init(view);
        dataSetup();
    }

    private void init(View v)
    {
        mNss = v.findViewById(R.id.nss_textview);
        mNombre = v.findViewById(R.id.nombre_textview);
        mCurp = v.findViewById(R.id.curp_textview);
        mRfc = v.findViewById(R.id.rfc_textview);
        mFecha = v.findViewById(R.id.fecha_textview);
        mSexo = v.findViewById(R.id.sexo_textview);
        mPais = v.findViewById(R.id.pais_textview);
        mNacionalidad = v.findViewById(R.id.nacionalidad_textview);
        mCard = v.findViewById(R.id.personales_cardview);
    }

    private void dataSetup()
    {
        Bundle args = getArguments();
        String nss  = args.getString(NSS_KEY);
        String nombre = args.getString(NOMBRE_KEY);
        String curp  = args.getString(CURP_KEY);
        String rfc  = args.getString(RFC_KEY);
        String fecha  = args.getString(FECHA_KEY);
        String sexo  = args.getString(SEXO_KEY);
        String pais  = args.getString(PAIS_KEY);
        String nacionalidad  = args.getString(NACIONALIDAD_KEY);

        mNss.setText(nss);
        mNombre.setText(nombre);
        mCurp.setText(curp);
        mRfc.setText(rfc);
        mFecha.setText(fecha);
        mSexo.setText(sexo);
        mPais.setText(pais);
        mNacionalidad.setText(nacionalidad);

    }

    public static Bundle createBundle(String nss, String nombre, String curp, String rfc,
                                      String fecha, String sexo, String pais, String nacionalidad)
    {
        Bundle args = new Bundle();
        args.putString(NSS_KEY,nss);
        args.putString(NOMBRE_KEY,nombre);
        args.putString(CURP_KEY,curp);
        args.putString(RFC_KEY,rfc);
        args.putString(FECHA_KEY,fecha);
        args.putString(SEXO_KEY,sexo);
        args.putString(PAIS_KEY,pais);
        args.putString(NACIONALIDAD_KEY,nacionalidad);
        return args;
    }

    @Override
    public CardView getCard() {
        return mCard;
    }
}
