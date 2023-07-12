package com.example.myinstaclone.presentation.extantions

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Color
import android.util.TypedValue
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.AutoCompleteTextView
import android.widget.SearchView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.myinstaclone.R
import com.example.myinstaclone.presentation.models.user_image.ImageUi
import com.parse.ParseFile
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.text.SimpleDateFormat
import java.util.*

fun makeToast(message: String , context: Context) {
    Toast.makeText(context , message , Toast.LENGTH_SHORT).show()
}

  fun hasPermissions(context: Context , vararg permissions: String): Boolean =
    permissions.all {
        ActivityCompat.checkSelfPermission(context , it) == PackageManager.PERMISSION_GRANTED
    }

@SuppressLint("SimpleDateFormat")
 fun data():String{
    val currentDate = Date()
    val dateFormat = SimpleDateFormat("d MMMM HH:mm:ss")
    val dateString = dateFormat.format(currentDate)
    return  "Added at: $dateString"
}

 var countPost= 0

 fun isClick(view: View)= run {
     if (view.isClickable){
     countPost ++
 }
 }

val imageForEmpty = ImageUi(
    "File" ,
    "5f4e91fa2356ec1bc06fc0d3536192f1_profile_img.jpg" ,
    "https://parsefiles.back4app.com/19M1h2d0Ttcsdxdf09E1Q1ew3I4IO3s6TvMGbUWA/d1e8524a1135878edac3b7a855b71ffe_profile_img.jpg.jpg"
)

 fun View.hideKeyboard() {
    val inputManager =
        context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputManager.hideSoftInputFromWindow(windowToken , 0)
}

fun View.showView() {
    this.visibility = View.VISIBLE
}

fun View.hideView() {
    this.visibility = View.INVISIBLE
}

fun View.goneView() {
    this.visibility = View.GONE
}


lateinit var imagePostUi: ImageUi
fun parseFileToImage(file: ParseFile) {
    imagePostUi = ImageUi("File" , file.name , file.url)

}

lateinit var imageEditUi: ImageUi
fun parseFileToImag(file: ParseFile) {
    imageEditUi = ImageUi("File" , file.name , file.url)
}

inline fun Fragment.launchWhenViewStarted(
    crossinline block: suspend CoroutineScopeWrapper.() -> Unit
) = viewLifecycleOwner.lifecycleScope.launchWhenStarted {
    CoroutineScopeWrapper(this).block()
}

class CoroutineScopeWrapper(
 val scope: CoroutineScope ,
    var errorHandler: (Throwable) -> Unit = globalErrorHandler
) {
    fun <T> Flow<T>.observe(action: suspend (T) -> Unit) = this
        .onEach(action)
        .catch { errorHandler(it) }
        .launchIn(scope)

    companion object {
        var globalErrorHandler: (Throwable) -> Unit = { throw it }
    }
}

@SuppressLint("DiscouragedApi")
fun SearchView.setupTextSize() {
    val searchText = this.findViewById<View>(
        this.context.resources.getIdentifier(
            "android:id/search_src_text",
            null,
            null
        )
    ) as AutoCompleteTextView
   searchText.setTextColor(Color.WHITE)
    searchText.setTextSize(
        TypedValue.COMPLEX_UNIT_PX,
        resources.getDimensionPixelSize(R.dimen._13sp).toFloat()
    )
}
