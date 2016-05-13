package com.example.zhangbeihua.patientcase.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;

import com.example.zhangbeihua.patientcase.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdFragment extends Fragment {

    private Button btnDiseaseHistory;




    public ThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V = inflater.inflate(R.layout.fragment_third, container, false);


        btnDiseaseHistory = (Button)V.findViewById(R.id.btnDiseaseHistory);

        btnDiseaseHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentR = new Intent(getActivity(), DiseasehistoryActivity.class);
                startActivity(intentR);
            }
        });




        return V;
    }
}
