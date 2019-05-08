package com.example.nowmancompany.convertnumbertowordtool;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {
    EditText edNumber;
    Button btntest;
    TextView textWord,textWordcount;
    FloatingActionButton fab;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linkViews();
        setSupportActionBar(toolbar);





        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        btntest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               if(edNumber.getText().toString().isEmpty()) {
                   edNumber.setError("Enter Number");
                   return;
               }
               else
               {

                   String result = NumberToArabic.convertToArabic(  BigDecimal.valueOf( Double.valueOf(  edNumber.getText().toString() ) ),"YEN");
                   textWord.setText(result);
                   textWordcount.setText(" "+countWordsUsingSplit(result));
//                   String result = ArabicNumberToWords.convert(  Integer.valueOf(   edNumber.getText().toString()  )    );
//                   textWord.setText(result);
//              String result = EnglishNumberToWords.convert(  Integer.valueOf(   edNumber.getText().toString()  )    );
//                   textWord.setText(result);
               }



            }
        });




    }

    public static int countWordsUsingSplit(String input) {
        if (input == null || input.isEmpty()) { return 0; }
        String[] words = input.split("\\s+");
        return words.length;
    }


    public void linkViews()
    {
        edNumber=(EditText)findViewById(R.id.edNumber);
        textWord=(TextView)findViewById(R.id.textWord);
        textWordcount=(TextView)findViewById(R.id.textWordcount);
        btntest=(Button)findViewById(R.id.btntest);
         fab = (FloatingActionButton) findViewById(R.id.fab);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
















//
//    public void onClick(View v) {
//        String foo = NumberPhone.getText().toString();
//        String bar = foo.substring(0, 2);
//        if (NumberPhone.getText().toString().equals("") || NumberPhone.getText().toString().length() < 9
//                || NumberPhone.getText().toString().length() > 9 ||
//                (!bar.equals("77") && !bar.equals("73") && !bar.equals("71") && !bar.equals("70") )
//                )
//        {
//
//            if(NumberPhone.getText().toString().equals("") || NumberPhone.getText().toString().length() < 9
//                    || NumberPhone.getText().toString().length() > 9) {
//                NumberPhone.requestFocus();
//                NumberPhone.setError(getString(R.string.ErrorPhone));
//
//            }
//            if(!bar.equals("77") && !bar.equals("73") && !bar.equals("71") && !bar.equals("70")){
//                NumberPhone.requestFocus();
//                NumberPhone.setError(getString(R.string.ErrorPhone));
//
//            }
//            if (et_Name.getText().toString().length() < 3 || et_Name.getText().equals("")) {
//                et_Name.requestFocus();
//                et_Name.setError(getString(R.string.ErrorName));
//
//            }
//        }
//
//
//    }
//});