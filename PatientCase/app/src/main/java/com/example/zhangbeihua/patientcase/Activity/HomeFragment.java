package com.example.zhangbeihua.patientcase.Activity;


import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;


import com.example.zhangbeihua.patientcase.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private Button btnCreatePatientCase;



    public HomeFragment() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View V = inflater.inflate(R.layout.fragment_home, container, false);

        btnCreatePatientCase = (Button)V.findViewById(R.id.btnCreatePatientCase);

        setbtnCreatePatientCaseListener();

        return V;
    }



    private void setbtnCreatePatientCaseListener() {
        btnCreatePatientCase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CaseActivity.class);
                startActivity(intent);
                //Toast.makeText(getActivity(), "Hello", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
