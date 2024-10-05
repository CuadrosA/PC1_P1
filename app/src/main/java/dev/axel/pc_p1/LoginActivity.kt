package dev.axel.pc_p1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etEmail: EditText = findViewById((R.id.etEmail))
        val etPassword: EditText = findViewById(R.id.etPassword)
        val btLogin: Button = findViewById(R.id.btLogin)
        val emailSuccess = "invitado@android.com"
        val passwordSuccess = "invitado123"

        btLogin.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            // Aquí se implementa la lógica de autenticación
            if(email == emailSuccess && password == passwordSuccess) {
                // Autenticación exitosa, puedes redirigir al usuario a la siguiente
                val intent = Intent(this, MainActivity::class.java)
                startActivity((intent))
            } else {
                // En caso de autenticación fallida, mostrar un mensaje de error
                // Mensaje de Snackbar

                val rootView = findViewById<View>(android.R.id.content)

                Snackbar.make(rootView, "Credenciales incorrectas", Snackbar.LENGTH_LONG).show();

                // etEmail.error = "Credenciales incorrectas"
                etPassword.error == "Credenciales incorrectas"
                etEmail.requestFocus()
            }
        }
    }
}