package com.example.updown

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.*
import android.graphics.drawable.Icon
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationManagerCompat
import com.example.updown.databinding.FragmentHomeBinding
import com.example.updown.databinding.UpdownFragmentBinding

class Home : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val notificationManager by lazy {
        NotificationManagerCompat.from(requireContext())
    }
    private val channel by lazy {
        val name = getString(R.string.app_name)
        val descriptionText = getString(R.string.Speed)
        val importance = NotificationManager.IMPORTANCE_LOW
        val channel = NotificationChannel("121", name, importance).apply {
            description = descriptionText
        }
        // Register the channel with the system
        notificationManager.createNotificationChannel(channel)
        channel
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val handlerThread = HandlerThread("data")
        val handler = /*handlerThread.getThreadHandler()*/Handler()
        val data = UpDownData()

        val mBuilder = Notification.Builder(context, channel.id)
            .setOngoing(true)

        handler.post {
            updateData(data, handler, mBuilder)
        }

    }

    private fun updateData(
        data: UpDownData,
        handler: Handler,
        mBuilder: Notification.Builder
    ) {


        data.updateData()

        val up = data.getSpeed(TYPE.TYPE_UP)
        val down = data.getSpeed(TYPE.TYPE_DOWN)
        val total = data.getSpeed(TYPE.TYPE_ALL)


        binding.apply {
            First.text = "Download : ${down.first} ${down.second}"
            Second.text = "Upload : ${up.first} ${up.second}"
        }

        val bitmap = createBitmapFromString("${total.first}",total.second)
        val icon = Icon.createWithBitmap(bitmap)
        binding.img.setImageBitmap(bitmap)
        mBuilder.setSmallIcon(icon)
        mBuilder.setContentText("${binding.First.text.trim()} \t ${ binding.Second.text.trim()}")
        // mBuilder.setSmallIcon(R.drawable.ic_launcher_background)
        val notification = mBuilder.build()
        notificationManager.notify(121,notification)
        handler.postDelayed({updateData(data, handler, mBuilder)},1000)

        val notificationIntent = Intent(context, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            context, 0,
            notificationIntent, 0
        )
    }
    private fun createBitmapFromString(speed: String, units: String): Bitmap? {
        val pixels = resources.getDimensionPixelSize(R.dimen.dp_24)
        val paint = Paint()
        //paint.isFakeBoldText = true
        paint.typeface = Typeface.DEFAULT_BOLD//create(Typeface.DEFAULT,800,false)
        paint.isAntiAlias = true
        paint.letterSpacing = -0.1f
        paint.textSize = pixels*0.65F
        paint.textAlign = Paint.Align.CENTER
        val unitsPaint = Paint()
        unitsPaint.isAntiAlias = true
        unitsPaint.textSize = pixels*0.45F // size is in pixels
        unitsPaint.textAlign = Paint.Align.CENTER
        unitsPaint.typeface = Typeface.DEFAULT_BOLD
        val textBounds = Rect()
        paint.getTextBounds(speed, 0, speed.length, textBounds)
        val unitsTextBounds = Rect()
        unitsPaint.getTextBounds(units, 0, units.length, unitsTextBounds)
        val width: Int =
            if (textBounds.width() > unitsTextBounds.width()) textBounds.width() else unitsTextBounds.width()
        val bitmap = Bitmap.createBitmap(pixels, pixels, Bitmap.Config.ARGB_8888 )
        val canvas = Canvas(bitmap)
        //canvas.drawColor(R.color.purple_500)
        canvas.drawText(speed, pixels/2f, pixels*0.6F, paint)
        canvas.drawText(units, pixels/2f, pixels.toFloat(), unitsPaint)

        return bitmap
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

}