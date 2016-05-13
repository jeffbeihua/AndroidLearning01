package com.example.zhangbeihua.patientcase.Activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.example.zhangbeihua.patientcase.R;
import android.view.View.OnClickListener;
import java.util.Calendar;
/**
 * Created by zhangbeihua on 12/05/16.
 */

public class DiseasehistoryrowAdapter extends ArrayAdapter<String>{


    DiseasehistoryrowAdapter(Context context, String[] foods) {
        super(context, R.layout.activity_diseasehistory_row, foods);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //return super.getView(position, convertView, parent);

        LayoutInflater diseaseHistoryInflater = LayoutInflater.from(getContext());
        View diseaseHistoryView = diseaseHistoryInflater.inflate(R.layout.activity_diseasehistory_row, parent, false);

        String singleFoodItem = getItem(position);
        TextView tvTitle = (TextView) diseaseHistoryView.findViewById(R.id.tvTitle);
        ImageView ivImage= (ImageView) diseaseHistoryView.findViewById(R.id.ivImage);

        tvTitle.setText(singleFoodItem);
        ivImage.setImageResource(R.drawable.face);
        return diseaseHistoryView;

    }
}
