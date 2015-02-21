package com.studyangel.secretsix.studyangel;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.app.ActionBarActivity;
import android.widget.EditText;
import android.widget.TextView;


/**
 * Created by Catia on 17/02/15.
 * <p/>
 * This and the linked xml file is used to test database
 */

//TODO CHANGE IN ANDROID MANIFEST TESTADDMODULE TO ADDLESSON etc
public class TESTAddModule extends ActionBarActivity {

    EditText moduleName;
    EditText moduleCode;
    EditText moduleColour;
    TextView displayModuleInfo;
    MyDBHandler dbHandler;

    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_add_module_layout);

        moduleCode = (EditText) findViewById(R.id.moduleCode);
        moduleName = (EditText) findViewById(R.id.moduleName);
        moduleColour = (EditText) findViewById(R.id.moduleColour);
        displayModuleInfo = (TextView) findViewById(R.id.displayModuleInfo);
        dbHandler = new MyDBHandler(this, null, null, 1);
        //printDatabase();
    }

    // add module to database
    public void addButtonClicked(View view) {
        Modules module = new Modules(moduleName.getText().toString(),
                moduleColour.getText().toString(), moduleCode.getText().toString());
        dbHandler.addModule(module);
        printDatabase();

    }

    //getting the string forms in mydbhandler and printing it out
    private void printDatabase() {
        String dbString = dbHandler.databaseToString();
        displayModuleInfo.setText(dbString);
        moduleCode.setText("");
        moduleColour.setText("");
        moduleName.setText("");
    }
}
