
/**
 * Created by Catia + Jess on 17/02/15.
 *
 * Class responsible for dealing with the database
 */

package com.studyangel.secretsix.studyangel;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;

public class MyDBHandler extends SQLiteOpenHelper {

    // Update this figure if we make changes to the table
    private static final int DATABASE_VERSION = 1;

    // Database name
    private static final String DATABASE_NAME = "usersdata.db";

    // Table name (can have multiple in one database)
    private static final String TABLE_MODULES = "modules"; //
    private static final String TABLE_LESSONS = "lessons"; //
    private static final String TABLE_TASKS = "tasks"; //
    private static final String TABLE_COURSEWORK = "coursework";//
    private static final String TABLE_CHECKLIST = "checklist";

    // Every column heading for module table
    private static final String COLUMN_MODULEID = "_moduleid";
    private static final String COLUMN_MODULENAME = "modulename";
    private static final String COLUMN_MODULECOLOUR = "modulecolour";
    private static final String COLUMN_MODULECODE = "modulecode";

    // Every column heading for lesson table
    private static final String COLUMN_LESSONID = "_lessonid";
    private static final String COLUMN_LESSONDESCRIPTION = "lessondescription";
    private static final String COLUMN_LESSONLOCATION = "lessonlocation";
    private static final String COLUMN_LESSONSTARTTIME = "lessonstarttime";
    private static final String COLUMN_LESSONENDTIME = "lessonendtime";
    private static final String COLUMN_LESSONDAY = "lessonday";

    // Every column heading for tasks table
    private static final String COLUMN_TASKID = "_taskid";
    private static final String COLUMN_TASKDESCRIPTION = "taskdescription";
    private static final String COLUMN_TASKDEADLINE = "taskdeadline";
    private static final String COLUMN_TASKPRIORITY = "taskpriority";

    // Every column heading for coursework table
    private static final String COLUMN_COURSEWORKID = "_courseworkid";
    private static final String COLUMN_COURSEWORKDESCRIPTION = "courseworkdescription";
    private static final String COLUMN_COURSEWORKDAYSLEFT = "courseworkdaysleft";
    private static final String COLUMN_COURSEWORKPRIORITY = "courseworkpriority";
    private static final String COLUMN_COURSEWORKACTUALDEADLINE = "courseworkactualdeadline";
    private static final String COLUMN_COURSEWORKPERSONALDEADLINE = "courseworkpersonaldeadline";

    // Every column heading for checklist table
    private static final String COLUMN_CHECKLISTID = "_checklistid";
    private static final String COLUMN_CHECKLISTDESCRIPTION = "checklistdescription";
    private static final String COLUMN_CHECKLISTWEIGHT = "checklistweight";


    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    // Here we create the tables for the first time
    // Order of creating MATTERS! Less dependent first

