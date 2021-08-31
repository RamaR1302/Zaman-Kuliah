package com.example.kucng;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class quis extends AppCompatActivity {
    private TextView countLabel;
    private ImageView questionImage;
    private Button answerBtn1;
    private Button answerBtn2;
    private Button answerBtn3;
    private Button answerBtn4;

    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int quizCount = 1;


    MediaPlayer mediaPlayer;
    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

    String quizData[][] = {
            // {"Image Name", "Right Answer", "Choice1", "Choice2", "Choice3"}
            {"mainecoon", "maincoon", "persia", "anggora", "harimau"},
            {"persia", "persia", "anggora", "orangutan", "singa"},
            {"pallas", "pallas", "bengal", "russian blue", "caracal"},
            {"kodkod", "kodkod", "british", "sphynx", "sandcat"},
            {"angora", "angora", "abyssinian", "manx", "norwegian"},
            {"caracal", "caracal", "lynx", "serval", "egyptian mau"},
            {"jaguarundi", "jaguarundi", "ocicat", "asian leopard", "flat headed"},
            {"curl", "curl", "somali", "anggora", "persia"},
            {"american", "american", "curl", "british", "norwegian"},
            {"bengal", "bengal", "egyptian mau", "american", "margay"},
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quis);

        countLabel = findViewById(R.id.countLabel);
        questionImage = findViewById(R.id.questionImage);
        answerBtn1 = findViewById(R.id.answerBtn1);
        answerBtn2 = findViewById(R.id.answerBtn2);
        answerBtn3 = findViewById(R.id.answerBtn3);
        answerBtn4 = findViewById(R.id.answerBtn4);

        // Create quizArray from quizData.
        for (int i = 0; i < quizData.length; i++) {
            // Prepare array.
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData[i][0]); // Image Name
            tmpArray.add(quizData[i][1]); // Right Answer
            tmpArray.add(quizData[i][2]); // Choice1
            tmpArray.add(quizData[i][3]); // Choice2
            tmpArray.add(quizData[i][4]); // Choice3

            // Add tmpArray to quizArray.
            quizArray.add(tmpArray);
        }

        showNextQuiz();
    }

    public void showNextQuiz() {

        // Update quizCountLabel.
        countLabel.setText("Soal " + quizCount);

        // Generate random number between 0 and 4 (quizArray's size -1)
        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());

        // Pick one quiz set.
        ArrayList<String> quiz = quizArray.get(randomNum);

        // Set Image and Right Answer.
        // Array format: {"Image Name", "Right Answer", "Choice1", "Choice2", "Choice3"}
        questionImage.setImageResource(
                getResources().getIdentifier(quiz.get(0), "drawable", getPackageName()));
        rightAnswer = quiz.get(1);

        // Remove "Image Name" from quiz and shuffle choices.
        quiz.remove(0);
        Collections.shuffle(quiz);

        // Set choices.
        answerBtn1.setText(quiz.get(0));
        answerBtn2.setText(quiz.get(1));
        answerBtn3.setText(quiz.get(2));
        answerBtn4.setText(quiz.get(3));

        // Remove this quiz from quizArray.
        quizArray.remove(randomNum);

    }

    public void checkAnswer(View view) {

        // Get pushed button.
        Button answerBtn = findViewById(view.getId());
        String btnText = answerBtn.getText().toString();

        String alertTitle;

        if (btnText.equals(rightAnswer)) {
            // Correct!!
            alertTitle = "Benar";
            rightAnswerCount = rightAnswerCount+10;
            jawabanbener();

        } else {
            // Wrong
            alertTitle = "Salah....";
            jawabansalah();
        }

        // Create Dialog.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("jawaban yang benar : " + rightAnswer);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (quizArray.size() < 1) {
                    // quizArray is empty.
                    showResult();

                } else {
                    quizCount++;
                    showNextQuiz();
                }
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    public void showResult() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Skor");
        builder.setMessage(rightAnswerCount + " Poin");
        builder.setPositiveButton("coba lagi", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                recreate();
            }
        });
        builder.setNegativeButton("keluar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.show();
    }

    public void jawabansalah(){

        mediaPlayer = MediaPlayer.create(this, R.raw.salah);
        mediaPlayer.setVolume(1,1);
        //Memulai audio
        mediaPlayer.start();


    }
    public void jawabanbener(){
        mediaPlayer = MediaPlayer.create(this, R.raw.jawabanbenar);
        mediaPlayer.setVolume(1,1);
        //Memulai audio
        mediaPlayer.start();

    }
}
