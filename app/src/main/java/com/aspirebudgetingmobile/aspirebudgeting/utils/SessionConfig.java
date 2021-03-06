package com.aspirebudgetingmobile.aspirebudgeting.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SessionConfig {

    private Context context;
    private SharedPreferences sharedPreferences;
    private static final String initSharedPref = "com.aspirebudgetingmobile.aspirebudgeting_init";
    private static final String SharedPref_loginStatus = "com.aspirebudgetingmobile.aspirebudgeting_loginStatus";
    private static final String SharedPref_email = "com.aspirebudgetingmobile.aspirebudgeting_email";
    private static final String SharedPref_name = "com.aspirebudgetingmobile.aspirebudgeting_name";
    private static final String SharedPref_profile = "com.aspirebudgetingmobile.aspirebudgeting_profile";
    private static final String SharedPref_sheetId = "com.aspirebudgetingmobile.aspirebudgeting_sheetId";
    private static final String SharedPref_widget_categories = "com.aspirebudgetingmobile.aspirebudgeting_widget_categories";
    private static final String SharedPref_sheetVersion = "com.aspirebudgetingmobile.aspirebudgeting_sheetVersion";

    public SessionConfig(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(initSharedPref, Context.MODE_PRIVATE);
    }

    public void setLoginStatus(boolean status) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(SharedPref_loginStatus, status);
        editor.apply();
    }

    public boolean getLoginStatus() {
        return sharedPreferences.getBoolean(SharedPref_loginStatus, false);
    }

    public void setEmail(String email) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SharedPref_email, email);
        editor.apply();
    }

    public String getEmail() {
        return sharedPreferences.getString(SharedPref_email, "none");
    }

    public void setName(String name) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SharedPref_name, name);
        editor.apply();
    }

    public String getName() {
        return sharedPreferences.getString(SharedPref_name, "none");
    }

    public void setProfilePic(String profilePic) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SharedPref_profile, profilePic);
        editor.apply();
    }

    public String getProfilePic() {
        return sharedPreferences.getString(SharedPref_profile, "none");
    }

    public void setSheetId(String SheetId) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SharedPref_sheetId, SheetId);
        editor.apply();
    }

    public String getSheetId() {
        return sharedPreferences.getString(SharedPref_sheetId, "none");
    }

    public void setWidgetCategoryList(String appWidgetId, List<String> categories){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(categories);
        editor.putString(SharedPref_widget_categories+appWidgetId, json);
        editor.apply();
    }
    public List<String> getWidgetCategoryList(String appWidgetId){
        Gson gson = new Gson();
        String json = sharedPreferences.getString(SharedPref_widget_categories+ appWidgetId, null);
        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();
        return gson.fromJson(json, type);
    }
    public void removeWidgetCategoryList(String appWidgetId){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(SharedPref_widget_categories+ appWidgetId);
    }

    public void setSheetVersion(String version) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SharedPref_sheetVersion, version);
        editor.apply();
    }

    public String getSheetVersion() {
        return sharedPreferences.getString(SharedPref_sheetVersion, "NA");
    }

}
