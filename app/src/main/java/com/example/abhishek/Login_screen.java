package com.example.abhishek;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abhishek.activities.MainActivity;
import com.example.abhishek.spenden.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;

public class Login_screen extends ActionBarActivity {
    SharedPreferences NAME;
    SharedPreferences flag;
    SharedPreferences logout;
    String userid;
    String flag1;
    Profile profile;


    CallbackManager callbackManager;
    /* Request code used to invoke sign in user interactions. */
    private static final int RC_SIGN_IN = 0;

    /* Client used to interact with Google APIs. */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   setContentView(R.layout.activity_login_screen);
        FacebookSdk.sdkInitialize(getApplicationContext());
       setContentView(R.layout.activity_login_screen);
        callbackManager = CallbackManager.Factory.create();
        LoginButton button = (LoginButton) findViewById(R.id.login_button);
        // button.setReadPermissions(Arrays.asList("user_friends"));
        button.setReadPermissions(Arrays.asList("public_profile", "user_friends"));
        final Activity a  = this;


        // button.setText("Sign in with facebook");





//        logout = getSharedPreferences("logout", 0);
//        SharedPreferences.Editor editoro;
//        editoro = logout.edit();
//        editoro.commit();
//        Toast.makeText(a, "flag_value" + logout.getInt("logout", 0), Toast.LENGTH_LONG).show();
//
//
//        if(logout.getInt("logout",0)==1)
//        {
//            final SharedPreferences m2SharedPreference= getSharedPreferences("flag",0);
//            flag1=m2SharedPreference.getString("flag",null);
//            if(flag1=="fb")
//            {  Toast.makeText(a,flag1+"hifb" , Toast.LENGTH_LONG).show();
////
//                LoginManager.getInstance().logOut();
//                profile=null;
//
//
//
//
//
//            }
//            else
//            {
//
//
//                //  mGooglePlusLogoutClicked = true;  // Keep track when you click logout
//                if (mGoogleApiClient.isConnected()) {
//                    Plus.AccountApi.clearDefaultAccount(mGoogleApiClient);
//                    Toast.makeText(a,flag1+"higoo" , Toast.LENGTH_LONG).show();
//                    revokeAccess();
//                }
//
//            }
//
//        }



//        mGoogleApiClient = new GoogleApiClient.Builder(this)
//                .addConnectionCallbacks(this)
//                .addOnConnectionFailedListener(this)
//                .addApi(Plus.API)
//                .addScope(Scopes.PLUS_LOGIN)
//                .addScope(Scopes.PLUS_ME)
//                .build();

//        findViewById(R.id.sign_in_button).setOnClickListener(this);
//        SignInButton googlePlusButton=(SignInButton)findViewById(R.id.sign_in_button);
      //  setGooglePlusButtonText(googlePlusButton,"Sign in with Google+");
        button.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
//                Log.i("facebooklog", AccessToken.getCurrentAccessToken().getToken());
//               Toast.makeText(a, Profile.getCurrentProfile().getName(), Toast.LENGTH_LONG).show();
                NAME = getSharedPreferences("NAME", 0);
                SharedPreferences.Editor editor;
                editor = NAME.edit();

                flag = getSharedPreferences("flag", 0);
                SharedPreferences.Editor editor1;
                editor1 = flag.edit();
                profile = Profile.getCurrentProfile();


              //               userid = Profile.getCurrentProfile().getId();

