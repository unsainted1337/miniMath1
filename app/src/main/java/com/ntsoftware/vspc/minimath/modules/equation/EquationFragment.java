package com.ntsoftware.vspc.minimath.modules.equation;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.ntsoftware.vspc.minimath.R;

import org.apache.commons.lang3.StringUtils;

public class EquationFragment extends Fragment {

    private View root;
    private Context context;

    private TextInputEditText input_a;
    private TextInputEditText input_b;
    private TextInputEditText input_c;

    private View discriminant_out_field;
    private View root1_out_field;
    private View root2_out_field;
    private View equation_nonroot;

    private TextView discriminant_out;
    private TextView root1_out;
    private TextView root2_out;

    private ExtendedFloatingActionButton button;

    private QEquation equation;

    private int a;
    private int b;
    private int c;


    public EquationFragment() {
        // Required empty public constructor
    }

    public static EquationFragment newInstance() {
        return new EquationFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    View.OnClickListener button_click = view -> {

        restVisibility();

        if (isCorrectInput()) {
            equation = new QEquation(a,b,c);

            String D = Double.toString(equation.getDiscriminant());

            double[] equationXs = equation.getXs();

            discriminant_out.setText(D);
            discriminant_out_field.setVisibility(View.VISIBLE);

            if(equation.getDiscriminant() < 0) {
                discriminant_out.setTextColor(getResources().getColor(R.color.equation_primary_red));
                equation_nonroot.setVisibility(View.VISIBLE);
            }
            else {
                discriminant_out.setTextColor(getResources().getColor(R.color.equation_primary));

                if(equationXs.length > 1) {
                    root1_out_field.setVisibility(View.VISIBLE);
                    root1_out.setText(Double.toString(equationXs[0]));

                    root2_out_field.setVisibility(View.VISIBLE);
                    root2_out.setText(Double.toString(equationXs[1]));
                }
                else if (equationXs.length == 1) {
                    root1_out_field.setVisibility(View.VISIBLE);
                    root1_out.setText(Double.toString(equationXs[0]));
                }
            }
        }
    };

    private void restVisibility() {
        root1_out_field.setVisibility(View.GONE);
        root2_out_field.setVisibility(View.GONE);
        discriminant_out_field.setVisibility(View.GONE);
        equation_nonroot.setVisibility(View.GONE);
    }

    private boolean isCorrectInput() {

        if (input_a.getText().toString().isEmpty() && input_b.getText().toString().isEmpty() && input_c.getText().toString().isEmpty()) {
            Toast.makeText(context,"Введите все коэффиценты", Toast.LENGTH_SHORT).show();
            return false;
        }

        try {
            a = Integer.parseInt(input_a.getText().toString());
            b = Integer.parseInt(input_b.getText().toString());
            c = Integer.parseInt(input_c.getText().toString());
        } catch (Exception e) {
            Toast.makeText(context,"Введено не число", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_equation, container, false);

        context = root.getContext();

        input_a = root.findViewById(R.id.input_a);
        input_b = root.findViewById(R.id.input_b);
        input_c = root.findViewById(R.id.input_c);

        discriminant_out_field = root.findViewById(R.id.discriminant_out_field);
        root1_out_field = root.findViewById(R.id.root1_out_field);
        root2_out_field = root.findViewById(R.id.root2_out_field);
        equation_nonroot = root.findViewById(R.id.equation_nonroot);

        discriminant_out = root.findViewById(R.id.discriminant_out);
        root1_out = root.findViewById(R.id.root1_out);
        root2_out = root.findViewById(R.id.root2_out);

        button = root.findViewById(R.id.equation_button_count);

        button.setOnClickListener(button_click);

        return root;
    }
}