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

public class FragmentContactoItem extends Fragment implements FragmentListener
{
    private TextView mCelular;
    private TextView mParticular;
    private TextView mOficina;
    private TextView mCorreoPrincipal;
    private TextView mCorreoOpcional;
    private CardView mCard;

    private static String CELULAR_KEY = "some.package.CELULAR_KEY";
    private static String PARTICULAR_KEY = "some.package.PARTICULAR_KEY";
    private static String OFICINA_KEY = "some.package.OFICINA_KEY";
    private static String CORREO_KEY = "some.package.CORREO_PRINCIPAL_KEY";
    private static String OPCIONAL_KEY = "some.package.CORREO_OPCIONAL_KEY";

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
        View view = LayoutInflater.from(mContext).inflate(R.layout.contacto_item_card,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        init(view);
        dataSetup();
    }

    private void init(View v)
    {
        mCelular = v.findViewById(R.id.celular_textview);
        mParticular = v.findViewById(R.id.particular_textview);
        mOficina = v.findViewById(R.id.oficina_textview);
        mCorreoOpcional = v.findViewById(R.id.correoOp_textview);
        mCorreoPrincipal = v.findViewById(R.id.correoPrin_textview);
        mCard = v.findViewById(R.id.contacto_cardview);
    }

    private void dataSetup()
    {
        Bundle args = getArguments();
        String celular  = args.getString(CELULAR_KEY);
        String particular = args.getString(PARTICULAR_KEY);
        String oficina  = args.getString(OFICINA_KEY);
        String principal  = args.getString(CORREO_KEY);
        String opcional  = args.getString(OPCIONAL_KEY);

        mCelular.setText(celular);
        mParticular.setText(particular);
        mOficina.setText(oficina);
        mCorreoPrincipal.setText(principal);
        mCorreoOpcional.setText(opcional);

    }


    public static Bundle createBundle(String celular, String particular, String oficina, String correoPrincipal,String correoOpcional)
    {
        Bundle args = new Bundle();
        args.putString(CELULAR_KEY,celular);
        args.putString(PARTICULAR_KEY,particular);
        args.putString(OFICINA_KEY,oficina);
        args.putString(CORREO_KEY,correoPrincipal);
        args.putString(OPCIONAL_KEY,correoOpcional);
        return args;
    }

    @Override
    public CardView getCard() {
        return mCard;
    }
}
