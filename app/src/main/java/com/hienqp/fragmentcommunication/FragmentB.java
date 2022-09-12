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

public class FragmentB extends Fragment {

    TextView txtB;
    EditText edtB;
    Button btnB;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);

        txtB = view.findViewById(R.id.textviewFragB);
        edtB = view.findViewById(R.id.edittextFragB);
        btnB = view.findViewById(R.id.buttonFragB);

        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txtA = getActivity().findViewById(R.id.textviewFragA);
                txtA.setText(edtB.getText().toString());
            }
        });

        return view;
    }
}
