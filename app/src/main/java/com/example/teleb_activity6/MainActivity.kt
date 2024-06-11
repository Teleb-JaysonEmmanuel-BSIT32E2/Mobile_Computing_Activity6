package com.example.teleb_activity6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.teleb_activity6.data.Datasource
import com.example.teleb_activity6.model.Affirmation
import com.example.teleb_activity6.ui.theme.TelebActivity6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TelebActivity6Theme {
               AffirmationApp()
            }
        }
    }
}

@Composable
fun AffirmationApp(){
    AffirmationList(
        affirmationList = Datasource().loadAffirmations()
    )
}


@Composable
fun AffirmationList(affirmationList: List<Affirmation>,modifier: Modifier = Modifier){
    LazyColumn(modifier = modifier) {
        items(affirmationList){affirmation ->
            AffirmationCard(
                affirmation = affirmation,
                modifier = Modifier.padding(16.dp)
            )

        }
    }
}


@Composable
fun AffirmationCard(affirmation: Affirmation, modifier: Modifier){
    Card(modifier = modifier) {
        Column {
            Image(painter = painterResource(affirmation.imageResourceId),
                contentDescription = stringResource(affirmation.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(text = LocalContext.current.getString(affirmation.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.h6
            )
        }
    }
}

@Preview
@Composable
private fun AffirmationCardPreview(){
    AffirmationApp()
}