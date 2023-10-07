package com.example.a19_nastygl_22106;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ListView phonesList = findViewById(R.id.phonesList);
        ArrayList<String> phones = new ArrayList<>();
        phones.add("Google Pixel");
        phones.add("Huawei P9");
        phones.add("LG G5");
        phones.add("Samsung Galaxy S8");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, phones);
        phonesList.setAdapter(adapter);

        phonesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String selectedPhone = adapter.getItem(position);
                CustomDialogFragment dialog = new CustomDialogFragment();
                Bundle args = new Bundle();
                args.putString("phone", selectedPhone);
                dialog.setArguments(args);
                dialog.show(getSupportFragmentManager(), "custom");
            }
        });
    }
    public class CustomDialogFragment extends DialogFragment {

        @NonNull
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            String phone = getArguments().getString("phone");
            AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
            return builder
                    .setTitle("Диалоговое окно")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setMessage("Вы хотите удалить " + phone + "?")
                    .setPositiveButton("OK", null)
                    .setNegativeButton("Отмена", null)
                    .create();
        }
    }
}