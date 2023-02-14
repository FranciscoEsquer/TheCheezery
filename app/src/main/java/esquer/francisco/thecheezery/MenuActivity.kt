package esquer.francisco.thecheezery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var coldBtn: Button = findViewById(R.id.button_cold_drinks)
        var hotBtn: Button = findViewById(R.id.button_hot_drinks)
        var sweetBtn: Button = findViewById(R.id.button_sweets)
        var saltieBtn: Button = findViewById(R.id.button_salties)

        coldBtn.setOnClickListener {
            var intent: Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("type", 1)
            startActivity(intent)
        }

        hotBtn.setOnClickListener {
            var intent: Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("type", 2)
            startActivity(intent)
        }

        sweetBtn.setOnClickListener {
            var intent: Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("type", 3)
            startActivity(intent)
        }

        saltieBtn.setOnClickListener {
            var intent: Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("type", 4)
            startActivity(intent)
        }

    }
}