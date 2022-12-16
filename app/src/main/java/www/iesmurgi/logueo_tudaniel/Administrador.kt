package www.iesmurgi.logueo_tudaniel

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import www.iesmurgi.logueo_tudaniel.databinding.AdministradorBinding
import www.iesmurgi.logueo_tudaniel.databinding.UsuarioBinding

class Administrador: AppCompatActivity() {
    private lateinit var binding:AdministradorBinding
    var contador=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= AdministradorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btPulsar.setOnClickListener{contarClicks()}
        binding.btVolver.setOnClickListener { devolverValor() }
        mostrar()
    }

    fun mostrar() {
        val mibundle=intent.extras
        val nombre = mibundle?.getString("ADMINISTRADOR")
        val contra = mibundle?.getString("PASSWORD2")

        val tvUsuario  = binding.tvNombre
        val tvContra = binding.tvComentario

        tvUsuario.setText(nombre)
        tvContra.setText(contra)


    }

    fun contarClicks() {
        contador++
        binding.tvValor.setText(contador.toString())
    }

    fun devolverValor() {
        val enviar = Intent(this, MainActivity::class.java)
        var valoracion = binding.tvValor
        enviar.putExtra("DEVOLVER", valoracion.getText().toString())

        startActivity(enviar)
    }


}