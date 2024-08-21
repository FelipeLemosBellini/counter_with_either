package com.example.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import arrow.core.Either
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var counterUseCase: CounterUseCase = CounterUseCase()

        var btnDecrement: Button = findViewById(R.id.btnDecrement)
        var btnIncrement: Button = findViewById(R.id.btnIncrement)
        var txtCounter: TextView = findViewById(R.id.txtCounter)

        btnDecrement.setOnClickListener {
            var response: Either<Error, Unit> = counterUseCase.decrement()
            response.fold({

                Snackbar.make(findViewById(android.R.id.content), it.error, Snackbar.LENGTH_SHORT)
                    .show()

            }, {
                //faz nada se der certo
            })
            txtCounter.text = counterUseCase.getCounter()

        }
        btnIncrement.setOnClickListener {
            counterUseCase.increment()
            txtCounter.text = counterUseCase.getCounter()
        }
    }
}
