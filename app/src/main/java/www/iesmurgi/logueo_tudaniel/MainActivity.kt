package www.iesmurgi.logueo_tudaniel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Toast
import www.iesmurgi.logueo_tudaniel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener { accederUsuario() }
        binding.etNombreAp.error = "Debe introducir el nombre de usuario"
        binding.etNombreAp.requestFocus()
        binding.etPassword.error="Debe introducir la contraseña"
        binding.etPassword.requestFocus()
        mostrarDevolUsu()

        val imagen = binding.ivImagen
        //Animaciones
        val escala = AnimationUtils.loadAnimation(this, R.anim.escala)
        imagen.startAnimation(escala)

    }

    fun accederUsuario() {

        var nombre = binding.etNombreAp
        var contrasenia = binding.etPassword


       if (nombre.getText().toString().equals(getString(R.string.administrador)) &&
           contrasenia.getText().toString().equals(getString(R.string.contraseñaAdmin))) {
            val enviar = Intent(this, Usuario::class.java)

            enviar.putExtra("USUARIO", nombre.getText().toString())
            enviar.putExtra("PASSWORD", contrasenia.getText().toString())

            Toast.makeText(this, "Concedido el acceso al administrador", Toast.LENGTH_SHORT).show()

            startActivity(enviar)

        } else if (nombre.getText().toString().equals(getString(R.string.usuario)) &&
            contrasenia.getText().toString().equals(getString(R.string.contraseñaUsuario))) {
            val enviar = Intent(this, Administrador::class.java)

            enviar.putExtra("ADMINISTRADOR", nombre.getText().toString())
            enviar.putExtra("PASSWORD2", contrasenia.getText().toString())

            Toast.makeText(this, "Concedido el acceso al usuario", Toast.LENGTH_SHORT).show()

            startActivity(enviar)

        }else if (nombre.getText().toString().equals(getString(R.string.usuario2)) &&
           contrasenia.getText().toString().equals(getString(R.string.contraseñaUsuario2))) {
           val enviar = Intent(this, Administrador::class.java)

           enviar.putExtra("ADMINISTRADOR", nombre.getText().toString())
           enviar.putExtra("PASSWORD2", contrasenia.getText().toString())

           Toast.makeText(this, "Concedido el acceso al usuario", Toast.LENGTH_SHORT).show()

           startActivity(enviar)

       } else if (nombre.getText().toString().equals(getString(R.string.administrador2)) &&
           contrasenia.getText().toString().equals(getString(R.string.contraseñaAdmin2))) {
           val enviar = Intent(this, Usuario::class.java)

           enviar.putExtra("USUARIO", nombre.getText().toString())
           enviar.putExtra("PASSWORD", contrasenia.getText().toString())

           Toast.makeText(this, "Concedido el acceso al administrador", Toast.LENGTH_SHORT).show()

           startActivity(enviar)

       } else {
            Toast.makeText(this, "Datos Incorrectos", Toast.LENGTH_SHORT).show()
        }
    }


    fun mostrarDevolUsu() {
        val mibundle=intent.extras
        val nombre = mibundle?.getString("DEVOLVER")

        val tvUsuario  = binding.tvDevuelto

        tvUsuario.setText("Valor: " + nombre)
    }


}