            //       Toast.makeText(a, Profile.getCurrentProfile().getId(), Toast.LENGTH_LONG).show();
//                editor1.putString("flag","fb");
//                editor1.commit();
//                editor.putString("NAME", profile.getId());//0 signifies not logged in
//                editor.commit();

//                SharedPreferences.Editor editor1;
//                editor1 = mSharedPreference.edit();
//                editor1.putInt("key",1);//1 signifies logged in
//                editor1.commit();
//                skip1 = getSharedPreferences("skip1", 0);
//                SharedPreferences.Editor editors1;
//                editors1 = skip1.edit();
//                editors1.putInt("skip1",1);
//                editors1.commit();
//
//
//                skip2 = getSharedPreferences("skip2", 0);
//                SharedPreferences.Editor editors2;
//                editors2 = skip2.edit();
//                editors2.putInt("skip2",1);
//                editors2.commit();
//
//                logout = getSharedPreferences("logout", 0);
//                SharedPreferences.Editor editoro;
//                editoro = logout.edit();
//                editoro.putInt("logout",-1);
                Intent changeActivity = new Intent(a,MainActivity.class);
                changeActivity.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(changeActivity);

            }

            @Override
            public void onCancel() {
                Toast.makeText(a, "Cancelled" , Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(FacebookException e) {
                Toast.makeText(a, e.toString(), Toast.LENGTH_LONG).show();
            }
        });


    }

//    private void revokeAccess() {
//        Plus.AccountApi.revokeAccessAndDisconnect(mGoogleApiClient)
//                .setResultCallback(new ResultCallback<Status>() {
//                    @Override
//                    public void onResult(Status status) {
//                        mGoogleApiClient.disconnect();
//                        // mGoogleApiClient.connect();
//                        // Clear data and go to login activity
//                    }
//                });
//    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == RC_SIGN_IN) {
//            // If the error resolution was not successful we should not resolve further.
//            if (resultCode != RESULT_OK) {
//                mShouldResolve = false;
//            }
//
//            mIsResolving = false;
//            mGoogleApiClient.connect();
//        }
//        else {
            callbackManager.onActivityResult(requestCode, resultCode, data);

       // }
    }
//    protected void setGooglePlusButtonText(SignInButton signInButton, String buttonText) {
//        // Find the TextView that is inside of the SignInButton and set its text
//        for (int i = 0; i < signInButton.getChildCount(); i++) {
//            View v = signInButton.getChildAt(i);
//
//            if (v instanceof TextView) {
//                TextView tv = (TextView) v;
//                tv.setText(buttonText);
//                return;
//            }
//        }
//    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
//    @Override
//    public void onConnectionFailed(ConnectionResult connectionResult) {
//        // Could not connect to Google Play Services.  The user needs to select an account,
//        // grant permissions or resolve an error in order to sign in. Refer to the javadoc for
//        // ConnectionResult to see possible error codes.
//        // Log.d(TAG, "onConnectionFailed:" + connectionResult);
//
//        if (!mIsResolving && mShouldResolve) {
//            if (connectionResult.hasResolution()) {
//                try {
//                    connectionResult.startResolutionForResult(this, RC_SIGN_IN);
//                    mIsResolving = true;
//                } catch (IntentSender.SendIntentException e) {
//                    //           Log.e(TAG, "Could not resolve ConnectionResult.", e);
//                    mIsResolving = false;
//                    mGoogleApiClient.connect();
//                }
//            } else {
//                // Could not resolve the connection result, show the user an
//                // error dialog.
//                //    showErrorDialog(connectionResult);
//            }
//        } else {
//            // Show the signed-out UI
//            //  showSignedOutUI();
   //     }


 //   }
//    @Override
//    protected void onStart() {
//        super.onStart();
//        //  mGoogleApiClient.connect();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        if (mGoogleApiClient.isConnected()) {
//            mGoogleApiClient.disconnect();
//        }
//
//    }
//    private void onSignInClicked() {
//        // User clicked the sign-in button, so begin the sign-in process and automatically
//        // attempt to resolve any errors that occur.
//        mShouldResolve = true;
//        mGoogleApiClient.connect();
//
//        // Show a message to the user that we are signing in.
//        // mStatusTextView.setText(R.string.signing_in);
//    }
//
//    @Override
//    public void onConnected(Bundle bundle) {
//        // onConnected indicates that an account was selected on the device, that the selected
//        // account has granted any requested permissions to our app and that we were able to
//        // establish a service connection to Google Play services.
//        //Log.d(TAG, "onConnected:" + bundle);
//        mShouldResolve = false;

        // Show the signed-in UI
        //showSignedInUI();

