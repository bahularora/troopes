package com.troopes.android;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.truecaller.android.sdk.ITrueCallback;
import com.truecaller.android.sdk.TrueButton;
import com.truecaller.android.sdk.TrueError;
import com.truecaller.android.sdk.TrueProfile;
import com.truecaller.android.sdk.TrueSDK;
import com.truecaller.android.sdk.TrueSdkScope;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements ITrueCallback {

    @BindView(R.id.true_button)
    FrameLayout trueButtonContainer;

    @BindView(R.id.com_truecaller_android_sdk_truebutton)
    TrueButton trueButton;

    private static final int RC_SIGN_IN = 123;
    private static final int RC_OTP = 111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initTrueCaller();
        if(TrueSDK.getInstance().isUsable()) {
            trueButtonContainer.setVisibility(View.VISIBLE);
        }
    }

    @OnClick(R.id.true_button)
    public void clickTrueButton() {
        trueButton.performClick();
    }

    @OnClick(R.id.fire_button)
    public void initFirebase() {
        List<String> permissions = new ArrayList<>();
        Collections.addAll(permissions, "public_profile","email");

        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.GoogleBuilder().build(),
                new AuthUI.IdpConfig.FacebookBuilder()
                        .setPermissions(permissions)
                        .build());

        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .build(),
                RC_SIGN_IN);
    }

    public void initTrueCaller() {
        TrueSdkScope trueScope = new TrueSdkScope.Builder(this, this)
                .consentMode(TrueSdkScope.CONSENT_MODE_FULLSCREEN )
                .consentTitleOption( TrueSdkScope.SDK_CONSENT_TITLE_VERIFY )
                .footerType( TrueSdkScope.FOOTER_TYPE_SKIP )
                .build();

        TrueSDK.init(trueScope);
    }

    public void initOtp() {
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.PhoneBuilder().build());

        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .build(),
                RC_OTP);
    }

    public void getFbData() {
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        if(accessToken!=null) {
            GraphRequest request = GraphRequest.newMeRequest(
                    accessToken,
                    new GraphRequest.GraphJSONObjectCallback() {
                        @Override
                        public void onCompleted(
                                JSONObject object,
                                GraphResponse response) {
                            try {
                                Toast.makeText(MainActivity.this, ""+object.getString("email"), Toast.LENGTH_SHORT).show();
                            } catch (JSONException e) {
                                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
            Bundle parameters = new Bundle();
            parameters.putString("fields", "email");
            request.setParameters(parameters);
            request.executeAsync();
        }
    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                // Successfully signed in
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if(user!=null) {
                    if(user.getProviderData().get(1).getProviderId().equals("facebook.com")) {
                        getFbData();
                    }
                    else {
                        Toast.makeText(this,user.getEmail(), Toast.LENGTH_SHORT).show();
                    }
                    initOtp();
                }
                // ...
            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
            }
        }
        else if(requestCode == RC_OTP) {
            if(resultCode == RESULT_OK) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if(user!=null) {
                    Toast.makeText(this, ""+user.getPhoneNumber(), Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, HomeActivity.class));
                }
            }
        }
        else {
            TrueSDK.getInstance().onActivityResultObtained( this,resultCode, data);
        }
    }

    @Override
    public void onSuccessProfileShared(@NonNull TrueProfile trueProfile) {
        Toast.makeText(this, trueProfile.phoneNumber, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, trueProfile.email, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, HomeActivity.class));
    }

    @Override
    public void onFailureProfileShared(@NonNull TrueError trueError) {
        Toast.makeText(this, trueError.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onOtpRequired() {
        Toast.makeText(this, "OTP REQUIRED", Toast.LENGTH_SHORT).show();
    }
}
