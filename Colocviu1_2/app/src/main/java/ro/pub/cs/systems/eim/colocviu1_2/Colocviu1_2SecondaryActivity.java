package ro.pub.cs.systems.eim.colocviu1_2;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Colocviu1_2SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intentFromParent = getIntent();
        Bundle data = intentFromParent.getExtras();

        if (data != null) {
            int res = compute(data.toString());
            Intent intentToParent = new Intent();
            intentToParent.putExtra("ro.pub.cs.systems.eim.lab04.anotherKey", res);
            setResult(RESULT_OK, intentToParent);
            finish();
        }
    }
    public int compute(String terms) {
        String[] tokens = terms.split(" +");
        int res = 0;
        for (String s : tokens) {
            res += Integer.valueOf(s);
        }
        return res;
    }
}
