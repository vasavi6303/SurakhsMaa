package com.example.saimouni.surakhsmaa;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaRecorder;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class HomeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner monthSpinner;
    TextView monthText;
    ArrayList<String> months = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    Button tipOfTheDayBtn;
    SharedPreferences sharedPref;
    Button videosBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        monthSpinner = findViewById(R.id.monthSpinner);
        monthText = findViewById(R.id.monthText);
        tipOfTheDayBtn = findViewById(R.id.tipOfTheDayBtn);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        videosBtn = findViewById(R.id.videosBtn);

        months.add("Select month :");
        months.add("1st");
        months.add("2nd");
        months.add("3rd");
        months.add("4th");
        months.add("5th");
        months.add("6th");
        months.add("7th");
        months.add("8th");
        months.add("9th");
        monthSpinner.setOnItemSelectedListener(this);
        arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,months);
        monthSpinner.setAdapter(arrayAdapter);
        if (sharedPref.getString("LAST_LAUNCH_DATE","s").equals(new SimpleDateFormat("yyyy/MM/dd", Locale.US).format(new Date())))
        {
            // Date matches. User has already Launched the app once today. So do nothing.
        }
        else
        {
    showAlert();
            sharedPref.edit().putString( "LAST_LAUNCH_DATE", new SimpleDateFormat("yyyy/MM/dd", Locale.US).format(new Date())).apply();
        }

        tipOfTheDayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlert();
            }
        });
        videosBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,VideosActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void showAlert() {
        AlertDialog alertDialog = null;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setTitle("Tip of the day!");
        builder.setMessage("Drink 3Ltrs of water daily to be more healthier");
        alertDialog = builder.create();
        alertDialog.show();

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i){
            case 0 :monthText.setText("Select a month to view the month guide");
            break;
            case 1 : monthText.setText(R.string.month1);
            break;
            case 2 :monthText.setText(R.string.month1);
            break;
            case 3 :monthText.setText(R.string.month1);
            break;
            case 4 : monthText.setText(R.string.month4);
                break;
            case 5 :monthText.setText(R.string.month5);
                break;
            case 6 :monthText.setText(R.string.month6);
                break;
            case 7 : monthText.setText(R.string.month7);
                break;
            case 8 :monthText.setText(R.string.month8);
                break;
            case 9 :monthText.setText(R.string.month9);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
