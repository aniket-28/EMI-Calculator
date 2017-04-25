package aniketpalve.emi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText amt,time,si;
    TextView emi;
    float a,p,r,n,m,rate;
    float b,pow,e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amt = (EditText)findViewById(R.id.amt);
        time =(EditText)findViewById(R.id.time);
        si=(EditText)findViewById(R.id.si);
        emi=(TextView)findViewById(R.id.emi);
        Button btn=(Button)findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    p= Float.parseFloat(amt.getText().toString()) ;
                    r= Float.parseFloat(si.getText().toString()) ;
                    n= Float.parseFloat(time.getText().toString()) ;

                    //E = P×r×(1 + r)^n/((1 + r)^n - 1)
                    m=n*12;
                    rate=r/12/100;
                    pow = (float) Math.pow((1+rate),m);
                    a=p*rate*pow;
                    b=pow-1;
                    e=a/b;
                    emi.setText(String.format("%.2f",e));
                }
                catch (Exception e){
                    System.out.print(e);
                }

            }
        });



    }
}
