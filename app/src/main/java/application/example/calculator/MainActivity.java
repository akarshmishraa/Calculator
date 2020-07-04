package application.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    String s="";
    String m="";
    int n1=0,n2=0,c=0, again=1, oneMore=1;
    TextView textView;
    public void number(View view)
    {
        Button number = (Button) view;
        if(oneMore==1) {

            m += number.getText().toString();
            if (again == 1) {
                n1 = Integer.parseInt(m);
                s = m;
                textView.setText(s + " ");
            } else {
                n2 = Integer.parseInt(m);
                textView.setText(s + " " + m);
            }
        }
        else
        {
            m += number.getText().toString();
            n1 = Integer.parseInt(m);
            s = m;
            textView.setText(s + " ");
            oneMore=1;
            again=1;
        }

    }
    public void operation(View view)
    {
        Button number=(Button) view;

        s=s+" "+number.getText().toString();
        textView.setText(s+" ");
        if((number.getTag().toString()).equalsIgnoreCase("plus"))
        {
            c=1;
        }
        else if((number.getTag().toString()).equalsIgnoreCase("minus"))
        c=2;
        else if((number.getTag().toString()).equalsIgnoreCase("multiplication"))
            c=3;
        else if((number.getTag().toString()).equalsIgnoreCase("division"))
            c=4;
        again=2;
        m="";
        oneMore=1;
    }
    public void answer(View view)
    {

        Button number=(Button)findViewById((R.id.equal));


        int n=0;
        if(c!=0)
        {
            if(c==1)
                n=n1+n2;
            if(c==2)
                n=n1-n2;
            if(c==3)
                n=n1*n2;
            if(c==4)
                n=n1/n2;
            s=Integer.toString(n);
            c=0;
            n1=n;
            oneMore=2;
        }
        textView.setText(s);
        m="";
    }
    public void clear(View view)
    {
        if(again==2)
        {
            oneMore=1;
            again=1;
            s=" ";
            textView.setText(s);
        }
        else
        {
            m=s.substring(0,s.length()-1);
            s=m;
            n1=Integer.parseInt(s);
            textView.setText(s);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView) findViewById(R.id.textView);
    }
}
