package www.iesmurgi.logueo_tudaniel

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import www.iesmurgi.logueo_tudaniel.databinding.AdministradorBinding
import www.iesmurgi.logueo_tudaniel.databinding.UsuarioBinding

class Usuario:AppCompatActivity() {
    private lateinit var binding: UsuarioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= UsuarioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btVolver.setOnClickListener { devolver()}
        mostrar()
        binding.ratingBar.setOnRatingBarChangeListener { ratingBar, fl, b -> valoracion() }
    }

    fun mostrar() {
        val mibundle=intent.extras
        val nombre = mibundle?.getString("USUARIO")
        val contra = mibundle?.getString("PASSWORD")

        val tvUsuario  = binding.tvNombre
        val tvContra = binding.tvPass


        tvUsuario.setText(nombre)
        tvContra.setText(contra)


    }

    fun valoracion() {
        val barra = binding.ratingBar
        var valoracion = binding.tvValor
        var comentario = binding.tvComentario

        valoracion.setText(barra.getRating().toString())

        if (barra.getRating().toString().equals("2.5")) {
            comentario.setText("¡Gracias por tu valoracion!")
        } else if (barra.getRating() < 2.5) {
            comentario.setText("¡Intentaremos mejorar!")
        } else if (barra.getRating() > 2.5) {
            comentario.setText("¡Seguiremos dandote el mejor servicio!")
        }
    }

    fun devolver() {
        val enviar = Intent(this, MainActivity::class.java)
        var valoracion = binding.tvValor
        enviar.putExtra("DEVOLVER", valoracion.getText().toString())

        startActivity(enviar)
    }

}