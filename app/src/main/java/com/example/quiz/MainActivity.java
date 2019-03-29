package com.example.quiz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   private   Button btrue,bfalse;
   final int progincreament=20;
    private int idex;
   private TextView questiontext;
   private TextView tscore;
   ProgressBar mpro;
   int score;
   private int question;

    private truefalse[] mquestion=new truefalse[]{
             new truefalse(R.string.question1,true),
             new truefalse(R.string.question2,true),
            new truefalse(R.string.question3,false),
            new truefalse(R.string.question4,false),
            new truefalse(R.string.question5,false),
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btrue=(Button) findViewById(R.id.True);
        bfalse=(Button)findViewById(R.id.False);
        tscore=(TextView) findViewById(R.id.score);
        questiontext=(TextView) findViewById(R.id.question_textview);
         question=mquestion[idex].getMquestion();
         questiontext.setText(question);
         mpro=(ProgressBar) findViewById(R.id.progress_horizontal);




        btrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkanswer(true);
                updatequestion();
            }
        });
        bfalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkanswer(false);
              updatequestion();

            }
        });
    }
    private  void updatequestion(){
      idex=(idex+1)%mquestion.length;

      if (idex==0){
          AlertDialog.Builder alert=new AlertDialog.Builder(this);
          alert.setTitle("the question over");
          alert.setCancelable(false);
          alert.setMessage("you score "+score+"  points");
          alert.setPositiveButton("close aplication", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                  finish();
              }
          });
             alert.show();
      }
      question=mquestion[idex].getMquestion();
        questiontext.setText(question);
        mpro.incrementProgressBy(progincreament);
        tscore.setText("score = "+score+"/"+mquestion.length);
    }
    private void checkanswer (boolean userselection){
        boolean correctanswer=mquestion[idex].isManswer();
        if (userselection==correctanswer){
            Toast.makeText(getApplicationContext(),R.string.correct,Toast.LENGTH_SHORT).show();
            score=score+1;

        }
        else{
            Toast.makeText(getApplicationContext(),R.string.wrong,Toast.LENGTH_SHORT).show();

        }

    }
}
