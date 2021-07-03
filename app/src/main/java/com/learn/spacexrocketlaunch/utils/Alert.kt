package com.learn.spacexrocketlaunch.utils

import android.content.Context
import androidx.appcompat.app.AlertDialog

interface OnProceedClickListener {
    fun proceed()
}

fun showAlert(
    context: Context, message: String, title: String, listener: OnProceedClickListener,
) {
    val dialogBuilder = AlertDialog.Builder(context)

    dialogBuilder.setMessage(message)
        .setCancelable(true)
        .setPositiveButton("Proceed") { dialog, id ->
            listener.proceed()
            dialog.dismiss()
        }

    val alert = dialogBuilder.create()
    alert.setTitle(title)
    alert.show()
}

const val DUMMY_TEXT =
    "\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse id leo lorem. Nunc molestie, lectus et sodales egestas, nisl metus fringilla metus, quis mollis ex dolor sit amet ipsum.\""
const val WELCOME = "Welcome"
