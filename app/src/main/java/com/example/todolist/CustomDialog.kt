package com.example.todolist

import android.app.Dialog
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText

class CustomDialog (var activity: MainActivity) : Dialog(activity), View.OnClickListener {

    var yes: Button? = null
    var no: Button? = null
    private lateinit var inputField : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_template)
        inputField = findViewById(R.id.dialogInput)

        val lp = WindowManager.LayoutParams()
        lp.copyFrom(this.window?.attributes)
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT
        lp.gravity = Gravity.CENTER
        this.window?.attributes = lp

        yes = findViewById(R.id.dialogOkButton)
        no = findViewById(R.id.dialogCancelButton)
        yes?.setOnClickListener(this)
        no?.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.dialogOkButton -> {
                val inputResult = inputField.text
                activity.addItem(inputResult.toString())
                dismiss()
            }
            R.id.dialogCancelButton -> dismiss()
            else -> {
            }
        }
        dismiss()
    }

    }


