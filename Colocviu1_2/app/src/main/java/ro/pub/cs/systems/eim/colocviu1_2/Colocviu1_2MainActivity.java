package ro.pub.cs.systems.eim.colocviu1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Colocviu1_2MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_2_main);

        Button buttonAdd = (Button) findViewById(R.id.buttonAdd);
        EditText nextTerm = (EditText) findViewById(R.id.nextTerm);
        EditText allTerms = (EditText) findViewById(R.id.allTerms);
        Button compute = (Button) findViewById(R.id.buttonCompute);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String term = nextTerm.getText().toString();
                if (!term.isEmpty()) {
                    boolean number = true;
                    try{
                        Integer.parseInt(term);

                    } catch (Exception e) {
                        number = false;
                    }
                    if (number) {
                        if (allTerms.getText().toString().isEmpty()) {
                            allTerms.setText(allTerms.getText().toString() + "" + term);
                        } else {
                            allTerms.setText(allTerms.getText().toString() + "+" + term);
                        }
                    }

                }
            }
        });

        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("ro.pub.cs.systems.eim.colocviu1_2.Colocviu1_2SecondaryActivity");
                intent.putExtra("colcviuKey", allTerms.getText().toString());
                startActivityForResult(intent, 2017);


            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        switch (requestCode) {
            case 2017:
                if (resultCode == Activity.RESULT_OK) {
                    Bundle data = intent.getExtras();
                    Context context = getApplicationContext();
                    CharSequence text = data.toString();
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();


                }
                break;

            // process other request codes
        }
    }
}