    // TODO ADD IN FOREIGN KEYS TO TABLES
    // TODO STRING NOT TEXT??
    // TODO Basics of SQL website
    @Override
    public void onCreate(SQLiteDatabase db) {

        // Creating modules table first query
        String queryModules = "CREATE TABLE " + TABLE_MODULES + "(" +
                COLUMN_MODULEID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_MODULENAME + " TEXT, " +
                COLUMN_MODULECOLOUR + " TEXT, " +
                COLUMN_MODULECODE + " TEXT " +
                ");";

        // Creating lessons table query
        String queryLessons = "CREATE TABLE " + TABLE_LESSONS + "(" +
                COLUMN_LESSONID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_LESSONDESCRIPTION + " TEXT, " +
                COLUMN_LESSONLOCATION + " TEXT, " +
                COLUMN_LESSONSTARTTIME + " TEXT, " +
                COLUMN_LESSONENDTIME + " TEXT, " +
                COLUMN_LESSONDAY + " TEXT, " +
                COLUMN_MODULEID + " INTEGER REFERENCES " +
                TABLE_MODULES + "(" +
                COLUMN_MODULEID + ")" +
                ");";

        // Creating coursework table query
        String queryCoursework = "CREATE TABLE " + TABLE_COURSEWORK + "(" +
                COLUMN_COURSEWORKID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_COURSEWORKDESCRIPTION + " TEXT, " +
                COLUMN_COURSEWORKDAYSLEFT + " TEXT, " +
                COLUMN_COURSEWORKPRIORITY + " TEXT, " +
                COLUMN_COURSEWORKACTUALDEADLINE + " TEXT, " +
                COLUMN_COURSEWORKPERSONALDEADLINE + " TEXT, " +
                COLUMN_MODULEID + " INTEGER REFERENCES " +
                TABLE_MODULES + "(" +
                COLUMN_MODULEID + ")" +
                ");";

        // Creating tasks table query
        String queryTasks = "CREATE TABLE " + TABLE_TASKS + "(" +
                COLUMN_TASKID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TASKDESCRIPTION + " TEXT, " +
                COLUMN_TASKDEADLINE + " TEXT, " +
                COLUMN_TASKPRIORITY + " TEXT " +
                ");";

        // Creating checklist table query
        String queryChecklist = "CREATE TABLE " + TABLE_CHECKLIST + "(" +
                COLUMN_CHECKLISTID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_CHECKLISTDESCRIPTION + " TEXT, " +
                COLUMN_CHECKLISTWEIGHT + " TEXT, " +
                COLUMN_COURSEWORKID + " INTEGER REFERENCES " +
                TABLE_COURSEWORK + "(" +
                COLUMN_COURSEWORKID + "), " +
                COLUMN_TASKID + " INTEGER REFERENCES " +
                TABLE_TASKS + "(" +
                COLUMN_TASKID + ")" +
                ");";

        // Creating tables
        db.execSQL(queryModules);
        db.execSQL(queryLessons);
        db.execSQL(queryCoursework);
        db.execSQL(queryTasks);
        db.execSQL(queryChecklist);

    }

    // Clears all data and recreates tables
    // IMPORTANT: Drop tables in reverse order of creating
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Deleting all tables
        db.execSQL("DROP_TABLE IF EXISTS " + TABLE_COURSEWORK + ";");
        db.execSQL("DROP_TABLE IF EXISTS " + TABLE_TASKS + ";");
        db.execSQL("DROP_TABLE IF EXISTS " + TABLE_COURSEWORK + ";");
        db.execSQL("DROP_TABLE IF EXISTS " + TABLE_LESSONS + ";");
        db.execSQL("DROP_TABLE IF EXISTS " + TABLE_MODULES + ";");

        // Recreate tables
        onCreate(db);
    }


    //Pass in Module Objects etc - adding new row to database
    public void addModule(Modules module) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_MODULENAME, module.get_modulename());
        values.put(COLUMN_MODULECOLOUR, module.get_modulecolour());
        values.put(COLUMN_MODULECODE, module.get_modulecode());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_MODULES, null, values);
        db.close();
    }


    // TODO CAN INSERT HERE AN OPTION TO DELETE MODULE :)


    //Printing out database as String
    public String databaseToString() {
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();

        String[] modulesColumns = new String[]{
                //"SELECT * FROM " + TABLE_MODULES + " WHERE 1"
                COLUMN_MODULEID,
                COLUMN_MODULENAME,
                COLUMN_MODULECOLOUR,
                COLUMN_MODULECODE
        };
        //select every column from every row

        //Cursor point to a location in your results
        Cursor c = db.query(TABLE_MODULES, modulesColumns, null, null, null, null, null);

        //move to first row in results
        c.moveToFirst();

        // if not after the last row then check whether moduleid is not null
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("_moduleid")) != null) {
                dbString += c.getString(c.getColumnIndex("modulename"));
                dbString += " - ";
                dbString += c.getString(c.getColumnIndex("modulecode"));
                dbString += " - ";
                dbString += c.getString(c.getColumnIndex("modulecolour"));
                dbString += "\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }
}

