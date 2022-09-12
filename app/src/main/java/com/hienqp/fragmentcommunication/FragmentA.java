package com.hienqp.fragmentcommunication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class FragmentA extends Fragment {

    TextView txtA;
    EditText edtA;
    Button btnA;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);

        txtA = view.findViewById(R.id.textviewFragA);
        edtA = view.findViewById(R.id.edittextFragA);
        btnA = view.findViewById(R.id.buttonFragA);

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txtMain = getActivity().findViewById(R.id.textview_Main);
                txtMain.setText(edtA.getText().toString());
            }
        });

        return view;
    }

    public void GanNoiDung(String str) {
        txtA.setText(str);
    }
}