//        if (Plus.PeopleApi.getCurrentPerson(mGoogleApiClient) ==  null) {
//            Person currentPerson = Plus.PeopleApi.getCurrentPerson(mGoogleApiClient);
//            String personName = currentPerson.getDisplayName();
//           // String personPhoto = currentPerson.getImage();
//            String personGooglePlusProfile = currentPerson.getUrl();
//            Toast.makeText(this,personGooglePlusProfile, Toast.LENGTH_LONG).show();
//        }
//        Person currentPerson = Plus.PeopleApi.getCurrentPerson(mGoogleApiClient);
//        String personGooglePlusProfile = currentPerson.getUrl();
//        Toast.makeText(this,personGooglePlusProfile, Toast.LENGTH_LONG).show();
//        Plus.PeopleApi.loadVisible(mGoogleApiClient, null).setResultCallback(this);
        /* This Line is the key */
//        Plus.PeopleApi.loadVisible(mGoogleApiClient, null).setResultCallback(this);
//
//        // After that  fetch data
//        if (Plus.PeopleApi.getCurrentPerson(mGoogleApiClient) != null) {
//            Person currentPerson = Plus.PeopleApi
//                    .getCurrentPerson(mGoogleApiClient);
//
//            String personName = currentPerson.getDisplayName();
//            String personGooglePlusProfile = currentPerson.getUrl();
//            Toast.makeText(this,personGooglePlusProfile+"hello", Toast.LENGTH_LONG).show();
//            Log.i("personName", personName);
//
//        }
        //     Person currentPerson = Plus.PeopleApi.getCurrentPerson(mGoogleApiClient);
//        String personPhotoUrl = currentPerson.getImage().getUrl();
//        NAME = getSharedPreferences("NAME", 0);
//        SharedPreferences.Editor editor;
//        editor = NAME.edit();
//
//        String picture=null;
//        String personGooglePlusProfile = null;
//        if (Plus.PeopleApi.getCurrentPerson(mGoogleApiClient) != null) {
//            Person currentPerson = Plus.PeopleApi.getCurrentPerson(mGoogleApiClient);
//            String personName = currentPerson.getDisplayName();
//            //     String personPhoto = currentPerson.getImage();
//
//            personGooglePlusProfile = currentPerson.getUrl();
//            picture=currentPerson.getImage().getUrl();
//
//
//        }
//
//        picture = picture.substring(0,
//                picture.length() - 2)
//                + "100";
//        //    Toast.makeText(this,picture, Toast.LENGTH_LONG).show();
//        editor.putString("NAME", picture);
//        editor.commit();
//
//        flag = getSharedPreferences("flag", 0);
//        SharedPreferences.Editor editor1;
//        editor1 = flag.edit();
//        editor1.putString("flag","g+");
//        editor1.commit();
//
//        skip1 = getSharedPreferences("skip1", 0);
//        SharedPreferences.Editor editors1;
//        editors1 = skip1.edit();
//        editors1.putInt("skip1",1);
//        editors1.commit();
//
//
//        skip2 = getSharedPreferences("skip2", 0);
//        SharedPreferences.Editor editors2;
//        editors2 = skip2.edit();
//        editors2.putInt("skip2",1);
//        editors2.commit();
//
//        logout = getSharedPreferences("logout", 0);
//        SharedPreferences.Editor editoro;
//        editoro = logout.edit();
//        editoro.putInt("logout",1);
//
//
//
//
//        Intent changeActivity = new Intent(this,Material_main.class);
//        changeActivity.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
//        startActivity(changeActivity);
//
//    }

//    @Override
//    public void onConnectionSuspended(int i) {
//
//    }
//
//    @Override
//    public void onClick(View view) {
//
//        if (view.getId() == R.id.sign_in_button) {
//            onSignInClicked();
//        }
//    }
//
//    @Override
//    public void onResult(People.LoadPeopleResult loadPeopleResult) {
//
//    }


}
