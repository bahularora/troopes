package com.troopes.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.accountkit.Account;
import com.facebook.accountkit.AccountKit;
import com.facebook.accountkit.AccountKitCallback;
import com.facebook.accountkit.AccountKitError;
import com.facebook.accountkit.AccountKitLoginResult;
import com.facebook.accountkit.ui.AccountKitActivity;
import com.facebook.accountkit.ui.AccountKitConfiguration;
import com.facebook.accountkit.ui.LoginType;

public class MainActivity extends BaseActivity {

    public static int APP_REQUEST_CODE = 99;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        super.init();
        hideToolbar();
        Button fbButton = findViewById(R.id.fb_button);
        fbButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(MainActivity.this, AccountKitActivity.class);
                AccountKitConfiguration.AccountKitConfigurationBuilder configurationBuilder =
                        new AccountKitConfiguration.AccountKitConfigurationBuilder(
                                LoginType.PHONE,
                                AccountKitActivity.ResponseType.TOKEN); // or .ResponseType.TOKEN
                // ... perform additional configuration ...
                intent.putExtra(
                        AccountKitActivity.ACCOUNT_KIT_ACTIVITY_CONFIGURATION,
                        configurationBuilder.build());
                startActivityForResult(intent, APP_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(
            final int requestCode,
            final int resultCode,
            final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == APP_REQUEST_CODE) { // confirm that this response matches your request
            AccountKitLoginResult loginResult = data.getParcelableExtra(AccountKitLoginResult.RESULT_KEY);
            String toastMessage;
            if (loginResult.getError() != null) {
                toastMessage = loginResult.getError().getErrorType().getMessage();
            } else if (loginResult.wasCancelled()) {
                toastMessage = "Login Cancelled";
            } else {
                if (loginResult.getAccessToken() != null) {
                    toastMessage = "Success:" + loginResult.getAccessToken().getAccountId();
                } else {
                    toastMessage = String.format(
                            "Success:%s...",
                            loginResult.getAuthorizationCode().substring(0,10));
                }

                AccountKit.getCurrentAccount(new AccountKitCallback<Account>() {
                    @Override
                    public void onSuccess(Account account) {
                        Toast.makeText(MainActivity.this,account.getEmail(),Toast.LENGTH_SHORT).show();
                        Toast.makeText(MainActivity.this, account.getPhoneNumber().getPhoneNumber(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(AccountKitError accountKitError) {

                    }
                });
                // If you have an authorization code, retrieve it from
                // loginResult.getAuthorizationCode()
                // and pass it to your server and exchange it for an access token.

                // Success! Start your next activity...
            }

            // Surface the result to your user in an appropriate way.
            Toast.makeText(
                    this,
                    toastMessage,
                    Toast.LENGTH_LONG)
                    .show();
        }
    }
}
