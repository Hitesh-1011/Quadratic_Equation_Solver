package com.example.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity{
    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        Button button = findViewById(R.id.b1);
        button.setOnClickListener(new View.OnClickListener(){
                                      @Override
                                      public void onClick(View view) {
                                          EditText z1 = findViewById(R.id.e1);
                                          EditText z2 = findViewById(R.id.e2);
                                          EditText z3 = findViewById(R.id.e3);
                                          String a1 = z1.getText().toString();
                                          String b1 = z2.getText().toString();
                                          String c1 = z3.getText().toString();
                                          if(a1.isEmpty() || b1.isEmpty() || c1.isEmpty()) {
                                              TextView e = findViewById(R.id.x1);
                                              e.setVisibility(View.VISIBLE);
                                              e.setText("Nothing is inserted");

                                              TextView f = findViewById(R.id.x2);
                                              f.setVisibility(View.VISIBLE);
                                              f.setText("Please Enter all the coeffients");
                                          }
                                          else {
                                              Double a = Double.parseDouble(z1.getText().toString());
                                              Double b = Double.parseDouble(z2.getText().toString());
                                              Double c = Double.parseDouble(z3.getText().toString());
                                              Double d;

                                              d = b * b - 4 * a * c;
                                              if (a == 0) {
                                                  TextView q = findViewById(R.id.x1);
                                                  q.setVisibility(View.VISIBLE);
                                                  q.setText("Coefficient of 'a' cant be Zero");

                                                  TextView i = findViewById(R.id.x2);
                                                  i.setVisibility(View.VISIBLE);
                                                  i.setText("Please Give Some other Coeffiecients");
                                              } else {
                                                  if (d >= 0) {
                                                      solution(a, b, c, d);
                                                  } else {
                                                      TextView q = findViewById(R.id.x1);
                                                      q.setVisibility(View.VISIBLE);
                                                      q.setText("Complex Roots can't be shown");

                                                      TextView i = findViewById(R.id.x2);
                                                      i.setVisibility(View.VISIBLE);
                                                      i.setText("Please Give Some other Coeffiecients");
                                                  }
                                              }
                                          }
                                      }
                                  });
    }
    public  void solution(double a, double b, double c, double d){
        double x1=(-b+Math.sqrt(d))/(2*a);
        double x2=(-b-Math.sqrt(d))/(2*a);

        TextView t = findViewById(R.id.x1);
        t.setVisibility(View.VISIBLE);
        t.setText(String.valueOf(x1));

        TextView u = findViewById(R.id.x2);
        u.setVisibility(View.VISIBLE);
        u.setText(String.valueOf(x2));
    }
}
