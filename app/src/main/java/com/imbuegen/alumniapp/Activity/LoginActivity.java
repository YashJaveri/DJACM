package com.imbuegen.alumniapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.imbuegen.alumniapp.Service.SFHandler;

import java.util.Arrays;
import java.util.List;import com.imbuegen.alumniapp.R;

public class LoginActivity extends BaseActivity {

    private static final int RC_SIGN_IN = 123;
    private static final int RC_SIGN_IN_ALUMNI = 123;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }
    @Override
    protected void onResume() {
        super.onResume();
    }


    public void signInStudent(View v) {
                List<AuthUI.IdpConfig> providers = Arrays.asList(
                        new AuthUI.IdpConfig.PhoneBuilder().build(),
                        new AuthUI.IdpConfig.GoogleBuilder().build());
                startActivityForResult(
                        AuthUI.getInstance()
                                .createSignInIntentBuilder()
                                .setTheme(R.style.CustomTheme)
                                .setAvailableProviders(providers)
                                .build(),
                        RC_SIGN_IN);
    }
    public void signInAlumni(View v) {
        startActivity(new Intent(this,AlumniLoginActivity.class));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);
            if (resultCode == RESULT_OK) {
                // Successful sign in
                setContentView(R.layout.loading_screen);
                SFHandler.setString(getSharedPreferences("Auth",MODE_PRIVATE),SFHandler.USER_KEY,"Student");
                Toast.makeText(this, "Signed IN", Toast.LENGTH_SHORT).show();
                goToStudentScreen();
            } else {
                Toast.makeText(this, "Student Sign in Uncessfull", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void goToStudentScreen() {
        Intent i = new Intent(this,DepartmentsActivity.class);
        startActivity(i);
        finish();
    }
}
