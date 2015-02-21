package com.studyangel.secretsix.studyangel;

/**
 * Created by Catia on 17/02/15.
 * <p/>
 * This class is for creating module objects
 */
public class Modules {

    private int _moduleid;
    private String _modulename;
    private String _modulecolour;
    private String _modulecode;

    public Modules() {
    }

    // Passes through the information retrieved from the app
    public Modules(String modulename, String modulecolour, String modulecode) {
        this._modulename = modulename;
        this._modulecolour = modulecolour;
        this._modulecode = modulecode;
    }

    // Sets the values
    public void set_moduleid(int _moduleid) {
        this._moduleid = _moduleid;
    }

    public void set_modulename(String _modulename) {
        this._modulename = _modulename;
    }

    public void set_modulecolour(String _modulecolour) {
        this._modulecolour = _modulecolour;
    }

    public void set_modulecode(String _modulecode) {
        this._modulecode = _modulecode;
    }

    // Gets the values
    public int get_moduleid() {
        return _moduleid;
    }

    public String get_modulecode() {
        return _modulecode;
    }

    public String get_modulecolour() {
        return _modulecolour;
    }

    public String get_modulename() {
        return _modulename;
    }
}
