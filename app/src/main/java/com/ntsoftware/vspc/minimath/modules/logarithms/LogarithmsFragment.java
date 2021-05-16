package com.ntsoftware.vspc.minimath.modules.logarithms;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.ntsoftware.vspc.minimath.R;


public class LogarithmsFragment extends Fragment {

    private View root;
    private Context context;

    private TextInputEditText inp_a;
    private TextInputEditText inp_b;

    private TextView result_out;

    private View square_out_field;

    private ExtendedFloatingActionButton button;



    private int a;
    private int b;

    public LogarithmsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    View.OnClickListener button_click = view -> {

        restVisibility();

        if (isCorrectInput()) {
            double square = (Math.log(b)/ Math.log(a));
            square_out_field.setVisibility(View.VISIBLE);
            result_out.setText(Float.toString((float) square));
        }
    };

    private void restVisibility() {
        square_out_field.setVisibility(View.GONE);
    }

    private boolean isCorrectInput() {

        if (inp_a.getText().toString().isEmpty() && inp_b.getText().toString().isEmpty()) {
            Toast.makeText(context,"Введите все коэффиценты", Toast.LENGTH_SHORT).show();
            return false;
        }

        try {
            a = Integer.parseInt(inp_a.getText().toString());
            b = Integer.parseInt(inp_b.getText().toString());
        } catch (Exception e) {
            Toast.makeText(context,"Введено не число", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_logarithms, container, false);

        context = root.getContext();

        inp_a = root.findViewById(R.id.inp_a);
        inp_b = root.findViewById(R.id.inp_b);
        square_out_field = root.findViewById(R.id.square_out_field);

        result_out = root.findViewById(R.id.result_out);

        button = root.findViewById(R.id.button_result);

        button.setOnClickListener(button_click);

        return root;

    }



}