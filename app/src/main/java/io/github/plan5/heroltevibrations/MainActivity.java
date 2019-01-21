package io.github.plan5.heroltevibrations;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void writeToFile(View view) { // https://stackoverflow.com/questions/14376807/how-to-read-write-string-from-a-file-in-android#14377185
        final File vibrator_file = new File("/sys/devices/virtual/timed_output/vibrator/", "intensity");
        Process p;

        try {
            // Preform su to get root privledges
            p = Runtime.getRuntime().exec("su");

            //get vibration intensity from seekBar
            SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
            String vibration_intensity = String.valueOf(seekBar.getProgress());

            // Attempt to write a file to a root-only
            DataOutputStream os = new DataOutputStream(p.getOutputStream());
            os.writeBytes("echo "+vibration_intensity+" >"+vibrator_file.toString()+"\n");

            // Close the terminal
            os.writeBytes("exit\n");
            os.flush();

            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(500); // 5000 miliseconds = 5 seconds

            try {
                p.waitFor();
                if (p.exitValue() != 255) {
                    // TODO Code to run on success
                    //toastMessage("root");
                }
                else {
                    // TODO Code to run on unsuccessful
                    //toastMessage("not root");
                }
            } catch (InterruptedException e) {
                // TODO Code to run in interrupted exception
                //toastMessage("not root");
            }
        } catch (IOException e) {
            // TODO Code to run in input/output exception
            //toastMessage("not root");
        }



    }


}

