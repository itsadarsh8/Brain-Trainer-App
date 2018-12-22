package com.example.moon.test;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;


import java.util.Random;


public class MainActivity extends AppCompatActivity {


    TextView number;
    TextView equation;
    int option1, option2, option3, option4;
    int ans1, ans2, ans3, ans4, sum;
    int[] ar;
    int[] ar2;
    TextView textView;
    Button b1,b2,b3,b4;
    Button start;
int flag1=0;
Boolean timeIsRemaining=true;
    Boolean gameIsActive=false;
int winCounter=0;

int lossCounter=0;
TextView score;
Button playAgain;
public  void playAgainButton(View view){
    playAgain.setAlpha(0f);
    timeIsRemaining=true;
    gameIsActive=false;
    start.setText("START");
    flag1=0;
    number.setText("30s");
    equation.setText("Question");
    b1.setText("Option 1");
    b2.setText("Option 2");
    b3.setText("Option 3");
    b4.setText("Option 4");
    score.setText("Right=0"+" Wrong=0");
    textView.setText("");
    winCounter=0;
    lossCounter=0;


}


    public void buttonClick (View view) {
        if (gameIsActive) {
gameIsActive=false;
            int ids = view.getId();

            String outId = view.getResources().getResourceEntryName(ids);


            char ch = outId.charAt(1);
            int pos = ch - 49;

            Log.i("string outid", Integer.toString(pos));

            if (ar2[pos] == sum) {
                Log.i("string outid", "RIGHT");

                textView.setText("Right");
                winCounter=winCounter+1;
            }
            else {
                lossCounter = lossCounter + 1;
                textView.setText("Wrong");
            }
Log.i("info","Right="+Integer.toString(winCounter)+"  Wrong="+Integer.toString(lossCounter));
            String win=Integer.toString(winCounter);
            String loss=Integer.toString(lossCounter);
             score.setText("  Right="+win+" Wrong="+loss);

        }


    }
    public void controlTimer(View view) {
        if (timeIsRemaining==true && gameIsActive==false) {
            gameIsActive=true;
            if (flag1 == 0) {
                flag1 = 1;
                new CountDownTimer(30000, 1000) {


                    @Override
                    public void onTick(long millisUntilFinished) {
                        number.setText(" "+Integer.toString((int) millisUntilFinished / 1000) + "s");

                    }

                    @Override
                    public void onFinish() {
                        Log.i("finished", "Over");

                        timeIsRemaining = false;
                        playAgain.setAlpha(1);
                        gameIsActive=false;


                    }
                }.start();
            }

            textView.setText("");
            start.setText("Next");
            Log.i("info", "Button Clicked");
            int i = new Random().nextInt(50) + 20;
            int j = new Random().nextInt(50) + 20;
            sum = i + j;
            equation.setText("      "+Integer.toString(i) + "+" + Integer.toString(j));
            option1 = 0;
            option2 = 0;
            option3 = 0;
            option4 = 0;
            int randomPosition = new Random().nextInt(4) + 1;
            option1 = randomPosition;
            while (randomPosition == option1) {
                randomPosition = new Random().nextInt(4) + 1;
                option2 = randomPosition;
            }
            while (randomPosition == option1 || randomPosition == option2) {
                randomPosition = new Random().nextInt(4) + 1;
                option3 = randomPosition;
            }
            while (randomPosition == option1 || randomPosition == option2 || randomPosition == option3) {
                randomPosition = new Random().nextInt(4) + 1;
                option4 = randomPosition;
            }

            ar = new int[]{option1, option2, option3, option4};
            if (ar[0] == 1)
                ans1 = sum;
            else
                ans1 = new Random().nextInt(sum + 10) + sum - 10;
            if (ar[1] == 1)
                ans2 = sum;
            else
                ans2 = new Random().nextInt(sum + 10) + sum - 10;
            if (ar[2] == 1)
                ans3 = sum;
            else
                ans3 = new Random().nextInt(sum + 10) + sum - 10;
            if (ar[3] == 1)
                ans4 = sum;
            else
                ans4 = new Random().nextInt(sum + 10) + sum - 10;

            b1.setText(Integer.toString(ans1));
            b2.setText(Integer.toString(ans2));
            b3.setText(Integer.toString(ans3));
            b4.setText(Integer.toString(ans4));
            ar2 = new int[]{ans1, ans2, ans3, ans4};

        }
    }


    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        number = (TextView) findViewById(R.id.number);
        equation = (TextView) findViewById(R.id.equation);
        textView = (TextView) findViewById(R.id.rightAnswer);
        start=(Button)findViewById(R.id.start);
        score=(TextView)findViewById(R.id.score);
        playAgain=(Button)findViewById(R.id.playAgain);

        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);

        b1.setText("Option 1");
        b2.setText("Option 2");
        b3.setText("Option 3");
        b4.setText("Option 4");
        equation.setText("    Question");
        score.setText("  Right=0"+" Wrong=0");




    }

}

