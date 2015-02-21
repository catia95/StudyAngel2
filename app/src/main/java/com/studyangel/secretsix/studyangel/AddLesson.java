package com.studyangel.secretsix.studyangel;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class AddLesson extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_lesson_activity);

        final Button changeColour = (Button) findViewById(R.id.colourButton);
        int chosenColour = Color.argb(255, 36, 39, 255);

        // loop to select the colour from blue, red, orange, yellow, green and pink
        for (int i = 0; i < 6; i++) {
            if (i == 0) {
                chosenColour = Color.argb(255, 255, 0, 0);
            } else if (i == 2) {
                chosenColour = Color.argb(255, 0, 255, 0);
            } else if (i == 3) {
                chosenColour = Color.argb(255, 255, 128, 0);
            } else if (i == 4) {
                chosenColour = Color.argb(255, 255, 255, 0);
            } else if (i == 5) {
                chosenColour = Color.argb(255, 255, 0, 127);
            }

            final int finalChosenColour = chosenColour;
            changeColour.setOnClickListener(
                    new Button.OnClickListener() {
                        public void onClick(View v) {
                            changeColour.setBackgroundColor(finalChosenColour);
                        }
                    }
            );
        }

        //Alternative?
//      changeColour.setOnClickListener(new Button.OnClickListener() {
//          public void onClick(View v) {
//              int chosenColour = R.color.blue;
//              int numOfClicks = 0;
//              switch (numOfClicks) {
//                    case 0:
//
//                        break;
//                    case 1:
//
//                        break;
//                    case 2:
//
//                        break;
//                    case 3:
//
//                        break;
//                    case 4:
//
//                        break;
//                    case 5:
//
//                        break;
//              } changeColour.setBackgroundColor(chosenColour);
//            }
//        });

        String module_Code;
        String module_Name;
        final String day;
        String startTime;
        String endTime;
        String description;
        String location;

        final EditText inputMCode = (EditText) findViewById(R.id.moduleCode);
        final EditText inputMName = (EditText) findViewById(R.id.moduleName);
        final EditText start_time = (EditText) findViewById(R.id.StartText);
        final EditText end_time = (EditText) findViewById(R.id.EndText);


        final Editable string1 = inputMCode.getText();
        Editable string2 = inputMName.getText();

        Button monday = (Button) findViewById(R.id.mButton);

        monday.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView daySelected;
                        daySelected = (TextView) findViewById(R.id.selectedDay);
                        daySelected.setText("Monday");
                    }
                }
        );
        Button tuesday = (Button) findViewById(R.id.tButton);

        tuesday.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView daySelected;
                        daySelected = (TextView) findViewById(R.id.selectedDay);
                        daySelected.setText("Tuesday");
                    }
                }
        );
        Button wednesday = (Button) findViewById(R.id.wButton);

        wednesday.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView daySelected;
                        daySelected = (TextView) findViewById(R.id.selectedDay);
                        daySelected.setText("Wednesday");
                    }
                }
        );
        Button thursday = (Button) findViewById(R.id.thButton);

        thursday.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView daySelected;
                        daySelected = (TextView) findViewById(R.id.selectedDay);
                        daySelected.setText("Thursday");
                    }
                }
        );
        Button friday = (Button) findViewById(R.id.fButton);

        friday.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView daySelected;
                        daySelected = (TextView) findViewById(R.id.selectedDay);
                        daySelected.setText("Friday");
                    }
                }
        );
    }

//    public void savedump() {
//        try
//        {
//            // Creates a trace file in the primary external storage space of the
//            // current application.
//            // If the file does not exists, it is created.
//            File traceFile = new File(((Context)this).getFilesDir(), "TraceFile.txt");
//            if (!traceFile.exists())
//                traceFile.createNewFile();
//                System.out.print("tester");
//            // Adds a line to the trace file
//            BufferedWriter writer = new BufferedWriter(new FileWriter(traceFile, true /*append*/));
//            writer.write("This is a test trace file.");
//            writer.close();
//            // Refresh the data so it can seen when the device is plugged in a
//            // computer. You may have to unplug and replug the device to see the
//            // latest changes. This is not necessary if the user should not modify
//            // the files.
//            MediaScannerConnection.scanFile((Context) (this),
//                    new String[]{traceFile.toString()},
//                    null,
//                    null);
//
//        }
//        catch (IOException e)
//        {
//            Log.e("com.cindypotvin.FileTest", "Unable to write to the TraceFile.txt file.");
//        }
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_lesson_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (id) {
            case R.id.action_save:
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
                //TODO: directs back to the previous page after saving
                //saveDump maybe?
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
