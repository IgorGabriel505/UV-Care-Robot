package com.example.uv_carerobot;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Tela_Login extends AppCompatActivity {

    // =====================================================
    // ELEMENTOS DA TELA
    // =====================================================

    private EditText editEmail;
    private EditText editSenha;

    private Button btnLogin;

    private TextView textErro;

    private ProgressBar progressLogin;

    private CheckBox checkLembrarLogin;


    // =====================================================
    // FIREBASE
    // =====================================================

    private FirebaseAuth firebaseAuth;


    // =====================================================
    // PREFERÊNCIAS
    // =====================================================

    private SharedPreferences preferences;

    private static final String PREFS = "uvcare_prefs";
    private static final String LEMBRAR_LOGIN = "lembrar_login";


    // =====================================================
    // ON CREATE
    // =====================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tela_login);


        // =====================================================
        // INICIALIZA FIREBASE
        // =====================================================

        firebaseAuth = FirebaseAuth.getInstance();


        // =====================================================
        // INICIALIZA PREFERÊNCIAS
        // =====================================================

        preferences = getSharedPreferences(
                PREFS,
                MODE_PRIVATE
        );


        // =====================================================
        // CONECTA JAVA COM XML
        // =====================================================

        editEmail = findViewById(R.id.editEmail);

        editSenha = findViewById(R.id.editSenha);

        btnLogin = findViewById(R.id.btnLogin);

        textErro = findViewById(R.id.textErro);

        progressLogin = findViewById(R.id.progressLogin);

        checkLembrarLogin = findViewById(R.id.checkLembrarLogin);


        // =====================================================
        // VERIFICA SE "LEMBRAR LOGIN" ESTÁ ATIVADO
        // =====================================================

        boolean lembrarLogin = preferences.getBoolean(
                LEMBRAR_LOGIN,
                false
        );

        checkLembrarLogin.setChecked(lembrarLogin);


        // =====================================================
        // VERIFICA SESSÃO DO FIREBASE
        // =====================================================

        FirebaseUser usuarioAtual =
                firebaseAuth.getCurrentUser();


        // Se marcou "Lembrar login" e ainda existe
        // uma sessão válida, entra automaticamente.

        if (lembrarLogin && usuarioAtual != null) {

            abrirPainel();

            return;
        }


        // Se NÃO marcou "Lembrar login",
        // garante que nenhuma sessão anterior continue ativa.

        if (!lembrarLogin) {

            firebaseAuth.signOut();
        }


        // =====================================================
        // BOTÃO ENTRAR
        // =====================================================

        btnLogin.setOnClickListener(v -> {

            realizarLogin();

        });


        // =====================================================
        // BOTÃO "CONCLUÍDO" DO TECLADO
        // =====================================================

        editSenha.setOnEditorActionListener(
                (v, actionId, event) -> {

                    if (actionId == EditorInfo.IME_ACTION_DONE) {

                        realizarLogin();

                        return true;
                    }

                    return false;
                }
        );
    }


    // =========================================================
    // REALIZA LOGIN
    // =========================================================

    private void realizarLogin() {

        String email =
                editEmail
                        .getText()
                        .toString()
                        .trim();


        String senha =
                editSenha
                        .getText()
                        .toString();


        // Limpa mensagem de erro anterior

        textErro.setText("");


        // =====================================================
        // VERIFICA E-MAIL
        // =====================================================

        if (email.isEmpty()) {

            editEmail.setError(
                    "Digite seu e-mail."
            );

            editEmail.requestFocus();

            return;
        }


        // =====================================================
        // VERIFICA SENHA
        // =====================================================

        if (senha.isEmpty()) {

            editSenha.setError(
                    "Digite sua senha."
            );

            editSenha.requestFocus();

            return;
        }


        // =====================================================
        // MOSTRA CARREGAMENTO
        // =====================================================

        mostrarCarregamento(true);


        // =====================================================
        // LOGIN FIREBASE
        // =====================================================

        firebaseAuth
                .signInWithEmailAndPassword(
                        email,
                        senha
                )
                .addOnCompleteListener(
                        this,
                        task -> {

                            mostrarCarregamento(false);


                            // =========================================
                            // LOGIN CORRETO
                            // =========================================

                            if (task.isSuccessful()) {

                                boolean lembrar =
                                        checkLembrarLogin.isChecked();


                                // Salva a escolha do usuário

                                preferences
                                        .edit()
                                        .putBoolean(
                                                LEMBRAR_LOGIN,
                                                lembrar
                                        )
                                        .apply();


                                abrirPainel();

                            }


                            // =========================================
                            // LOGIN INCORRETO
                            // =========================================

                            else {

                                textErro.setText(
                                        "E-mail ou senha incorretos."
                                );
                            }
                        }
                );
    }


    // =========================================================
    // ABRE O PAINEL PRINCIPAL
    // =========================================================

    private void abrirPainel() {

        Intent intent = new Intent(
                Tela_Login.this,
                MainActivity.class
        );


        // Evita deixar várias telas de login abertas
        intent.addFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TOP
        );


        startActivity(intent);

        finish();
    }


    // =========================================================
    // MOSTRA / ESCONDE CARREGAMENTO
    // =========================================================

    private void mostrarCarregamento(
            boolean carregando
    ) {

        if (carregando) {

            progressLogin.setVisibility(
                    View.VISIBLE
            );

            btnLogin.setEnabled(false);

            btnLogin.setText(
                    "Entrando..."
            );

            editEmail.setEnabled(false);

            editSenha.setEnabled(false);

            checkLembrarLogin.setEnabled(false);

        } else {

            progressLogin.setVisibility(
                    View.GONE
            );

            btnLogin.setEnabled(true);

            btnLogin.setText(
                    "Entrar"
            );

            editEmail.setEnabled(true);

            editSenha.setEnabled(true);

            checkLembrarLogin.setEnabled(true);
        }
    }
}