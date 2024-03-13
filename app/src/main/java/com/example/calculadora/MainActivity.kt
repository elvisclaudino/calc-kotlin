import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadora.R

class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        resultTextView = findViewById(R.id.resultTextView)
    }

    fun performOperation(view: View) {
        val number1 = editText.text.toString().toDoubleOrNull()
        val number2 = 5.0 // you can replace this with another value or retrieve it from another EditText

        when (view.id) {
            R.id.btnAdd -> displayResult(number1?.plus(number2))
            R.id.btnSubtract -> displayResult(number1?.minus(number2))
            R.id.btnMultiply -> displayResult(number1?.times(number2))
            R.id.btnDivide -> {
                if (number2 != 0.0) {
                    displayResult(number1?.div(number2))
                } else {
                    displayResult(null)
                    resultTextView.text = "Cannot divide by zero"
                }
            }
        }
    }

    private fun displayResult(result: Double?) {
        resultTextView.text = "Result: ${result ?: "Invalid input"}"
    }
}
