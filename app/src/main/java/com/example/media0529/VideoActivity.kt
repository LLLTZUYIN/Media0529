package com.example.media0529

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.example.media0529.ui.theme.Media0529Theme

class VideoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Media0529Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2("第二頁")
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    val link = "https://redirector.googlevideo.com/videoplayback?expire=1716996006&ei=RvNWZpvgJ8O-6dsPkNO6qAQ&ip=2a01%3A4f8%3A242%3A16d9%3A%3A2&id=o-AJNO22PDohCPqgP2mCeGEmix8M5B8hPYZH8tg4TujmSw&itag=22&source=youtube&requiressl=yes&xpc=EgVo2aDSNQ%3D%3D&mh=5v&mm=31%2C29&mn=sn-4g5edndz%2Csn-4g5e6ns7&ms=au%2Crdu&mv=m&mvi=4&pl=44&initcwndbps=497500&siu=1&vprv=1&svpuc=1&mime=video%2Fmp4&rqh=1&cnr=14&ratebypass=yes&dur=505.103&lmt=1680519327824640&mt=1716974203&fvip=5&c=ANDROID_TESTSUITE&txp=4532434&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cxpc%2Csiu%2Cvprv%2Csvpuc%2Cmime%2Crqh%2Ccnr%2Cratebypass%2Cdur%2Clmt&sig=AJfQdSswRQIhAKtHAdDm80AvYRZ393pMBMt83sbJK43D9qlwR3RbsjncAiBaPTaFwKurkymXE5QPJGFjj8HY3UL1KJK089wciYqabg%3D%3D&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AHWaYeowRAIgaheEdFHy0nqfoC5Zm5qFblEmRwhK7ZpVqbrL2uAk-TYCIGwhk-J6OMJldGoAKp593LagIIGujW0pdkQ7fVf9wyIq&range=0-46300887&title=X2Download.com-[2020%E6%9C%80%E5%A5%BD%E7%AC%91]#7%20%E8%B6%85%E7%88%86%E7%AC%91%20,%20%E7%AC%91%E5%88%B0%E4%BB%A4%E4%BA%BA%E5%99%B4%E9%A3%AF%E7%9A%84%22%E5%8B%95%E7%89%A9%E6%90%9E%E7%AC%91%E8%A6%96%E9%A0%BB%22%E5%90%88%E9%9B%86%20#7%20%7C%20%E7%AC%91%E9%BB%9E%E5%85%A8%E9%96%8B%20%5E%5E%20%7Cfunny%20video/funny%20animals/%20cat/dog/pet/"
    val exoPlayer = ExoPlayer.Builder(context).build()

    val mediaItem = MediaItem.fromUri(android.net.Uri.parse(link))
    exoPlayer.setMediaItem(mediaItem)

    val playerView = PlayerView(context)
    playerView.player = exoPlayer
    DisposableEffect(AndroidView(factory = {playerView})){
        exoPlayer.prepare()
        exoPlayer.playWhenReady = true

        onDispose{
            exoPlayer.release()
        }
    }

    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Media0529Theme {
        Greeting2("Android")
    }
}