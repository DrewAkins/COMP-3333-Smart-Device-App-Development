package com.example.maxdr_000.assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Register touch listener and callback function
        RelativeLayout myLayout = (RelativeLayout) findViewById(R.id.myLayout);
        myLayout.setOnTouchListener(
                new RelativeLayout.OnTouchListener() {
                    public boolean onTouch(View v, MotionEvent m) {
                        handleTouch(m);
                        return true;
                    }
                }
        );
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

    static int count = 0;

    public void buttonClick(View view) {//button callback function
// Do something in response to button click
        TextView myTextView =
                (TextView) findViewById(R.id.button);
        Button  myTextView2 =
                (Button) findViewById(R.id.button2);
        TextView Counter =
                (TextView) findViewById(R.id.COUNTER);
        count = count + 1;

        if (count % 2 == 0) {
            myTextView.setText("Button clicked");
            Counter.setText("Counter = " + count);
        }
        else Counter.setText("Counter =" + count);

    }

    public void Restart(View view) {//button callback function
// Do something in response to button click

        TextView Counter =
                (TextView) findViewById(R.id.COUNTER);
        count = 0;

        Counter.setText("Counter =" +  count);

    }

    void handleTouch(MotionEvent m) {
        TextView myTextView1 = (TextView) findViewById(R.id.editText1);
        int pointerCount = m.getPointerCount();//the number of active pointers
        for (int i = 0; i < pointerCount; i++) {
            int x = (int) m.getX(i);
            int y = (int) m.getY(i);
            int id = m.getPointerId(i);
            int action = m.getActionMasked(); //action type
            int actionIndex = m.getActionIndex();
            String actionString;
            switch (action) {
                case MotionEvent.ACTION_DOWN:
                    actionString = "Down";
                    break;
                case MotionEvent.ACTION_UP:
                    actionString = "Up";
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    actionString = "PNTR Down";
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    actionString = "PNTR Up";
                    break;
                case MotionEvent.ACTION_MOVE:
                    actionString = "Move";
                    break;
                default:
                    actionString = "";
            }//end of switch
            String touchStatus = "Action: " + actionString +
                    " Index: " + actionIndex +
                    " ID: " + id +
                    " X: " + x +
                    " Y: " + y;
            if (id == 0)
                myTextView1.setText(touchStatus);

        }//end of for
    }
}