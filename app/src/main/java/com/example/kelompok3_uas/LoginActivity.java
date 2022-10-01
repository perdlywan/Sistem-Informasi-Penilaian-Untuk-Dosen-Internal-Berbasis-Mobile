package com.example.kelompok3_uas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    private EditText edUser;
    private EditText edPassword;
    private Context context;
    private Button btnLogin;
    private ProgressDialog pDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context = LoginActivity.this;
        pDialog = new ProgressDialog(context);
        edUser = findViewById(R.id.edUser);
        edPassword = findViewById(R.id.edPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
            }
        });
    }

    private void Login() {
        final String username = edUser.getText().toString().trim();
        final String password = edPassword.getText().toString().trim();
        pDialog.setMessage("Please Wait...");

        if (username.isEmpty()) {
            Toast.makeText(this, "Masukkan Username!", Toast.LENGTH_SHORT).show();
            return;
        } else if (password.isEmpty()) {
            Toast.makeText(this, "Masukkan Password!", Toast.LENGTH_SHORT).show();
            return;
        } else {
            showDialog();
            StringRequest stringRequest = new StringRequest(Request.Method.POST, KoneksiServer.LOGIN_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.contains(KoneksiServer.LOGIN_SUCCESS)) {
                                hideDialog();
                                gotoDashBoard();
                            } else {
                                hideDialog();
                                Toast.makeText(context, "Username atau Password yang dimasukkan salah!", Toast.LENGTH_LONG).show();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            hideDialog();
                            Toast.makeText(context, "Server tidak ditemukan", Toast.LENGTH_LONG).show();
                        }
                    }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put(KoneksiServer.KEY_USERNAME, username);
                    params.put(KoneksiServer.KEY_PASSWORD, password);
                    return params;
                }
            };
            Volley.newRequestQueue(this).add(stringRequest);
        }
    }

    private void gotoDashBoard() {
        Intent intent = new Intent(context, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();

    }
}