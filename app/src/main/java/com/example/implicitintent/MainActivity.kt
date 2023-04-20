package com.example.implicitintent

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var btnEmail : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webButton = findViewById<Button>(R.id.web1)
        val browse = findViewById<EditText>(R.id.etBrowse)
        val cameraButton = findViewById<CardView>(R.id.cardCamera)
        val btnDial = findViewById<Button>(R.id.btnDial)
        val btnMsg = findViewById<Button>(R.id.btnMsg)
        val btnEmail = findViewById<Button>(R.id.btnEmail)
        val phone = findViewById<EditText>(R.id.etPhone)

            val url = browse.text.toString()
            webButton.setOnClickListener {
                if(url.isEmpty()) {
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("URL MISMATCHING")
                    builder.setMessage("Please enter a Url")
                      //builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))
                    builder.setIcon(R.drawable.baseline_error_24)
                    builder.setPositiveButton(android.R.string.yes) { _, _ ->
                        Toast.makeText(applicationContext,
                            android.R.string.yes, Toast.LENGTH_SHORT).show()
                    }

                    builder.setNegativeButton(android.R.string.no) { _, _ ->
                        Toast.makeText(applicationContext,
                            android.R.string.no, Toast.LENGTH_SHORT).show()
                    }
                    builder.show()
                }
                else if(!url.startsWith("http:")){
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("URL MISMATCHING")
                    builder.setMessage("Please enter a Valid URL")
                //builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))
                    builder.setIcon(R.drawable.baseline_error_24)
                    builder.setPositiveButton(android.R.string.yes) { _, _ ->
                        Toast.makeText(applicationContext,
                            android.R.string.yes, Toast.LENGTH_SHORT).show()
                    }
                    builder.setNegativeButton(android.R.string.no) { _, _ ->
                        Toast.makeText(applicationContext,
                            android.R.string.no, Toast.LENGTH_SHORT).show()
                    }
                    builder.show()
                }
            val intent = Intent(Intent.ACTION_VIEW)
            startActivity(intent)
        }
        cameraButton.setOnClickListener{
              val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
              startActivity(intent)
        }
        btnDial.setOnClickListener{
            val phNo = phone.text.toString()
            if(phNo.isEmpty()){
                //Dialog to tell user to enter a Valid PhoneNumber
            }
            val intent = Intent(Intent.ACTION_VIEW,Uri.parse("tel:$phNo"))
            startActivity(intent)
        }
        btnMsg.setOnClickListener{
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("sms to:"+Uri.encode("+916394031829"))
            intent.putExtra("sms_body", "Please solve this issue asap.")
            startActivity(intent)
        }
        btnEmail.setOnClickListener{
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto: vikasgup074@gmail.com")
            intent.putExtra(Intent.EXTRA_EMAIL, "test")
            intent.putExtra(Intent.EXTRA_SUBJECT, "Hello World")
            startActivity(intent)
        }
        }



}