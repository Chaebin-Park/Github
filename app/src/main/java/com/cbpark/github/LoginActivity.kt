package com.cbpark.github

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.util.Property
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.cbpark.github.databinding.ActivityLoginBinding
import kotlin.coroutines.CoroutineContext
import kotlin.run

class LoginActivity : AppCompatActivity() {

    private val bind: ActivityLoginBinding by lazy { ActivityLoginBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bind.root)

        animate(bind.ivLogo, View.TRANSLATION_Y, -250f)
        animate(bind.etId, View.TRANSLATION_Y, -200f)
        animate(bind.btnLogin, View.TRANSLATION_Y, -200f)

        bind.btnLogin.setOnClickListener {
            if (!bind.etId.text.isBlank() || !bind.etId.text.isEmpty()) {
                startActivity(
                    Intent(this@LoginActivity, HomeActivity::class.java).putExtra(
                        "data",
                        bind.etId.text.toString()
                    )
                )
            }
        }
    }

    private fun animate(view: View, property: Property<View, Float>, distance: Float) {

        ObjectAnimator.ofFloat(view, property, distance)
            .apply {
                duration = 2000
            }
            .start()


        view.visibility = View.VISIBLE
    }
}