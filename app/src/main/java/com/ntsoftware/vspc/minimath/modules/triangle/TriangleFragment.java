package com.ntsoftware.vspc.minimath.modules.triangle;

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
import com.ntsoftware.vspc.minimath.modules.equation.QEquation;

public class TriangleFragment extends Fragment {

    private View root;
    private Context context;

    private TextInputEditText input_a;
    private TextInputEditText input_h;

    private TextView square_out;

    private View square_out_field;

    private ExtendedFloatingActionButton button;

    Triangle triangle;

    private int a;
    private int h;


    public TriangleFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    View.OnClickListener button_click = view -> {

        restVisibility();

        if (isCorrectInput()) {
            float square = Triangle.getSquare(a,h);
            square_out_field.setVisibility(View.VISIBLE);
            square_out.setText(Float.toString(square));
        }
    };

    private void restVisibility() {
        square_out_field.setVisibility(View.GONE);
    }

    private boolean isCorrectInput() {

        if (input_a.getText().toString().isEmpty() && input_h.getText().toString().isEmpty()) {
            Toast.makeText(context,"Введите все коэффиценты", Toast.LENGTH_SHORT).show();
            return false;
        }

        try {
            a = Integer.parseInt(input_a.getText().toString());
            h = Integer.parseInt(input_h.getText().toString());
        } catch (Exception e) {
            Toast.makeText(context,"Введено не число", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_triangle, container, false);

        context = root.getContext();

        input_a = root.findViewById(R.id.input_a);
        input_h = root.findViewById(R.id.input_h);
        square_out_field = root.findViewById(R.id.square_out_field);

        square_out = root.findViewById(R.id.square_out);

        button = root.findViewById(R.id.button_count);

        button.setOnClickListener(button_click);

        return root;
    }
}