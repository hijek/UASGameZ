package dzaki201804016.trpl.pei.gamez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash2)
        Handler().postDelayed({
            val pindah = Intent(this, MainActivity::class.java)
            startActivity(pindah)
            finish()
        }, 2000)
    }
}