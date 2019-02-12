package com.example.thebryan.combarbershapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Menu.OnFragmentInteractionListener,Notification.OnFragmentInteractionListener, Profile.OnFragmentInteractionListener, Login.OnFragmentInteractionListener,
SendToLogin.OnFragmentInteractionListener {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_profile:
                    changeFragmen("Profile");
                    return true;
                case R.id.navigation_dashboard:
                    changeFragmen("Dashboard");

                    return true;
                case R.id.navigation_notifications:
                    changeFragmen("Notifications");


                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        changeFragmen("Profile");

    }
private void changeFragmen(String fragment_name){

    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    Fragment newFragment;
    switch (fragment_name){
            case "Profile" :
                if (Aplicacion.SesionIniciada){
                    newFragment = new Profile();
                }else{
                    newFragment = new SendToLogin();
                }


                transaction.replace(R.id.container, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            case "Dashboard" :
                if (Aplicacion.SesionIniciada){
                newFragment = new Menu();}
                else {
                    newFragment = new SendToLogin();

                }
                transaction.replace(R.id.container, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            case "Notifications" :
                if (Aplicacion.SesionIniciada) {
                    newFragment = new Notification();
                }else
                {
                    newFragment = new SendToLogin();

                }
                transaction.replace(R.id.container, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();

                break;

        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {



    }
}
